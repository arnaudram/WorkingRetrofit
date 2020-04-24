package com.example.workingretrofit.networkservice

import com.example.workingretrofit.model.EntityDatabase
import com.example.workingretrofit.model.EntityNetwork
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL="https://mars.udacity.com/"
val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
val retrofit=Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(  BASE_URL)
    .build()


interface WallPaperCaveApiService {
    @GET("realestate")
    fun getProperties():Deferred<List<EntityNetwork>>
}




    object NetWork {

        val webService by lazy {
            retrofit.create(WallPaperCaveApiService::class.java)
        }
    }





