package com.ipcoding.coachpro.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.ipcoding.coachpro.core.data.preferences.DefaultPreferences
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.data.data_source.CoachDatabase
import com.ipcoding.coachpro.feature.data.repository.*
import com.ipcoding.coachpro.feature.domain.repository.*
import com.ipcoding.coachpro.feature.domain.use_case.*
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
    fun provideCoachDatabase(app: Application): CoachDatabase {
        return Room.databaseBuilder(
            app,
            CoachDatabase::class.java,
            CoachDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePlayerRepository(db: CoachDatabase): PlayerRepository {
        return PlayerRepositoryImpl(db.playerDao)
    }

    @Provides
    @Singleton
    fun provideClubRepository(db: CoachDatabase): ClubRepository {
        return ClubRepositoryImpl(db.clubDao)
    }

    @Provides
    @Singleton
    fun provideHistoryRepository(db: CoachDatabase): HistoryRepository {
        return HistoryRepositoryImpl(db.historyDao)
    }

    @Provides
    @Singleton
    fun provideMatchRepository(db: CoachDatabase): MatchRepository {
        return MatchRepositoryImpl(db.matchDao)
    }

    @Provides
    @Singleton
    fun provideMatchesRepository(db: CoachDatabase): MatchesRepository {
        return MatchesRepositoryImpl(db.matchesDao)
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
    fun provideUseCases(
        playerRepository: PlayerRepository,
        clubRepository: ClubRepository,
        historyRepository: HistoryRepository,
        matchRepository: MatchRepository,
        matchesRepository: MatchesRepository
    ): AllUseCases {
        return AllUseCases(
            getClubsFromLeague = GetClubsFromLeague(),
            checkColors = CheckColors(),
            createClubDatabase = CreateClubDatabase(
                playerRepository,
                clubRepository,
                historyRepository,
                matchRepository,
                matchesRepository
            ),
            getPlayers = GetPlayers(playerRepository),
            getColorDependingOnPosition = GetColorDependingOnPosition(),
            updatePlayer = UpdatePlayer(playerRepository)
        )
    }
}