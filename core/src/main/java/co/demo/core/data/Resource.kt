package co.demo.core.data

sealed class Resource<T : Any> {
    class Loading<T : Any> : Resource<T>()
    class Success<T : Any>(val data: T) : Resource<T>()
    class Failure<T : Any>(val code: Int, val message: String?) : Resource<T>()
}
