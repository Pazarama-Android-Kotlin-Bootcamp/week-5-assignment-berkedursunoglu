package com.berkedursunoglu.retrofittutorial.data.module

import com.berkedursunoglu.retrofittutorial.data.api.ApiServices
import com.berkedursunoglu.retrofittutorial.data.local.FavsDatabase
import com.berkedursunoglu.retrofittutorial.repository.PostRepository
import com.berkedursunoglu.retrofittutorial.repository.PostRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class PostModule {

    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiServices {
        return retrofit.create(ApiServices::class.java)
    }

    @Provides
    fun providePostRepository(apiService: ApiServices, postsDatabase: FavsDatabase) : PostRepository {
        return PostRepositoryImp(apiService, postsDatabase)
    }

}