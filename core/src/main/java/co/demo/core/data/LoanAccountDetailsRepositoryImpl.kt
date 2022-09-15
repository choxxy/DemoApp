package co.demo.core.data

import co.demo.core.data.source.remote.CountryRemoteDataSource
import co.demo.core.data.source.remote.LoanDataRemoteDataSource
import co.demo.core.domain.model.LoanAccountDetails
import co.demo.core.domain.repository.LoanAccountDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoanAccountDetailsRepositoryImpl @Inject constructor(
    private val marketRemoteSource: CountryRemoteDataSource,
    private val loansRemoteSource: LoanDataRemoteDataSource
) : LoanAccountDetailsRepository {

    override fun getLoanAccountDetails(
        countryCode: String,
        loanStatus: String
    ): Flow<LoanAccountDetails> =
        flow {
            val marketResponse = marketRemoteSource.getCountries()
            val loanResponse = loansRemoteSource.getLoanData()

            val marketData = marketResponse[countryCode]
            val loanData = loanResponse.firstOrNull {
                ((it.locale == countryCode) && (it.loan?.status == loanStatus.lowercase()))
            }

            emit(LoanAccountDetails(marketData, loanData))

        }
}

