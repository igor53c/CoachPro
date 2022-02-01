package com.ipcoding.coachpro.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.ipcoding.coachpro.core.data.preferences.DefaultPreferences
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.data.data_source.PlayerDatabase
import com.ipcoding.coachpro.feature.data.repository.PlayerRepositoryImpl
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import com.ipcoding.coachpro.feature.domain.use_case.CheckColors
import com.ipcoding.coachpro.feature.domain.use_case.CreateClubDatabase
import com.ipcoding.coachpro.feature.domain.use_case.GetClubsFromLeague
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoachDatabase(app: Application): PlayerDatabase {
        return Room.databaseBuilder(
            app,
            PlayerDatabase::class.java,
            PlayerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePlayerRepository(db: PlayerDatabase): PlayerRepository {
        return PlayerRepositoryImpl(db.playerDao)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences) : Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: PlayerRepository): AllUseCases {
        return AllUseCases(
            getClubsFromLeague = GetClubsFromLeague(),
            checkColors = CheckColors(),
            createClubDatabase = CreateClubDatabase(repository)
        )
    }
}