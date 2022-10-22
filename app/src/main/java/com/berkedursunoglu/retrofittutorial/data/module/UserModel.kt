package com.berkedursunoglu.retrofittutorial.data.module

import com.berkedursunoglu.retrofittutorial.data.api.UserService
import com.berkedursunoglu.retrofittutorial.repository.UserRepository
import com.berkedursunoglu.retrofittutorial.repository.UserRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class UserModel {

    @Provides
    fun provideApiService(retrofit: Retrofit) : UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun providePostRepository(apiService: UserService) : UserRepository {
        return UserRepositoryImp(apiService)
    }

}