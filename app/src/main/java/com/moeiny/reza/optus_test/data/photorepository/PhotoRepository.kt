package com.moeiny.reza.optus_test.data.photorepository

import com.moeiny.reza.optus_test.data.model.apimodel.PhotoModel
import com.moeiny.reza.optus_test.data.retrofit.ApiService
import com.moeiny.reza.optus_test.core.result.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

interface PhotoRepository {
    fun fetchPhotoInfo(onResult: (result: Result<List<PhotoModel>>) -> Unit)
}

class PhotoRepositoryDefault @Inject constructor(private val apiService: ApiService) : PhotoRepository {
    override fun fetchPhotoInfo(onResult: (result: Result<List<PhotoModel>>) -> Unit) {

        onResult(Result.Loading)

        apiService.getPhotosInfo().enqueue(object :Callback<List<PhotoModel>>{
            override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                onResult(Result.Error(t))
            }

            override fun onResponse(call: Call<List<PhotoModel>>, response: Response<List<PhotoModel>>) {
                response.body()?.let {
                    onResult(Result.Success(it))
                }
            }
        })
    }
}



