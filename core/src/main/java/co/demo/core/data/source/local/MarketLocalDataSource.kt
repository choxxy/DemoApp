package co.demo.core.data.source.local

import co.demo.core.data.source.local.room.MarketDao
import javax.inject.Inject

class MarketLocalDataSource @Inject constructor(private val marketDao: MarketDao) {

}