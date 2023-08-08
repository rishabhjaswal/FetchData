package com.example.fetchdata.networkcalls

import androidx.databinding.library.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {
    private lateinit var cacheUtilIs: CacheUtil

    fun cacheUtil(): CacheUtil {
        return if (NetworkModule::cacheUtilIs.isInitialized) {
            cacheUtilIs
        } else {
            cacheUtilIs = CacheUtil()
            cacheUtilIs
        }
    }

    private val provideOkHttpClient: OkHttpClient =
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                /*  .addInterceptor { chain ->
                      val original = chain.request()
                      val request = original.newBuilder()
                          .header("Authorization", "token")
                          .header("lang", "ENGLISH")
                          //                    .method(original.method, original.body)
                          .build()
                      chain.proceed(request)
                  }*/
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient
                .Builder()
                .build()
        }

    private val provideRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideOkHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()

    fun provideApiService(): RetrofitApi =
        provideRetrofit.create(RetrofitApi::class.java)

}