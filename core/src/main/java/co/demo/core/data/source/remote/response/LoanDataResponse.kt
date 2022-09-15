package co.demo.core.data.source.remote.response

import co.demo.core.domain.model.LoanAccount
import kotlinx.serialization.Serializable

@Serializable
class LoanDataResponse : ArrayList<LoanAccount>()
