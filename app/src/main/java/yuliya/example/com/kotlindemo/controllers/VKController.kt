package yuliya.example.com.kotlindemo.controllers

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import yuliya.example.com.kotlindemo.interfaces.VkontakteApi


class VKController : Application(){

    private var retrofit: Retrofit? = null

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()

        vkontakteApi = retrofit!!.create<VkontakteApi>(VkontakteApi::class.java)
    }

    companion object {

        private var vkontakteApi: VkontakteApi? = null
        val vkApi: VkontakteApi?
            get() {

                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                return vkontakteApi
            }
    }
}