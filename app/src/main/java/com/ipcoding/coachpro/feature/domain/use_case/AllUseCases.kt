package com.ipcoding.coachpro.feature.domain.use_case

data class AllUseCases (
    val getClubsFromLeague: GetClubsFromLeague,
    val checkColors: CheckColors,
    val createClubDatabase: CreateClubDatabase,
    val getPlayers: GetPlayers,
    val getColorDependingOnPosition: GetColorDependingOnPosition,
    val updatePlayer: UpdatePlayer,
    val getStringLeague: GetStringLeague,
    val getClubs: GetClubs,
    val getColorOfClubInTable: GetColorOfClubInTable,
    val getClubPositionString: GetClubPositionString,
    val getPlayerInfo: GetPlayerInfo,
    val replaceTwoPlayers: ReplaceTwoPlayers,
    val getPlayer: GetPlayer,
    val checkPlayerInRightPosition: CheckPlayerInRightPosition,
    val CalculationFirstTeamRating: CalculationFirstTeamRating,
    val saveFirstTeamRating: SaveFirstTeamRating,
    val calculationTeamRating: CalculationTeamRating,
    val getPlayersRating: GetPlayersRating,
    val getClubRating: GetClubRating,
    val makeSchedule: MakeSchedule,
    val getAllMatches: GetAllMatches
)