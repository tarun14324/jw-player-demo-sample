package com.jwplayer.opensourcedemo

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.cast.framework.CastButtonFactory
import com.jwplayer.pub.api.JWPlayer
import com.jwplayer.pub.api.JWPlayerSupportFragment
import com.jwplayer.pub.api.configuration.PlayerConfig

class JWPlayerFragmentExample : AppCompatActivity() {
    private lateinit var mPlayerFragment: JWPlayerSupportFragment
    private lateinit var mPlayer: JWPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jwplayerfragment)

        // Construct a new JWPlayerSupportFragment (since we're using AppCompatActivity)
        mPlayerFragment = JWPlayerSupportFragment.newInstance(
            PlayerConfig.Builder()
                .file("https://playertest.longtailvideo.com/adaptive/bipbop/gear4/prog_index.m3u8")
                .build()
        )

        // Attach the Fragment to our layout
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.fragment_container, mPlayerFragment)
        ft.commit()

        // Make sure all the pending fragment transactions have been completed, otherwise
        // mPlayerFragment.getPlayer() may return null
        fm.executePendingTransactions()

        // Get a reference to the JWPlayerView from the fragment
        mPlayer = mPlayerFragment.player

        // Keep the screen on during playback
        KeepScreenOnHandler(mPlayer, window)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // Exit fullscreen when the user pressed the Back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mPlayer.fullscreen) {
                mPlayer.setFullscreen(false, true)
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_jwplayerfragment, menu)

        // Register the MediaRouterButton
        CastButtonFactory.setUpMediaRouteButton(
            applicationContext, menu,
            R.id.media_route_menu_item
        )
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.switch_to_view -> {
                val i = Intent(this, JWPlayerViewExample::class.java)
                startActivity(i)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}