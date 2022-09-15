package co.demo.core.data.source.local

import co.demo.core.data.source.local.room.TestDataDao
import javax.inject.Inject

class DataLocalDataSource @Inject constructor(private val testDataDao: TestDataDao) {

}