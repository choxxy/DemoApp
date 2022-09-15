package co.demo.core.data.source.remote.network

import retrofit2.Response

object ResponseHandler {

    suspend fun <T> handleApiCall(apiCall: suspend () -> Response<T>): ApiResponse<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                response.body()?.let {
                    return ApiResponse.Success(it)
                }
            }
            return ApiResponse.Error(response.message())
        } catch (exception: Exception) {
            return ApiResponse.Error(exception.message.toString())
        }
    }

}