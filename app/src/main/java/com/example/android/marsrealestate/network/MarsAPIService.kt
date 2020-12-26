/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


//Root or Base URL
private const val BASE_URL = "https://mars.udacity.com/"


//Moshi builder
val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()) //help with Moshi's annotations
        .build()

//Retrofit builder
private val retrofit =
        Retrofit.Builder()          //transform JSON response to String
                .addConverterFactory(ScalarsConverterFactory.create())
                                   //transform JSON response to Kotlin Objects
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
                .build()





  /*interface with @GET that tells HTTP what this request is for;
   we pass in the endpoint*/
 interface MarsAPIService {

     @GET("realestate")
     fun getProperties(): Call<List<MarsProperty>>


 }

//MarsAPI Object - is a singleton because creating it is expensive
object MarsAPI {


    val retrofitService: MarsAPIService by lazy {


        //to create a retrofit service you call retrofit.create passing in the interface
        retrofit.create(MarsAPIService::class.java)
    }
}

