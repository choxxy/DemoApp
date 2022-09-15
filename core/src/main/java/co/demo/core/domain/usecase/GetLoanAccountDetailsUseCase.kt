package co.demo.core.domain.usecase

import co.demo.core.domain.model.LoanDetails
import co.demo.core.domain.repository.LoanAccountDetailsRepository
import javax.inject.Inject

class GetLoanAccountDetailsUseCase @Inject constructor(private val loanAccountDetailsRepository: LoanAccountDetailsRepository) {
    operator fun invoke(countryCode: String, loanStatus: String) =
        loanAccountDetailsRepository.getLoanAccountDetails(countryCode, loanStatus)
}
