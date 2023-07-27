package com.jwplayer.opensourcedemo

import android.content.Context
import android.text.method.ScrollingMovementMethod
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.TextView
import com.jwplayer.pub.api.JWPlayer
import com.jwplayer.pub.api.events.AdClickEvent
import com.jwplayer.pub.api.events.AdCompanionsEvent
import com.jwplayer.pub.api.events.AdCompleteEvent
import com.jwplayer.pub.api.events.AdErrorEvent
import com.jwplayer.pub.api.events.AdImpressionEvent
import com.jwplayer.pub.api.events.AdPauseEvent
import com.jwplayer.pub.api.events.AdPlayEvent
import com.jwplayer.pub.api.events.AdRequestEvent
import com.jwplayer.pub.api.events.AdScheduleEvent
import com.jwplayer.pub.api.events.AdSkippedEvent
import com.jwplayer.pub.api.events.AdStartedEvent
import com.jwplayer.pub.api.events.AdTimeEvent
import com.jwplayer.pub.api.events.AudioTrackChangedEvent
import com.jwplayer.pub.api.events.AudioTracksEvent
import com.jwplayer.pub.api.events.BeforeCompleteEvent
import com.jwplayer.pub.api.events.BeforePlayEvent
import com.jwplayer.pub.api.events.BufferChangeEvent
import com.jwplayer.pub.api.events.BufferEvent
import com.jwplayer.pub.api.events.CaptionsChangedEvent
import com.jwplayer.pub.api.events.CaptionsListEvent
import com.jwplayer.pub.api.events.CompleteEvent
import com.jwplayer.pub.api.events.ControlBarVisibilityEvent
import com.jwplayer.pub.api.events.ControlsEvent
import com.jwplayer.pub.api.events.DisplayClickEvent
import com.jwplayer.pub.api.events.ErrorEvent
import com.jwplayer.pub.api.events.EventType
import com.jwplayer.pub.api.events.FirstFrameEvent
import com.jwplayer.pub.api.events.FullscreenEvent
import com.jwplayer.pub.api.events.IdleEvent
import com.jwplayer.pub.api.events.LevelsChangedEvent
import com.jwplayer.pub.api.events.LevelsEvent
import com.jwplayer.pub.api.events.MetaEvent
import com.jwplayer.pub.api.events.MuteEvent
import com.jwplayer.pub.api.events.PauseEvent
import com.jwplayer.pub.api.events.PlayEvent
import com.jwplayer.pub.api.events.PlaylistCompleteEvent
import com.jwplayer.pub.api.events.PlaylistEvent
import com.jwplayer.pub.api.events.PlaylistItemEvent
import com.jwplayer.pub.api.events.RelatedCloseEvent
import com.jwplayer.pub.api.events.RelatedOpenEvent
import com.jwplayer.pub.api.events.RelatedPlayEvent
import com.jwplayer.pub.api.events.SeekEvent
import com.jwplayer.pub.api.events.SeekedEvent
import com.jwplayer.pub.api.events.SetupErrorEvent
import com.jwplayer.pub.api.events.TimeEvent
import com.jwplayer.pub.api.events.VisualQualityEvent
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdClickListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdCompanionsListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdCompleteListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdErrorListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdImpressionListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdPauseListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdPlayListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdRequestListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdScheduleListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdSkippedListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdStartedListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnAdTimeListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnBeforeCompleteListener
import com.jwplayer.pub.api.events.listeners.AdvertisingEvents.OnBeforePlayListener
import com.jwplayer.pub.api.events.listeners.RelatedPluginEvents.OnRelatedCloseListener
import com.jwplayer.pub.api.events.listeners.RelatedPluginEvents.OnRelatedOpenListener
import com.jwplayer.pub.api.events.listeners.RelatedPluginEvents.OnRelatedPlayListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnAudioTrackChangedListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnAudioTracksListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnBufferChangeListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnBufferListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnCaptionsChangedListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnCaptionsListListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnControlBarVisibilityListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnControlsListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnDisplayClickListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnFirstFrameListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnFullscreenListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnIdleListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnLevelsChangedListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnLevelsListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnMetaListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnMuteListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnPauseListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnPlayListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnPlaylistCompleteListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnPlaylistItemListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnPlaylistListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnSeekListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnSeekedListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnSetupErrorListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnTimeListener
import com.jwplayer.pub.api.events.listeners.VideoPlayerEvents.OnVisualQualityListener
import com.jwplayer.pub.api.media.playlists.PlaylistItem
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Outputs all JW Player Events to your console and the Log TextView
 *
 *
 * Steps to edit class:
 * 1) implement event listener
 * 2) create checkbox in view_callback_screen.xml
 * 3) create a reference to view in CallbackScreen class
 * 4) set a onCheckChangeListener for the checkbox
 * 5) add or remove player listeners depending on checkbox state
 * 6) add checkbox to mCallbacksList for easy select all
 */
