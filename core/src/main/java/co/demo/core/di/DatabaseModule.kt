package co.demo.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import co.demo.core.data.source.local.room.MarketDao
import co.demo.core.data.source.local.room.DemoAppDatabase
import co.demo.core.data.source.local.room.TestDataDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DemoAppDatabase =
        Room.databaseBuilder(
            context,
            DemoAppDatabase::class.java, "demo.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMarketDao(database: DemoAppDatabase): MarketDao = database.marketDao()

    @Provides
    fun provideTestDataDao(database: DemoAppDatabase): TestDataDao = database.testDataDao()
}