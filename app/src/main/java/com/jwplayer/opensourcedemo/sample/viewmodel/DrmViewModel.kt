package com.jwplayer.opensourcedemo.sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jwplayer.opensourcedemo.sample.api.RetrofitHelper
import com.jwplayer.opensourcedemo.sample.models.DrmInfo
import com.jwplayer.opensourcedemo.sample.models.DrmVideoDetail
import com.jwplayer.opensourcedemo.sample.models.VideoContent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch


class DrmViewModel : ViewModel() {

    lateinit var drmData: VideoContent

    val videoMetaDataEvent = Channel<DrmVideoDetail?>(Channel.CONFLATED).apply {
        trySend(null)
    }

    fun getData(){
        viewModelScope.launch {
            fetchVideoMetadata()
        }
    }

     private suspend fun fetchVideoMetadata() {
        if (drmData.isDrm) {
            val drmInfo = DrmInfo.getDrmInfo()
            val drmVideoResponse = RetrofitHelper.getInstance().fetchDrmVideoData(
                drmData.jwMediaId!!, deviceOs = "Android",
                platform = "mobile", securityLevel = drmInfo.securityLevel, digitalOutput = drmInfo.maxHdcpLevel
            )
            videoMetaDataEvent.trySend(drmVideoResponse.body()?.data!!)
        } else {
            videoMetaDataEvent.trySend(null)
        }
    }
}