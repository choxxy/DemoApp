package co.demo.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import co.demo.core.data.source.local.entity.MarketEntity

@Database(entities = [MarketEntity::class], version = 1, exportSchema = false)
abstract class DemoAppDatabase : RoomDatabase() {
    abstract fun marketDao(): MarketDao
    abstract fun testDataDao(): TestDataDao
}