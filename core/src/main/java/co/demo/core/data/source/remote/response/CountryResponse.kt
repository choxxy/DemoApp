package co.demo.core.data.source.remote.response

import co.demo.core.domain.model.Country
import kotlinx.serialization.Serializable

@Serializable
class CountryResponse : HashMap<String, Country>()