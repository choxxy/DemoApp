package co.demo.home.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.demo.core.domain.model.LoanAccountDetails
import co.demo.core.domain.usecase.GetLoanAccountDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val loanAccountDetailsUseCase: GetLoanAccountDetailsUseCase,
) : ViewModel() {

    private var selectedCountry = "ke"

    private val _loanAccountDetails = MutableStateFlow(LoanAccountDetails())
    val loanAccountDetails: StateFlow<LoanAccountDetails> = _loanAccountDetails

    fun getLoanAccountDetails(country: String, viewState: ViewState) {
        viewModelScope.launch {
            loanAccountDetailsUseCase(country, viewState.state)
                .collect { details ->
                    _loanAccountDetails.value = details
                }
        }
        selectedCountry = country
    }

    fun getLoanAccountDetails(viewState: ViewState) {
        getLoanAccountDetails(selectedCountry, viewState)
    }

    fun getCountry(): String {
        return selectedCountry
    }
}

enum class ViewState(val state: String) {
    Approved("Approved"),
    Paid("Paid"),
    New("New"),
    Due("Due");
}