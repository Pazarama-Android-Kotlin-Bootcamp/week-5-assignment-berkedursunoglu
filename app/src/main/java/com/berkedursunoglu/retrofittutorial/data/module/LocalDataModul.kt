package com.berkedursunoglu.retrofittutorial.data.module

import android.content.Context
import com.berkedursunoglu.retrofittutorial.data.local.FavsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {


    @Provides
    @Singleton
    fun providePostsDatabase(@ApplicationContext appContext: Context): FavsDatabase {
        return FavsDatabase.getDatabase(appContext)
    }

    @Singleton
    @Provides
    fun providePostDao(db: FavsDatabase) = db.postDao()

}