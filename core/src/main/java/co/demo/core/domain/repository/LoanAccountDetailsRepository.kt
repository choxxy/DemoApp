package co.demo.core.domain.repository

import co.demo.core.domain.model.LoanAccountDetails
import kotlinx.coroutines.flow.Flow

interface LoanAccountDetailsRepository {
    fun getLoanAccountDetails(countryCode: String, loanStatus: String): Flow<LoanAccountDetails>
}