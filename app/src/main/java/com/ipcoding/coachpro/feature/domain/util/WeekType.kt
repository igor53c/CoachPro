package com.ipcoding.coachpro.feature.domain.util

sealed class WeekType(var text: String = "") {

    class Transfers(text: String) : WeekType(text)
    class Schedule(text: String) : WeekType(text)
    class Tactics(text: String) : WeekType(text)
    class Else(text: String) : WeekType(text)
}
