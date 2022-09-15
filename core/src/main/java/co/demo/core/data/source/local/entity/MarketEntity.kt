package co.demo.core.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "markets")
data class MarketEntity(
    @PrimaryKey
    val id: Int,
)