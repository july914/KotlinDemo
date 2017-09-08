package yuliya.example.com.kotlindemo.interfaces

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

import yuliya.example.com.kotlindemo.models.VKResponse

/**
 * Created by yuliya on 08.09.17.
 */
interface VkontakteApi {
    @GET("/method/friends.get")
    fun VkontakteApi(@Query("user_id") resourceID: String, @Query("fields") photo: String, @Query("access_token") token: String, @Query("v") version: String, @Query("lang") language: String): Call<VKResponse>
}