package com.jwplayer.opensourcedemo.sample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jwplayer.opensourcedemo.sample.api.RetrofitHelper
import com.jwplayer.opensourcedemo.sample.models.ChapterDetailVideo
import com.jwplayer.opensourcedemo.sample.models.NetworkResult
import kotlinx.coroutines.launch


class ChapterVideoViewModel : ViewModel() {

    var responseData: MutableLiveData<NetworkResult<ChapterDetailVideo?>> = MutableLiveData()

    init {
        loadData()
    }

    private fun loadData() {
        responseData.value = NetworkResult.Loading()
        viewModelScope.launch {
            val response = RetrofitHelper.getInstance().fetchChapterDetail()
            if (response.isSuccessful) {
                responseData.value = NetworkResult.Success(response.body()?.data?.getOrNull(0))
            } else {
                responseData.value = NetworkResult.Error(response.message())
            }
        }
    }
}
