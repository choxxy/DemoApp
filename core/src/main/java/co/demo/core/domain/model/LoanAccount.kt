package co.demo.core.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoanAccount(
    @SerialName("loan")
    val loan: Loan? = null,
    @SerialName("locale")
    val locale: String = "",
    @SerialName("timestamp")
    val timestamp: Long = 0,
    @SerialName("username")
    val username: String = ""
)

@Serializable
data class Loan(
    @SerialName("approved")
    val approved: Int,
    @SerialName("due")
    val due: Int,
    @SerialName("dueDate")
    val dueDate: Long,
    @SerialName("level")
    val level: String,
    @SerialName("status")
    val status: String
)