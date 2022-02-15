package com.ipcoding.coachpro.feature.presentation.info

import androidx.activity.compose.BackHandler
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipcoding.coachpro.core.data.resources.AndroidResourceProvider
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.di.AppModule
import com.ipcoding.coachpro.feature.data.repository.*
import com.ipcoding.coachpro.feature.domain.use_case.*
import com.ipcoding.coachpro.feature.presentation.MainActivity
import com.ipcoding.coachpro.feature.presentation.main.MainScreen
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.CoachProTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class InfoScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController
    private lateinit var clubRepository: ClubRepositoryFake
    private lateinit var playerRepository: PlayerRepositoryFake
    private lateinit var historyRepository: HistoryRepositoryFake
    private lateinit var matchRepository: MatchRepositoryFake
    private lateinit var matchesRepository: MatchesRepositoryFake
    private lateinit var allUseCases: AllUseCases
    private lateinit var infoViewModel: InfoViewModel
    private lateinit var preferences: Preferences
    private lateinit var resourceProvider: AndroidResourceProvider


    //It doesn't work on API 30
    @Before
    fun setUp() {
        preferences = mockk(relaxed = true)
        resourceProvider = mockk(relaxed = true)
        clubRepository = ClubRepositoryFake()
        playerRepository = PlayerRepositoryFake()
        historyRepository = HistoryRepositoryFake()
        matchRepository = MatchRepositoryFake()
        matchesRepository = MatchesRepositoryFake()
        allUseCases = AllUseCases(
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
            preparingForNewSeason = PreparingForNewSeason(clubRepository, preferences),
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
        infoViewModel = InfoViewModel(
            preferences = preferences,
            allUseCases = allUseCases
        )
        composeRule.setContent {
            CoachProTheme {
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.InfoScreen.route
                ) {
                    composable(route = Screen.InfoScreen.route) {
                        InfoScreen(navController = navController)
                        BackHandler(true) {}
                    }
                    composable(route = Screen.MainScreen.route) {
                        MainScreen(navController = navController)
                        BackHandler(true) {}
                    }
                }
            }
        }
    }

    @Test
    fun continueButton_isCorrect() {

        composeRule.onNodeWithText("Continue").assertHasClickAction()
    }
}