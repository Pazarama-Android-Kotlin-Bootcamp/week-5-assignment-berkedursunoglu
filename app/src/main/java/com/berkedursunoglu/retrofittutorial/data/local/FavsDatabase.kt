package com.berkedursunoglu.retrofittutorial.data.local

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.berkedursunoglu.retrofittutorial.DaoConverter
import com.berkedursunoglu.retrofittutorial.data.model.PostDTO
import retrofit2.Converter

@Database(entities = [PostEntity::class], version = 1)
@TypeConverters(DaoConverter::class)
abstract class FavsDatabase : RoomDatabase() {
    abstract fun postDao(): FavDAO

    companion object {
        private var instance: FavsDatabase? = null

        fun getDatabase(context: Context): FavsDatabase = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, FavsDatabase::class.java, "favs")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()

    }
}
