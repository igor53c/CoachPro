package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class CheckPlayerInRightPosition {

    operator fun invoke(player: Player?, item1: Int, item2: Int,  tactics: List<Any>): Boolean {
       var isCorrect = false
        player?.let {
            when(item1) {
                0 -> if(item2 == 0) isCorrect = player.position == "GK"
                1 -> {
                    //defense
                    when(tactics[2]) {
                        3 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "DRC" || player.position == "DC"
                                1 -> isCorrect = player.position == "DRC"
                                        || player.position == "DC" || player.position == "DLC"
                                2 -> isCorrect = player.position == "DC" || player.position == "DLC"
                            }
                        }
                        4 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "DR"
                                        || player.position == "DRC" || player.position == "DRL"
                                1 -> isCorrect = player.position == "DRC" || player.position == "DC"
                                2 -> isCorrect = player.position == "DC" || player.position == "DLC"
                                3 -> isCorrect = player.position == "DLC"
                                        || player.position == "DL" || player.position == "DRL"
                            }
                        }
                        5 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "DR"
                                        || player.position == "DRC" || player.position == "DRL"
                                1 -> isCorrect = player.position == "DRC" || player.position == "DC"
                                2 -> isCorrect = player.position == "DRC"
                                        || player.position == "DC" || player.position == "DLC"
                                3 -> isCorrect = player.position == "DC" || player.position == "DLC"
                                4 -> isCorrect = player.position == "DLC"
                                        || player.position == "DL" || player.position == "DRL"
                            }
                        }
                    }
                }
                2 -> {
                    //midfield
                    when(tactics[3]) {
                        3 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "MRC" || player.position == "MC"
                                1 -> isCorrect = player.position == "MRC"
                                        || player.position == "MC" || player.position == "MLC"
                                2 -> isCorrect = player.position == "MC" || player.position == "MLC"
                            }
                        }
                        4 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "MR"
                                        || player.position == "MRC" || player.position == "MRL"
                                1 -> isCorrect = player.position == "MRC" || player.position == "MC"
                                2 -> isCorrect = player.position == "MC" || player.position == "MLC"
                                3 -> isCorrect = player.position == "MLC"
                                        || player.position == "ML" || player.position == "MRL"
                            }
                        }
                        5 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "MR"
                                        || player.position == "MRC" || player.position == "MRL"
                                1 -> isCorrect = player.position == "MRC" || player.position == "MC"
                                2 -> isCorrect = player.position == "MRC"
                                        || player.position == "MC" || player.position == "MLC"
                                3 -> isCorrect = player.position == "MC" || player.position == "MLC"
                                4 -> isCorrect = player.position == "MLC"
                                        || player.position == "ML" || player.position == "MRL"
                            }
                        }
                    }
                }
                3 -> {
                    //attack
                    when(tactics[4]) {
                        1 -> isCorrect = player.position == "FRC"
                                || player.position == "FC" || player.position == "FLC"
                        2 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "FR"
                                        || player.position == "FRC" || player.position == "FRL"
                                1 -> isCorrect = player.position == "FLC"
                                        || player.position == "FL" || player.position == "FRL"
                            }
                        }
                        3 -> {
                            when(item2) {
                                0 -> isCorrect = player.position == "FR"
                                        || player.position == "FRC" || player.position == "FRL"
                                1 -> isCorrect = player.position == "FRC"
                                        || player.position == "FC" || player.position == "FLC"
                                2 -> isCorrect = player.position == "FL"
                                        || player.position == "FLC" || player.position == "FRL"
                            }
                        }
                    }
                }
                4 -> isCorrect = true
            }
        }
        return isCorrect
    }
}