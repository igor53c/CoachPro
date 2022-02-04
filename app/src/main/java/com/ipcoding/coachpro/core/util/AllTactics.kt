package com.ipcoding.coachpro.core.util

class AllTactics {
    companion object {
        val T_541: List<Any> = listOf("5-4-1", 1, 5, 4, 1)
        val T_532: List<Any> = listOf("5-3-2", 1, 5, 3, 2)
        val T_451: List<Any> = listOf("4-5-1", 1, 4, 5, 1)
        val T_442: List<Any> = listOf("4-4-2", 1, 4, 4, 2)
        val T_433: List<Any> = listOf("4-3-3", 1, 4, 3, 3)
        val T_352: List<Any> = listOf("3-5-2", 1, 3, 5, 2)
        val T_343: List<Any> = listOf("3-4-3", 1, 3, 4, 3)
    }

    fun allTactics(): List<List<Any>> {
        return listOf(T_541, T_532, T_451, T_442, T_433, T_352, T_343)
    }

    fun getTactics(name: String): List<Any> {
        var list: List<Any> = emptyList()
       when(name) {
            "5-4-1" -> list = T_541
            "5-3-2" -> list = T_532
            "4-5-1" -> list = T_451
            "4-4-2" -> list = T_442
            "4-3-3" -> list = T_433
            "3-5-2" -> list = T_352
            "3-4-3" -> list = T_343
        }
        return  list
    }
}