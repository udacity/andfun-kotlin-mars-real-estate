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

package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsrealestate.network.MarsAPI
import com.example.android.marsrealestate.network.MarsProperty
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _status

    //single Mars Property


    private val _property = MutableLiveData<MarsProperty>()
    val property:LiveData<MarsProperty>
    get() = _property



    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {

        //viewModel Scope to launch Coroutine
        viewModelScope.launch {

            //try-catch block
            try {

                val listResult = MarsAPI.retrofitService.getProperties()
                _status.value = "Success ${listResult.size} Mars Properties retrieved"

                //if returned properties are not empty set property to the first returned MarsPropertiy

                if (listResult.isNotEmpty()){

                    _property.value = listResult[0]

                }

            }catch (e: Exception){
                _status.value = "Failure - ${e.message}"

            }


        }
    }
}






/* private fun getMarsRealEstateProperties() {
//MarsAPI.retrofitService.getProperties() returns a Call Object

        //we call enqueue to start a network request on the background

        //enqueue takes a retrofit CallBack class's input that contains methods that will be called when
        // the request is complete

        MarsAPI.retrofitService.getProperties().enqueue(object:Callback<List<MarsProperty>>{
            override fun onResponse(call: Call<List<MarsProperty>>, response: Response<List<MarsProperty>>) {
                _response.value = "Success ${response.body()?.size} properties found"
            }

            override fun onFailure(call: Call<List<MarsProperty>>, t: Throwable) {
            _response.value = t.message
            }
        })
        _response.value = "Set the Mars API Response here!"
    }*/
