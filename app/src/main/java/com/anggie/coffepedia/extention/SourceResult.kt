package com.anggie.coffepedia.extention

sealed class SourceResult<out Data> {
    data class Loading<out Data>(val data: Data? = null) : SourceResult<Data>()
    data class Success<out Data>(val data: Data, val message: String?) : SourceResult<Data>()
    data class Failure<out Data>(val message: String, val data: Data? = null) : SourceResult<Data>()
    data class NoInternet<out Data>(val message: String) : SourceResult<Data>()

    inline fun <V> fold(
        loading: (data: Data?) -> V,
        success: (Data, String?) -> V,
        failure: (String, data: Data?) -> V,
        noInternet: (String) -> V,
    ): V = when (this) {
        is Loading -> loading(this.data)
        is Success -> success(this.data, this.message)
        is Failure -> failure(this.message, this.data)
        is NoInternet -> noInternet(this.message)
    }
}