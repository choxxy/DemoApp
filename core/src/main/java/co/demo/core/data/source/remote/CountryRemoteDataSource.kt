package co.demo.core.data.source.remote

import co.demo.core.data.source.FileReader
import co.demo.core.data.source.remote.response.CountryResponse
import com.google.gson.Gson
import javax.inject.Inject

class CountryRemoteDataSource @Inject constructor(private val fileReader: FileReader) {
    fun getCountries(): CountryResponse {
        val json = fileReader.getFileContent("countries")
        val gson = Gson()
        return gson.fromJson(json, CountryResponse::class.java)
    }
}