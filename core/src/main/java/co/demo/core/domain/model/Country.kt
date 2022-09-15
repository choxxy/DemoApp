package co.demo.core.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("currency")
    val currency: String = "",
    @SerialName("loanLimit")
    val loanLimit: String = "0",
    @SerialName("timezone")
    val timezone: String = "0"
)