package com.seno.bukawarungtest.rest

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.seno.bukawarungtest.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.reflect.Type
import javax.inject.Singleton

@Module
class RetrofitModule {

    private val jsonChecker = object : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            return Converter<ResponseBody, Any> { responseBody ->
                val delegate =
                    retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
                try {
                    delegate.convert(responseBody)
                } catch (error: Exception) {
                    error.message?.let { Log.e("quotes ", it) }
                    throw IOException("Terjadi kesalahan pada server")
                }
            }
        }
    }

    @Provides
    @Singleton
    fun providesResponseInterceptor(): ResponseInterceptor {
        return ResponseInterceptor()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        responseInterceptor: ResponseInterceptor
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(jsonChecker)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .also {
               responseInterceptor.retrofit = it
            }
    }

    @Provides
    @Singleton
    fun providesOkhttpClient(
        responseInterceptor: ResponseInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(responseInterceptor)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun providesUserService(retrofit: Retrofit): UserServices {
        return retrofit.create(UserServices::class.java)
    }

}