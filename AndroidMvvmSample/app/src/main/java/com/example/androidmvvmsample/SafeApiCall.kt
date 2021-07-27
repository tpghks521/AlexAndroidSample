package com.example.androidmvvmsample

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val code: Int? = null, val error: ErrorResponse? = null) :
        ResultWrapper<Nothing>()

    data class NetworkError(val error: IOException) : ResultWrapper<Nothing>()
    data class UnknownError(val throwable: Throwable) : ResultWrapper<Nothing>()
}

data class ErrorRequest(
    var productId: Int? = 0,
    var multiOptionId: Int? = 0,
    var bundleOptionId: Int? = 0,
    var quantity: Int? = 0,
    var buyAtStickerShop: Boolean? = false
)

data class ErrorResponse(
    var errorCode: String? = "",
    var errorMessage: String? = "",
    var errorRequest: ErrorRequest? = null
)

suspend fun <T : Any?> safeApiCall(
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(Dispatchers.Default) {
        try {

            val call = apiCall.invoke() ?: throw Exception()
            ResultWrapper.Success(call)

        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = responseErrorBodyConvert(throwable.response()?.errorBody())
                    ResultWrapper.GenericError(code, errorResponse)
                }
                is IOException -> ResultWrapper.NetworkError(throwable)
                else -> {
                    ResultWrapper.UnknownError(throwable)
                }
            }
        }
    }
}

private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    return try {
        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}

fun responseErrorBodyConvert(errorBody: ResponseBody?): ErrorResponse {
    try {
        if (errorBody.toString().isEmpty()) {
            return ErrorResponse(errorBody.toString(), errorBody.toString())
        } else {
            val type = object : TypeToken<ErrorResponse>() {}.type
            return Gson().fromJson(errorBody?.charStream(), type)
        }
    } catch (e1: Exception) {
    }
    return ErrorResponse("", "")
}