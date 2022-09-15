package co.demo.core.data.source.remote.network

import co.demo.core.data.source.remote.response.CountryResponse
import co.demo.core.data.source.remote.response.LoanDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("markets")
    suspend fun getMarkets(): Response<CountryResponse>

    @GET("loandata")
    suspend fun getLoanData(): Response<LoanDataResponse>
}