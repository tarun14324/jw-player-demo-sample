package com.jwplayer.opensourcedemo

import android.widget.CompoundButton
import com.jwplayer.pub.api.JWPlayer
import com.jwplayer.pub.api.events.EventListener
import com.jwplayer.pub.api.events.EventType

class EventCheckChangedListener(
    private val mPlayer: JWPlayer,
    private val mEventType: EventType,
    private val mEventListener: EventListener
) : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        if (isChecked) {
            mPlayer.addListener(mEventType, mEventListener)
        } else {
            mPlayer.removeListener(mEventType, mEventListener)
        }
    }
}