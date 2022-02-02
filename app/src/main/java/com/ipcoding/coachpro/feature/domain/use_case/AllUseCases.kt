package com.ipcoding.coachpro.feature.domain.use_case

data class AllUseCases (
    val getClubsFromLeague: GetClubsFromLeague,
    val checkColors: CheckColors,
    val createClubDatabase: CreateClubDatabase,
    val getPlayers: GetPlayers,
    val getColorDependingOnPosition: GetColorDependingOnPosition,
    val updatePlayer: UpdatePlayer
)