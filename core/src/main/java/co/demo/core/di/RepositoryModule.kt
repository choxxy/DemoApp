package co.demo.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import co.demo.core.data.LoanAccountDetailsRepositoryImpl
import co.demo.core.domain.repository.LoanAccountDetailsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: LoanAccountDetailsRepositoryImpl): LoanAccountDetailsRepository
}