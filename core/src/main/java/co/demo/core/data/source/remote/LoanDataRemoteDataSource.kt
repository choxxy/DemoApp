package co.demo.core.data.source.remote

import co.demo.core.data.source.FileReader
import co.demo.core.data.source.remote.response.LoanDataResponse
import com.google.gson.Gson
import javax.inject.Inject

class LoanDataRemoteDataSource @Inject constructor(private val fileReader: FileReader) {
    fun getLoanData(): LoanDataResponse {
        val json = fileReader.getFileContent("loandata")
        val gson = Gson()
        return gson.fromJson(json, LoanDataResponse::class.java)
    }
}