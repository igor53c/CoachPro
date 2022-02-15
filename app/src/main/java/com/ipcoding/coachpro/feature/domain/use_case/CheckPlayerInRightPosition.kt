package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class CheckPlayerInRightPosition {

    operator fun invoke(player: Player?, item1: Int, item2: Int,  tactics: List<Any>): Boolean {
       var isCorrect = false
        player?.let {
            val position = player.position
            isCorrect = when(item1) {
                0 -> if(item2 == 0) position == "GK" else false
                1 -> {
                    //defense
                    when(tactics[2]) {
                        3 -> {
                            when(item2) {
                                0 -> position == "DRC" || position == "DC"
                                1 -> position == "DRC" || position == "DC" || position == "DLC"
                                2 -> position == "DC" || position == "DLC"
                                else -> false
                            }
                        }
                        4 -> {
                            when(item2) {
                                0 -> position == "DR" || position == "DRC" || position == "DRL"
                                1 -> position == "DRC" || position == "DC"
                                2 -> position == "DC" || position == "DLC"
                                3 -> position == "DLC" || position == "DL" || position == "DRL"
                                else -> false
                            }
                        }
                        5 -> {
                            when(item2) {
                                0 -> position == "DR" || position == "DRC" || position == "DRL"
                                1 -> position == "DRC" || position == "DC"
                                2 -> position == "DRC" || position == "DC" || position == "DLC"
                                3 -> position == "DC" || position == "DLC"
                                4 -> position == "DLC" || position == "DL" || position == "DRL"
                                else -> false
                            }
                        }
                        else -> false

                    }
                }
                2 -> {
                    //midfield
                    when(tactics[3]) {
                        3 -> {
                            when(item2) {
                                0 -> position == "MRC" || position == "MC"
                                1 -> position == "MRC" || position == "MC" || position == "MLC"
                                2 -> position == "MC" || position == "MLC"
                                else -> false
                            }
                        }
                        4 -> {
                            when(item2) {
                                0 -> position == "MR" || position == "MRC" || position == "MRL"
                                1 -> position == "MRC" || position == "MC"
                                2 -> position == "MC" || position == "MLC"
                                3 -> position == "MLC" || position == "ML" || position == "MRL"
                                else -> false
                            }
                        }
                        5 -> {
                            when(item2) {
                                0 -> position == "MR" || position == "MRC" || position == "MRL"
                                1 -> position == "MRC" || position == "MC"
                                2 -> position == "MRC" || position == "MC" || position == "MLC"
                                3 -> position == "MC" || position == "MLC"
                                4 -> position == "MLC" || position == "ML" || position == "MRL"
                                else -> false
                            }
                        }
                        else -> false
                    }
                }
                3 -> {
                    //attack
                    when(tactics[4]) {
                        1 -> position == "FRC" || position == "FC" || position == "FLC"
                        2 -> {
                            when(item2) {
                                0 -> position == "FR" || position == "FRC" || position == "FRL"
                                1 -> position == "FLC" || position == "FL" || position == "FRL"
                                else -> false
                            }
                        }
                        3 -> {
                            when(item2) {
                                0 -> position == "FR" || position == "FRC" || position == "FRL"
                                1 -> position == "FRC" || position == "FC" || position == "FLC"
                                2 -> position == "FL" || position == "FLC" || position == "FRL"
                                else -> false
                            }
                        }
                        else -> false
                    }
                }
                4 -> true
                else -> false
            }
        }
        return isCorrect
    }
}