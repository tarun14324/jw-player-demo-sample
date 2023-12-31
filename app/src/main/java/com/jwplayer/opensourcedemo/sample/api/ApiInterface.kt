package com.jwplayer.opensourcedemo.sample.api

import com.jwplayer.opensourcedemo.sample.models.BaseResponse
import com.jwplayer.opensourcedemo.sample.models.ChapterDetail
import com.jwplayer.opensourcedemo.sample.models.ChapterDetailVideo
import com.jwplayer.opensourcedemo.sample.models.DrmVideoDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("learn/v1/usage/get-drm-video-data")
    suspend fun getVideoList(): Response<DrmVideoDetail>

    @GET("learn/v1/usage/chapter-list")
    suspend fun fetchTopicsList(
        @Query("subject_id") subjectId: String,
    ): Response<BaseResponse<ChapterDetail>>

    @GET("https://mocki.io/v1/4808d10d-048e-44e6-b221-7638116c5319")
    suspend fun fetchChapterDetail(
    ): Response<BaseResponse<List<ChapterDetailVideo>>>


    @GET("learn/v1/usage/get-drm-video-data")
    suspend fun fetchDrmVideoData(
        @Query("jw_media_id") mediaId: String,
        @Query("device_os") deviceOs: String,
        @Query("platform") platform: String,
        @Query("security_level") securityLevel: String,
        @Query("digital_output") digitalOutput: String,
    ): Response<BaseResponse<DrmVideoDetail>>
}