class CallbackScreen : LinearLayout, OnIdleListener, OnBufferListener, OnPlayListener,
    OnPauseListener, OnTimeListener, VideoPlayerEvents.OnCompleteListener,
    VideoPlayerEvents.OnErrorListener, OnSeekListener, OnFullscreenListener, OnAudioTracksListener,
    OnAudioTrackChangedListener, OnLevelsListener, OnLevelsChangedListener, OnSeekedListener,
    OnFirstFrameListener, OnDisplayClickListener, OnPlaylistCompleteListener, OnMetaListener,
    OnCaptionsChangedListener, OnCaptionsListListener, OnPlaylistItemListener, OnPlaylistListener,
    OnSetupErrorListener, OnMuteListener, OnVisualQualityListener, OnControlsListener,
    OnBufferChangeListener, OnRelatedCloseListener, OnRelatedOpenListener, OnRelatedPlayListener,
    OnControlBarVisibilityListener, OnAdTimeListener, OnAdScheduleListener, OnAdPlayListener,
    OnAdPauseListener, OnAdImpressionListener, OnAdClickListener, OnAdErrorListener,
    OnAdCompleteListener, OnAdSkippedListener, OnAdCompanionsListener, OnAdRequestListener,
    OnBeforeCompleteListener, OnBeforePlayListener, OnAdStartedListener {
    // CALLBACKS
    private var mCallbackLog: TextView? = null
    private var mCallbackPlayerVersion: TextView? = null
    private var mCallbacksList: ArrayList<CheckBox?>? = null
    private var mCheckAll: CheckBox? = null
    private var mOnIdleCheckBox: CheckBox? = null
    private var mOnBufferingCheckBox: CheckBox? = null
    private var mOnPlayCheckBox: CheckBox? = null
    private var mOnPauseCheckBox: CheckBox? = null
    private var mOnCompleteCheckBox: CheckBox? = null
    private var mOnErrorCheckBox: CheckBox? = null
    private var mOnFullscreenCheckBox: CheckBox? = null
    private var mOnSeekCheckBox: CheckBox? = null
    private var mOnTimeCheckBox: CheckBox? = null
    private var mOnAdPlayCheckBox: CheckBox? = null
    private var mOnAdPauseCheckBox: CheckBox? = null
    private var mOnAdCompleteCheckBox: CheckBox? = null
    private var mOnAdErrorCheckBox: CheckBox? = null
    private var mOnAdSkipCheckBox: CheckBox? = null
    private var mOnAdTimeCheckBox: CheckBox? = null
    private var mOnAdClickCheckBox: CheckBox? = null
    private var mOnAdImpressionCheckBox: CheckBox? = null
    private var mOnAdRequestCheckBox: CheckBox? = null
    private var mOnAudioTracksCheckBox: CheckBox? = null
    private var mOnAudioTracksChangedCheckBox: CheckBox? = null
    private var mOnLevelsCheckBox: CheckBox? = null
    private var mOnLevelsChangedCheckBox: CheckBox? = null
    private var mOnSeekedCheckBox: CheckBox? = null
    private var mOnFirstFrameCheckBox: CheckBox? = null
    private var mOnDisplayClickCheckBox: CheckBox? = null
    private var mOnPlaylistCompleteCheckBox: CheckBox? = null
    private var mOnMetaCheckBox: CheckBox? = null
    private var mOnCaptionsChangedCheckBox: CheckBox? = null
    private var mOnCaptionsListCheckBox: CheckBox? = null
    private var mOnPlaylistItemCheckBox: CheckBox? = null
    private var mOnPlaylistCheckBox: CheckBox? = null
    private var mOnSetupErrorCheckBox: CheckBox? = null
    private var mOnBeforeCompleteCheckBox: CheckBox? = null
    private var mOnBeforePlayCheckBox: CheckBox? = null
    private var mOnMuteCheckBox: CheckBox? = null
    private var mOnVisualQualityCheckBox: CheckBox? = null
    private var mOnAdStartedCheckBox: CheckBox? = null
    private var mTimeSeconds: CheckBox? = null
    private var mOnControls: CheckBox? = null
    private var mOnControlbarVisibilityChanged: CheckBox? = null
    private var mOnBufferChange: CheckBox? = null
    private var mOnRelatedClose: CheckBox? = null
    private var mOnRelatedOpen: CheckBox? = null
    private var mOnRelatedPlay: CheckBox? = null
    private var mOnAdCompanion: CheckBox? = null
    private var mOnAdSchedule: CheckBox? = null
    private var mPlayer: JWPlayer? = null
    private var timeInSeconds = false

    constructor(context: Context?) : super(context) {
        inflate(getContext(), R.layout.view_callback_screen, this)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        inflate(getContext(), R.layout.view_callback_screen, this)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        inflate(getContext(), R.layout.view_callback_screen, this)
    }

    private fun setOutput(output: String) {
        Log.d("CallbackScreen", output)
        mCallbackLog!!.append(
            """
    $output
    
    
    """.trimIndent()
        )
    }

    override fun onAdRequest(event: AdRequestEvent) {
        val client = event.client.name
        val tag = event.tag
        val adPosition = event.adPosition
        val offset = event.offset
        val output = """
            /// onAdRequest START ///
            Tag:
            $tag
            Ad Client:
            $client
            Ad Position:
            $adPosition
            Ad Offset:
            $offset
            /// onAdRequest END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAdSkipped(event: AdSkippedEvent) {
        val client = event.client.name
        val creativeType = event.creativeType
        val tag = event.tag
        val output = """
            /// onAdSkipped START ///
            Tag:
            $tag
            Creative Type:
            $creativeType
            Ad Client:
            $client
            /// onAdSkipped END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAdClick(event: AdClickEvent) {
        val creativeType = event.creativeType
        val tag = event.tag
        val client = event.client.name
        val output = """
            /// onAdClick START ///
            Tag:
            $tag
            Creative Type:
            $creativeType
            Client:
            $client
            /// onAdClick END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAdImpression(event: AdImpressionEvent) {
        val creativeType = event.creativeType
        val tag = event.tag
        val client = event.client.name
        // AdPosition is an enum now and can return pre, mid, post
        val adPosition = event.adPosition.name
        val adSystem = event.adSystem
        val adTitle = event.adTitle
        val linear = event.linear
        val mediaFile = if (event.mediaFile != null) event.mediaFile!!.file else ""
        val vastVersion = event.vastVersion
        val clickThroughUrl = event.clickThroughUrl
        val output = """
            /// onAdImpression START ///
            Tag:
            $tag
            Creative Type:
            $creativeType
            Client:
            $client
            Ad Position:
            $adPosition
            Ad System:
            $adSystem
            Ad Title:
            $adTitle
            Linear:
            $linear
            Media File:
            $mediaFile
            Vast Version:
            $vastVersion
            Clickthrough URL:
            $clickThroughUrl
            /// onAdImpression END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAdPause(event: AdPauseEvent) {
        val oldState = event.oldState
        val currentState = event.newState
        val tag = event.tag
        val creativeType = event.creativeType
        val output = """
            /// onAdPause START ///
            Tag:
            $tag
            Creative Type:
            $creativeType
            Previous Player State:
            ${oldState.name}
            Current Player State:
            ${currentState.name}
            /// onAdPause END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAdPlay(event: AdPlayEvent) {
        val tag = event.tag
        val creativeType = event.creativeType
        val oldState = event.oldState
        val currentState = event.newState
        val output = """
            /// onAdPlay START ///
            Tag:
            $tag
            Creative Type:
            $creativeType
            Previous Player State:
            ${oldState.name}
            Current Player State:
            ${currentState.name}
            /// onAdPlay END ///
            """.trimIndent()
        setOutput(output)
    }

    private var mOldAdTimeSeconds = 0.0
    private var mOldAdDurationSeconds = 0.0
    override fun onAdTime(event: AdTimeEvent) {
        val creativeType = event.creativeType
        val sequence = event.sequence
        val tag = event.tag
        val position = event.position
        val duration = event.duration
        if (mTimeSeconds!!.isChecked) {
            val adTimeSeconds = Math.floor(position / 1000)
            val adDurationSeconds = Math.floor(duration / 1000)
            if (mOldAdTimeSeconds != adTimeSeconds || mOldAdDurationSeconds != adDurationSeconds) {
                mOldAdTimeSeconds = adTimeSeconds
                mOldAdDurationSeconds = adDurationSeconds
                val output = """
                    /// onAdTime START ///
                    Creative Type:
                    $creativeType
                    Tag:
                    $tag
                    Position:
                    ${adTimeSeconds}s
                    Duration:
                    ${adDurationSeconds}s
                    Sequence:
                    $sequence
                    /// onAdTime END ///
                    """.trimIndent()
                setOutput(output)
            }
        } else {
            val output = """
                /// onAdTime START ///
                Creative Type:
                $creativeType
                Tag:
                $tag
                Position:
                ${position}s
                Duration:
                ${duration}s
                Sequence:
                $sequence
                /// onAdTime END ///
                """.trimIndent()
            setOutput(output)
        }
    }

    override fun onAdComplete(event: AdCompleteEvent) {
        val client = event.client.name
        val creativeType = event.creativeType
        val tag = event.tag
        val output = """
            /// onAdComplete START ///
            Tag:
            $tag
            Creative Type:
            $creativeType
            Ad Client:
            $client
            /// onAdComplete END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onError(event: ErrorEvent) {
        val message = event.message
        val output = """
            /// onError START ///
            Error Message:
            $message
            /// onError END ///
            """.trimIndent()
        setOutput(output)
    }

    fun registerListeners(player: JWPlayer?) {
        mPlayer = player
        mCallbackPlayerVersion = findViewById(R.id.callback_player_version)
        mCallbackPlayerVersion.setText("Player Version: " + mPlayer!!.versionCode)
        mCallbackLog = findViewById(R.id.callback_status_tv)
        mCallbackLog.setMovementMethod(ScrollingMovementMethod())


        //         This handles clearing the log
        findViewById<View>(R.id.callback_clear_btn).setOnClickListener { v: View? ->
            mCallbackLog.setText(
                ""
            )
        }
        mTimeSeconds = findViewById(R.id.callback_time_seconds)
        mTimeSeconds.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
            timeInSeconds = isChecked
        })
        mOnCompleteCheckBox = findViewById(R.id.callback_on_complete_check)
        mOnCompleteCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.COMPLETE, this)
        )
        mOnErrorCheckBox = findViewById(R.id.callback_on_error_check)
        mOnErrorCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.ERROR, this)
        )
        mOnFullscreenCheckBox = findViewById(R.id.callback_on_fullscreen_check)
        mOnFullscreenCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.FULLSCREEN, this)
        )
        mOnSeekCheckBox = findViewById(R.id.callback_on_seek_check)
        mOnSeekCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.SEEK, this)
        )
        mOnSeekedCheckBox = findViewById(R.id.callback_on_seeked_check)
        mOnSeekedCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.SEEKED, this)
        )
        mOnIdleCheckBox = findViewById(R.id.callback_on_idle_check)
        mOnIdleCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.IDLE, this)
        )
        mOnBufferingCheckBox = findViewById(R.id.callback_on_buffer_check)
        mOnBufferingCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.BUFFER, this)
        )
        mOnPlayCheckBox = findViewById(R.id.callback_on_play_check)
        mOnPlayCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.PLAY, this)
        )
        mOnPauseCheckBox = findViewById(R.id.callback_on_pause_check)
        mOnPauseCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.PAUSE, this)
        )
        mOnTimeCheckBox = findViewById(R.id.callback_on_time_check)
        mOnTimeCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.TIME, this)
        )
        mOnAdCompleteCheckBox = findViewById(R.id.callback_ad_on_complete_check)
        mOnAdCompleteCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_COMPLETE, this)
        )
        mOnAdErrorCheckBox = findViewById(R.id.callback_ad_on_error_check)
        mOnAdErrorCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_ERROR, this)
        )
        mOnAdSkipCheckBox = findViewById(R.id.callback_ad_on_skip_check)
        mOnAdSkipCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_SKIPPED, this)
        )
        mOnAdPlayCheckBox = findViewById(R.id.callback_ad_on_play_check)
        mOnAdPlayCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_PLAY, this)
        )
        mOnAdPauseCheckBox = findViewById(R.id.callback_ad_on_pause_check)
        mOnAdPauseCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_PAUSE, this)
        )
        mOnAdTimeCheckBox = findViewById(R.id.callback_ad_on_time_check)
        mOnAdTimeCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_TIME, this)
        )
        mOnAdImpressionCheckBox = findViewById(R.id.callback_ad_on_impression_check)
        mOnAdImpressionCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_IMPRESSION, this)
        )
        mOnAdClickCheckBox = findViewById(R.id.callback_ad_on_click_check)
        mOnAdClickCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_CLICK, this)
        )
        mOnAdRequestCheckBox = findViewById(R.id.callback_ad_on_request_check)
        mOnAdRequestCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_REQUEST, this)
        )
        mOnAudioTracksCheckBox = findViewById(R.id.callback_on_audio_tracks_check)
        mOnAudioTracksCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AUDIO_TRACKS, this)
        )
        mOnAudioTracksChangedCheckBox = findViewById(R.id.callback_on_audio_tracks_changed_check)
        mOnAudioTracksChangedCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AUDIO_TRACK_CHANGED, this)
        )
        mOnLevelsCheckBox = findViewById(R.id.callback_on_levels_check)
        mOnLevelsCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.LEVELS, this)
        )
        mOnLevelsChangedCheckBox = findViewById(R.id.callback_on_levels_changed_check)
        mOnLevelsChangedCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.LEVELS_CHANGED, this)
        )
        mOnFirstFrameCheckBox = findViewById(R.id.callback_on_first_frame_check)
        mOnFirstFrameCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.FIRST_FRAME, this)
        )
        mOnDisplayClickCheckBox = findViewById(R.id.callback_on_display_click_check)
        mOnDisplayClickCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.DISPLAY_CLICK, this)
        )
        mOnPlaylistCompleteCheckBox = findViewById(R.id.callback_on_playlist_complete_check)
        mOnPlaylistCompleteCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.PLAYLIST_COMPLETE, this)
        )
        mOnMetaCheckBox = findViewById(R.id.callback_on_meta_check)
        mOnMetaCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.META, this)
        )
        mOnCaptionsChangedCheckBox = findViewById(R.id.callback_on_captions_changed_check)
        mOnCaptionsChangedCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.CAPTIONS_CHANGED, this)
        )
        mOnCaptionsListCheckBox = findViewById(R.id.callback_on_captions_list_check)
        mOnCaptionsListCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.CAPTIONS_LIST, this)
        )
        mOnPlaylistItemCheckBox = findViewById(R.id.callback_on_playlist_item_check)
        mOnPlaylistItemCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.PLAYLIST_ITEM, this)
        )
        mOnPlaylistCheckBox = findViewById(R.id.callback_on_playlist_check)
        mOnPlaylistCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.PLAYLIST, this)
        )
        mOnSetupErrorCheckBox = findViewById(R.id.callback_on_setup_error_check)
        mOnSetupErrorCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.SETUP_ERROR, this)
        )
        mOnBeforeCompleteCheckBox = findViewById(R.id.callback_ad_on_before_complete_check)
        mOnBeforeCompleteCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.BEFORE_COMPLETE, this)
        )
        mOnBeforePlayCheckBox = findViewById(R.id.callback_ad_on_before_play_check)
        mOnBeforePlayCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.BEFORE_PLAY, this)
        )
        mOnMuteCheckBox = findViewById(R.id.callback_on_mute_check)
        mOnMuteCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.MUTE, this)
        )
        mOnVisualQualityCheckBox = findViewById(R.id.callback_on_visual_quality_check)
        mOnVisualQualityCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.VISUAL_QUALITY, this)
        )
        mOnAdStartedCheckBox = findViewById(R.id.callback_ad_on_started_check)
        mOnAdStartedCheckBox.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_STARTED, this)
        )
        mOnControls = findViewById(R.id.callback_on_controls_check)
        mOnControls.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.CONTROLS, this)
        )
        mOnBufferChange = findViewById(R.id.callback_on_buffer_change_check)
        mOnBufferChange.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.BUFFER_CHANGE, this)
        )
        mOnRelatedClose = findViewById(R.id.callback_on_related_close_check)
        mOnRelatedClose.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.RELATED_CLOSE, this)
        )
        mOnRelatedOpen = findViewById(R.id.callback_on_related_open_check)
        mOnRelatedOpen.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.RELATED_OPEN, this)
        )
        mOnRelatedPlay = findViewById(R.id.callback_on_related_play_check)
        mOnRelatedPlay.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.RELATED_PLAY, this)
        )
        mOnAdCompanion = findViewById(R.id.callback_ad_on_companion_check)
        mOnAdCompanion.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_COMPANIONS, this)
        )
        mOnControlbarVisibilityChanged =
            findViewById(R.id.callback_on_controlbar_visibility_changed_check)
        mOnControlbarVisibilityChanged.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.CONTROLBAR_VISIBILITY, this)
        )
        mOnAdSchedule = findViewById(R.id.callback_ad_on_schedule_check)
        mOnAdSchedule.setOnCheckedChangeListener(
            EventCheckChangedListener(mPlayer, EventType.AD_SCHEDULE, this)
        )

        // handles unchecking all boxes
        mCallbacksList = ArrayList()
        mCallbacksList!!.add(mOnCompleteCheckBox)
        mCallbacksList!!.add(mOnErrorCheckBox)
        mCallbacksList!!.add(mOnFullscreenCheckBox)
        mCallbacksList!!.add(mOnSeekCheckBox)
        mCallbacksList!!.add(mOnSeekedCheckBox)
        mCallbacksList!!.add(mOnIdleCheckBox)
        mCallbacksList!!.add(mOnBufferingCheckBox)
        mCallbacksList!!.add(mOnPlayCheckBox)
        mCallbacksList!!.add(mOnPauseCheckBox)
        mCallbacksList!!.add(mOnTimeCheckBox)
        mCallbacksList!!.add(mOnAdCompleteCheckBox)
        mCallbacksList!!.add(mOnAdErrorCheckBox)
        mCallbacksList!!.add(mOnAdSkipCheckBox)
        mCallbacksList!!.add(mOnAdPlayCheckBox)
        mCallbacksList!!.add(mOnAdPauseCheckBox)
        mCallbacksList!!.add(mOnAdTimeCheckBox)
        mCallbacksList!!.add(mOnAdImpressionCheckBox)
        mCallbacksList!!.add(mOnAdClickCheckBox)
        mCallbacksList!!.add(mOnAdRequestCheckBox)
        mCallbacksList!!.add(mOnAudioTracksCheckBox)
        mCallbacksList!!.add(mOnAudioTracksChangedCheckBox)
        mCallbacksList!!.add(mOnLevelsCheckBox)
        mCallbacksList!!.add(mOnLevelsChangedCheckBox)
        mCallbacksList!!.add(mOnFirstFrameCheckBox)
        mCallbacksList!!.add(mOnDisplayClickCheckBox)
        mCallbacksList!!.add(mOnPlaylistCompleteCheckBox)
        mCallbacksList!!.add(mOnMetaCheckBox)
        mCallbacksList!!.add(mOnCaptionsChangedCheckBox)
        mCallbacksList!!.add(mOnCaptionsListCheckBox)
        mCallbacksList!!.add(mOnPlaylistItemCheckBox)
        mCallbacksList!!.add(mOnPlaylistCheckBox)
        mCallbacksList!!.add(mOnSetupErrorCheckBox)
        mCallbacksList!!.add(mOnBeforeCompleteCheckBox)
        mCallbacksList!!.add(mOnBeforePlayCheckBox)
        mCallbacksList!!.add(mOnMuteCheckBox)
        mCallbacksList!!.add(mOnVisualQualityCheckBox)
        mCallbacksList!!.add(mOnAdStartedCheckBox)
        mCallbacksList!!.add(mOnControls)
        mCallbacksList!!.add(mOnBufferChange)
        mCallbacksList!!.add(mOnRelatedClose)
        mCallbacksList!!.add(mOnRelatedOpen)
        mCallbacksList!!.add(mOnRelatedPlay)
        mCallbacksList!!.add(mOnAdCompanion)
        mCallbacksList!!.add(mOnControlbarVisibilityChanged)
        mCallbacksList!!.add(mOnAdSchedule)

        // This handles unchecking all checkboxes
        mCheckAll = findViewById(R.id.callback_check_all)
        mCheckAll = findViewById(R.id.callback_check_all)
        mCheckAll.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            for (currectCheckBox in mCallbacksList!!) {
                currectCheckBox!!.isChecked = isChecked
            }
        })
    }

    private fun updateListeners() {
        for (currectCheckBox in mCallbacksList!!) {
            if (currectCheckBox!!.isChecked) {
                currectCheckBox.isChecked = false
                currectCheckBox.isChecked = true
            }
        }
    }

    val callbackLog: String
        get() = mCallbackLog!!.text.toString()

    override fun onControls(controlsEvent: ControlsEvent) {
        val prefix = """
            /// onControls START ///
            
            """.trimIndent()
        val controls = """
            Controls = ${controlsEvent.controls}
            
            """.trimIndent()
        val event = "ControlsEvent = $controlsEvent\n"
        val suffix = """
            
            /// onControls END ///
            """.trimIndent()
        setOutput(prefix + controls + event + suffix)
    }

    override fun onBufferChange(bufferChangeEvent: BufferChangeEvent) {
        val prefix = """
            /// onBufferChange START ///
            
            """.trimIndent()
        val percentage = """
            Buffer Percentage = ${bufferChangeEvent.bufferPercent}
            
            """.trimIndent()
        val duration = """
            Duration = ${bufferChangeEvent.duration}
            
            """.trimIndent()
        val position = """
            Position = ${bufferChangeEvent.position}
            
            """.trimIndent()
        val suffix = """
            
            /// onBufferChange END ///
            """.trimIndent()
        setOutput(prefix + percentage + duration + position + suffix)
    }

    override fun onRelatedClose(relatedCloseEvent: RelatedCloseEvent) {
        val prefix = """
            /// onRelatedClose START ///
            
            """.trimIndent()
        val method = """
            Method = ${relatedCloseEvent.method}
            
            """.trimIndent()
        val suffix = """
            
            /// onRelatedClose END ///
            """.trimIndent()
        setOutput(prefix + method + suffix)
    }

    private fun playlistToString(playlist: List<PlaylistItem>): String {
        var result = "[\n"
        for (item in playlist) {
            result += item.file
            result += ","
        }
        result += "\n]"
        return result
    }

    override fun onRelatedOpen(relatedOpenEvent: RelatedOpenEvent) {
        val prefix = """
            /// onRelatedOpen START ///
            
            """.trimIndent()
        val method = """
            Method = ${relatedOpenEvent.method}
            
            """.trimIndent()
        val file = """
            File = ${relatedOpenEvent.url}
            
            """.trimIndent()
        val playlist = """
            Playlist = ${playlistToString(relatedOpenEvent.items)}
            
            """.trimIndent()
        val suffix = """
            
            /// onRelatedOpen END ///
            """.trimIndent()
        setOutput(prefix + method + file + playlist + suffix)
    }

    override fun onRelatedPlay(relatedPlayEvent: RelatedPlayEvent) {
        val prefix = """
            /// onRelatedPlay START ///
            
            """.trimIndent()
        val auto = """
            Auto = ${relatedPlayEvent.auto}
            
            """.trimIndent()
        var item = ""
        item = """
            Item = ${relatedPlayEvent.item.file}
            
            """.trimIndent()
        val suffix = """
            
            /// onRelatedPlay END ///
            """.trimIndent()
        setOutput(prefix + auto + item + suffix)
    }

    fun updateJWPlayerView(player: JWPlayer?) {
        mPlayer = player
        updateListeners()
    }

    override fun onControlBarVisibilityChanged(controlBarVisibilityEvent: ControlBarVisibilityEvent) {
        val prefix = """
            /// onControlBarVisibilityChanged START ///
            
            """.trimIndent()
        val isVisible = "isVisible = " + controlBarVisibilityEvent.isVisible
        val suffix = """
            
            /// onControlBarVisibilityChanged END ///
            """.trimIndent()
        setOutput(prefix + isVisible + suffix)
    }

    override fun onAdSchedule(adScheduleEvent: AdScheduleEvent) {
        val prefix = """
            /// onAdSchedule START ///
            
            """.trimIndent()
        val tag = """
            Tag = ${adScheduleEvent.tag}
            
            """.trimIndent()
        val client = """
            Client = ${adScheduleEvent.client.name}
            
            """.trimIndent()
        var json = ""
        val adCompanionList = adScheduleEvent.vmapAdBreaks
        val stringBuilder = StringBuilder()
        for (vmapAdBreak in adCompanionList) {
            stringBuilder.append(vmapAdBreak.vMapInfo.id)
        }
        json = "List<VMAPAdBreak> = \n$stringBuilder\n"
        val suffix = """
            
            /// onAdSchedule END ///
            """.trimIndent()
        setOutput(prefix + client + tag + json + suffix)
    }

    override fun onAdCompanions(adCompanionsEvent: AdCompanionsEvent) {
        val prefix = """
            /// onAdCompanion START ///
            
            """.trimIndent()
        val tag = """
            Tag = ${adCompanionsEvent.tag}
            
            """.trimIndent()
        var item = ""
        try {
            val adCompanionList = adCompanionsEvent.companions
            val jsonArray = JSONArray()
            for (adCompanion in adCompanionList) {
                val companionJson = JSONObject()
                companionJson.put("height:", adCompanion.height)
                companionJson.put("width:", adCompanion.width)
                companionJson.put("type:", adCompanion.type)
                companionJson.put("resource:", adCompanion.resource)
                companionJson.put("click:", adCompanion.click)
                companionJson.put("creatives", adCompanion.creativeViews)
                jsonArray.put(companionJson)
            }
            item = """
                Ad Companions = 
                ${jsonArray.toString(4)}
                
                """.trimIndent()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        val suffix = """
            
            /// onAdCompanion END ///
            """.trimIndent()
        setOutput(prefix + tag + item + suffix)
    }

    override fun onAdError(adErrorEvent: AdErrorEvent) {
        val output = """
            /// onAdError START ///
            Message:
            ${adErrorEvent.message}
            Tag:
            ${adErrorEvent.tag}
            /// onAdError END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAdStarted(adStartedEvent: AdStartedEvent) {
        val output = """
            /// onAdStarted START ///
            Creative Type:
            ${adStartedEvent.creativeType}
            Tag:
            ${adStartedEvent.tag}
            /// onAdStarted END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onBeforeComplete(beforeCompleteEvent: BeforeCompleteEvent) {
        val output = """
            /// onBeforeComplete START ///
            /// onBeforeComplete END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onBeforePlay(beforePlayEvent: BeforePlayEvent) {
        val output = """
            /// onBeforePlay START ///
            /// onBeforePlay END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAudioTrackChanged(audioTrackChangedEvent: AudioTrackChangedEvent) {
        val output = """
            /// onAudioTrackChanged START ///
            Current AudioTrack Index:
            ${audioTrackChangedEvent.currentTrack}
            /// onAudioTrackChanged END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onAudioTracks(audioTracksEvent: AudioTracksEvent) {
        val prefix = """
            /// onAudioTracks START ///
            
            """.trimIndent()
        val stringBuilder = StringBuilder()
        for (currentTrack in audioTracksEvent.audioTracks) {
            val separator = """
                -------------
                
                """.trimIndent()
            val name = """
                Name: ${currentTrack.name}
                
                """.trimIndent()
            val lang = """
                Language: ${currentTrack.language}
                
                """.trimIndent()
            val groupId = """
                Group ID: ${currentTrack.groupId}
                
                """.trimIndent()
            val autoSelect = """
                Autoselect: ${currentTrack.isAutoSelect}
                
                """.trimIndent()
            val defaultTrack = """
                Default: ${currentTrack.isDefaultTrack}
                
                """.trimIndent()
            stringBuilder.append(name)
                .append(lang)
                .append(groupId)
                .append(autoSelect)
                .append(defaultTrack)
                .append(separator)
        }
        val suffix = """
            
            /// onAudioTracks END ///
            """.trimIndent()
        setOutput(prefix + stringBuilder.toString() + suffix)
    }

    override fun onBuffer(bufferEvent: BufferEvent) {
        val output = """
            /// onBuffer START ///
            Previous Player State:
            ${bufferEvent.oldState.name}
            /// onBuffer END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onCaptionsChanged(captionsChangedEvent: CaptionsChangedEvent) {
        val output = """
            /// onCaptionsChanged START ///
            Current Caption Index:
            ${captionsChangedEvent.currentTrack}
            /// onCaptionsChanged END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onCaptionsList(captionsListEvent: CaptionsListEvent) {
        val prefix = """
            /// onCaptionsList START ///
            
            """.trimIndent()
        val stringBuilder = StringBuilder()
        for (currentCaption in captionsListEvent.captions) {
            val separator = """
                -------------
                
                """.trimIndent()
            var isDefault = ""
            var file = ""
            var label = ""
            var kind = ""
            if (currentCaption.file != null) {
                file = """
                    File: ${currentCaption.file}
                    
                    """.trimIndent()
            }
            if (currentCaption.label != null) {
                label = """
                    Label: ${currentCaption.label}
                    
                    """.trimIndent()
            }
            if (currentCaption.kind != null) {
                kind = """
                    Kind: ${currentCaption.kind.name}
                    
                    """.trimIndent()
            }
            isDefault = """
                isDefault: ${currentCaption.isDefault}
                
                """.trimIndent()
            stringBuilder.append(file).append(label).append(kind).append(isDefault)
                .append(separator)
        }
        val suffix = """
            
            /// onCaptionsList END ///
            """.trimIndent()
        setOutput(prefix + stringBuilder.toString() + suffix)
    }

    override fun onComplete(completeEvent: CompleteEvent) {
        val output = """
            /// onComplete START ///
            /// onComplete END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onDisplayClick(displayClickEvent: DisplayClickEvent) {
        val output = """
            /// onDisplayClick START ///
            /// onDisplayClick END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onFirstFrame(firstFrameEvent: FirstFrameEvent) {
        val output = """
            /// onFirstFrame START ///
            First Frame:
            ${firstFrameEvent.loadTime}ms
            /// onFirstFrame END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onFullscreen(fullscreenEvent: FullscreenEvent) {
        val output = """
            /// onFullscreen START ///
            Fullscreen:
            ${fullscreenEvent.fullscreen}
            /// onFullscreen END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onIdle(idleEvent: IdleEvent) {
        val output = """
            /// onIdle START ///
            Previous Player State:
            ${idleEvent.oldState.name}
            /// onIdle END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onLevelsChanged(levelsChangedEvent: LevelsChangedEvent) {
        val output = """
            /// onLevelsChanged START ///
            Current Level Index:
            ${levelsChangedEvent.currentQualityIndex}
            /// onLevelsChanged END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onLevels(levelsEvent: LevelsEvent) {
        val prefix = """
            /// onLevels START ///
            
            """.trimIndent()
        val stringBuilder = StringBuilder()
        for (currentLevel in levelsEvent.levels) {
            val separator = """
                -------------
                
                """.trimIndent()
            val index = """
                Track Index: ${currentLevel.trackIndex}
                
                """.trimIndent()
            val label = """
                Label: ${currentLevel.label}
                
                """.trimIndent()
            val bitrate = """
                Bitrate: ${currentLevel.bitrate}
                
                """.trimIndent()
            val height = """
                Height: ${currentLevel.height}
                
                """.trimIndent()
            val width = """
                Width: ${currentLevel.width}
                
                """.trimIndent()
            val playlistPosition = "Playlist Position: " + currentLevel
                .playlistPosition + "\n"
            stringBuilder.append(index).append(label).append(bitrate).append(height).append(width)
                .append(playlistPosition).append(separator)
        }
        val suffix = """
            
            /// onLevels END ///
            """.trimIndent()
        setOutput(prefix + stringBuilder.toString() + suffix)
    }

    override fun onMeta(metaEvent: MetaEvent) {
        val prefix = """
            /// onMeta START ///
            
            """.trimIndent()
        var body = ""
        val metadata = metaEvent.metadata
        val videoID = """
            Video ID: ${metadata.videoId}
            
            """.trimIndent()
        val videoMimeType = """
            Video MimeType: ${metadata.videoMimeType}
            
            """.trimIndent()
        val videoBitrate = """
            Video Bitrate: ${metadata.videoBitrate}
            
            """.trimIndent()
        val framerate = """
            Framerate: ${metadata.framerate}
            
            """.trimIndent()
        val droppedFrames = """
            Dropped Frames: ${metadata.droppedFrames}
            
            """.trimIndent()
        val width = """
            Width: ${metadata.width}
            
            """.trimIndent()
        val height = """
            Height: ${metadata.height}
            
            """.trimIndent()
        val lang = """
            Language: ${metadata.language}
            
            """.trimIndent()
        val audioID = """
            Audio ID: ${metadata.audioId}
            
            """.trimIndent()
        val audioMimeType = """
            Audio MimeType: ${metadata.audioMimeType}
            
            """.trimIndent()
        val audioBitrate = """
            Audio Bitrate: ${metadata.audioBitrate}
            
            """.trimIndent()
        val audioChannels = """
            Audio Channels: ${metadata.audioChannels}
            
            """.trimIndent()
        val audioSamplingRate = """
            Audio Sampling Rate: ${metadata.audioSamplingRate}
            
            """.trimIndent()
        val meta = """
            Metadata:
            ${metadata.id3Metadata}
            
            """.trimIndent()
        body += videoID + videoMimeType + videoBitrate + framerate + droppedFrames + width + height + lang + audioID + audioMimeType + audioBitrate + audioChannels + audioSamplingRate + meta
        val suffix = """
            
            /// onMeta END ///
            """.trimIndent()
        setOutput(prefix + body + suffix)
    }

    override fun onMute(muteEvent: MuteEvent) {
        val output = """
            /// onMute START ///
            Mute: 
            ${muteEvent.mute}
            /// onMute END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onPause(pauseEvent: PauseEvent) {
        val output = """
            /// onPause START ///
            Previous Player State:
            ${pauseEvent.oldState.name}
            /// onPause END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onPlay(playEvent: PlayEvent) {
        val output = """
            /// onPlay START ///
            Previous Player State:
            ${playEvent.oldState.name}
            /// onPlay END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onPlaylistComplete(playlistCompleteEvent: PlaylistCompleteEvent) {
        val output = """
            /// onPlaylistComplete START ///
            /// onPlaylistComplete END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onPlaylistItem(playlistItemEvent: PlaylistItemEvent) {
        val output = """
            /// onPlaylistItem START ///
            Current PlaylistItem Index:
            ${playlistItemEvent.index}
            PlaylistItem JSON:
            ${playlistItemEvent.playlistItem.file}
            /// onPlaylistItem END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onPlaylist(playlistEvent: PlaylistEvent) {
        val prefix = """
            /// onPlaylist START ///
            
            """.trimIndent()
        val builder = StringBuilder()
        for (currentItem in playlistEvent.playlist) {
            val separator = """
                -------------
                
                """.trimIndent()
            val item = currentItem.file
            builder.append(item).append(separator)
        }
        val suffix = """
            
            /// onPlaylist END ///
            """.trimIndent()
        setOutput(prefix + builder.toString() + suffix)
    }

    override fun onSeek(seekEvent: SeekEvent) {
        val output = """
            /// onSeek START ///
            Position:
            ${seekEvent.position}s
            Offset:
            ${seekEvent.offset}s
            /// onSeek END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onSeeked(seekedEvent: SeekedEvent) {
        val output = """
            /// onSeeked START ///
            Position:
            ${seekedEvent.position}s
            /// onSeeked END ///
            """.trimIndent()
        setOutput(output)
    }

    override fun onSetupError(setupErrorEvent: SetupErrorEvent) {
        val output = """
            /// onSetupError START ///
            Error Message:
            ${setupErrorEvent.message}
            /// onSetupError END ///
            """.trimIndent()
        setOutput(output)
    }

    private var mOldTime = 0.0
    override fun onTime(timeEvent: TimeEvent) {
        val positionSeconds = timeEvent.position
        val durationSeconds = timeEvent.duration
        if (timeInSeconds) {
            val roundedSeconds = Math.floor(positionSeconds)
            if (mOldTime != roundedSeconds) {
                mOldTime = roundedSeconds
                val output = """
                    /// onTime START ///
                    Current Position:
                    ${roundedSeconds}s
                    Total Duration:
                    ${durationSeconds}s
                    /// onTime END ///
                    """.trimIndent()
                setOutput(output)
            }
        } else {
            val output = """
                /// onTime START ///
                Current Position:
                ${positionSeconds}s
                Total Duration:
                ${durationSeconds}s
                /// onTime END ///
                """.trimIndent()
            setOutput(output)
        }
    }

    override fun onVisualQuality(visualQualityEvent: VisualQualityEvent) {
        val prefix = """
            /// onVisualQuality START ///
            
            """.trimIndent()
        val mode = """
            Mode = ${visualQualityEvent.mode.name}
            
            """.trimIndent()
        val qualityLevel = """
            Quality Level = ${visualQualityEvent.qualityLevel.label}
            
            """.trimIndent()
        val reason = "Reason = " + visualQualityEvent.reason.name
        val suffix = """
            
            /// onVisualQuality END ///
            """.trimIndent()
        setOutput(prefix + mode + qualityLevel + reason + suffix)
    }
}