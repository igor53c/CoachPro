package com.ipcoding.coachpro.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.ipcoding.coachpro.core.data.preferences.DefaultPreferences
import com.ipcoding.coachpro.core.data.resources.AndroidResourceProvider
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.domain.resources.ResourceProvider
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
object AppModuleTest {

    @Provides
    @Singleton
    fun provideCoachDatabase(app: Application): CoachDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            CoachDatabase::class.java,
        ).build()
    }

   @Provides
    @Singleton
    fun providePlayerRepository(): PlayerRepository {
        return PlayerRepositoryFake()
    }

    @Provides
    @Singleton
    fun provideClubRepository(): ClubRepository {
        return ClubRepositoryFake()
    }

    @Provides
    @Singleton
    fun provideHistoryRepository(): HistoryRepository {
        return HistoryRepositoryFake()
    }

    @Provides
    @Singleton
    fun provideMatchRepository(): MatchRepository {
        return MatchRepositoryFake()
    }

    @Provides
    @Singleton
    fun provideMatchesRepository(): MatchesRepository {
        return MatchesRepositoryFake()
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences) : Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideAndroidResources(context: Context): ResourceProvider {
        return AndroidResourceProvider(context)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        playerRepository: PlayerRepository,
        clubRepository: ClubRepository,
        historyRepository: HistoryRepository,
        matchRepository: MatchRepository,
        matchesRepository: MatchesRepository,
        preferences: Preferences,
        resourceProvider: ResourceProvider
    ): AllUseCases {
        return AllUseCases(
            getClubsFromLeague = GetClubsFromLeague(),
            checkColors = CheckColors(),
            createClubDatabase = CreateClubDatabase(
                playerRepository,
                clubRepository,
                historyRepository,
                matchRepository,
                matchesRepository,
                preferences
            ),
            getPlayers = GetPlayers(playerRepository),
            getColorDependingOnPosition = GetColorDependingOnPosition(),
            updatePlayer = UpdatePlayer(playerRepository),
            getStringLeague = GetStringLeague(),
            getClubs = GetClubs(clubRepository),
            getColorOfClubInTable = GetColorOfClubInTable(),
            getClubPositionString = GetClubPositionString(clubRepository),
            getPlayerInfo = GetPlayerInfo(),
            replaceTwoPlayers = ReplaceTwoPlayers(playerRepository),
            getPlayer = GetPlayer(),
            checkPlayerInRightPosition = CheckPlayerInRightPosition(),
            CalculationFirstTeamRating = CalculationFirstTeamRating(),
            saveFirstTeamRating = SaveFirstTeamRating(clubRepository),
            calculationTeamRating = CalculationTeamRating(),
            getPlayersRating = GetPlayersRating(clubRepository),
            getClubRating = GetClubRating(clubRepository),
            makeSchedule = MakeSchedule(clubRepository, matchRepository),
            getAllMatches = GetAllMatches(matchRepository),
            getMonth = GetMonth(),
            getWeekTypeText = GetWeekTypeText(
                preferences,
                matchRepository,
                clubRepository,
                resourceProvider
            ),
            playRound = PlayRound(matchRepository, clubRepository, playerRepository, preferences),
            preparingForNewSeason = PreparingForNewSeason(
                clubRepository, matchRepository,preferences),
            preparationOfClubsAndScheduling = PreparationOfClubsAndScheduling(
                clubRepository, matchRepository
            ),
            changeHistory = ChangeHistory(clubRepository, historyRepository),
            changePlayersYear = ChangePlayersYear(playerRepository),
            getClubsFromLeagueByPosition = GetClubsFromLeagueByPosition(clubRepository),
            getClubMatchFromNextRound = GetClubMatchFromNextRound(matchRepository),
            trainingCalculation = TrainingCalculation(playerRepository, clubRepository),
            getHistory = GetHistory(historyRepository),
            getNumberOfYears = GetNumberOfYears(historyRepository),
            valueString = ValueString(),
            insertTransferPlayers = InsertTransferPlayers(playerRepository, clubRepository),
            getTactics = GetTactics(),
            getTransferPlayers = GetTransferPlayers(playerRepository),
            getNumberOfPlayers = GetNumberOfPlayers(playerRepository),
            transferWindow = TransferWindow(),
            randomPlayer = RandomPlayer(playerRepository),
            deletePlayer = DeletePlayer(playerRepository)
        )
    }
}