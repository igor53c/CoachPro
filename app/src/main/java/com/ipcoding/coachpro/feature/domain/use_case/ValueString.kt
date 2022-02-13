package com.ipcoding.coachpro.feature.domain.use_case

class ValueString {

    operator fun invoke(budget: Float) : String {
        return String.format("%.1f", budget) + " M€"
    }
}