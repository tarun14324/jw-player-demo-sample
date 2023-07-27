package com.jwplayer.opensourcedemo.sample.models

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("data")
    val data: T?
)