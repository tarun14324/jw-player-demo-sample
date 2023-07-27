package com.jwplayer.opensourcedemo

import android.content.res.Configuration
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.cast.framework.CastContext
import com.jwplayer.pub.api.JWPlayer
import com.jwplayer.pub.api.configuration.PlayerConfig
import com.jwplayer.pub.api.events.EventType
import com.jwplayer.pub.api.events.FullscreenEvent
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnFullscreenListener
import com.jwplayer.pub.api.license.LicenseUtil
import com.jwplayer.pub.view.JWPlayerView

class JWPlayerViewExample : AppCompatActivity(), OnFullscreenListener {
    private var mPlayerView: JWPlayerView? = null
    private var mCastContext: CastContext? = null
    private var mCallbackScreen: CallbackScreen? = null
    private var mPlayer: JWPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jwplayerview)

        // TODO: Add your license key
        LicenseUtil().setLicenseKey(this, "Ai0ZRuaM2EmDzgIy8QLZv08BxzZzXjw2Zg3W4XCnX9fnU33W")
        mPlayerView = findViewById(R.id.jwplayer)
        mPlayer = mPlayerView.getPlayer()


        // Handle hiding/showing of ActionBar
        mPlayer.addListener(EventType.FULLSCREEN, this)

        // Keep the screen on during playback
        KeepScreenOnHandler(mPlayer, window)

        // Event Logging
        mCallbackScreen = findViewById(R.id.callback_screen)
        mCallbackScreen.registerListeners(mPlayer)

        // Load a media source
        val config = PlayerConfig.Builder()
            .playlistUrl("https://cdn.jwplayer.com/v2/media/1sc0kL2N?format=json")
            .build()
        mPlayer.setup(config)

        // Get a reference to the CastContext
        mCastContext = CastContext.getSharedInstance(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (!mPlayer!!.isInPictureInPictureMode) {
            val isFullscreen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
            mPlayer!!.setFullscreen(isFullscreen, true)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // Exit fullscreen when the user pressed the Back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mPlayer!!.fullscreen) {
                mPlayer!!.setFullscreen(false, true)
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onFullscreen(fullscreenEvent: FullscreenEvent) {
        val actionBar = supportActionBar
        if (actionBar != null) {
            if (fullscreenEvent.fullscreen) {
                actionBar.hide()
            } else {
                actionBar.show()
            }
        }
    }
}