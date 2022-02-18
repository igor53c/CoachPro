package com.ipcoding.coachpro.feature.domain.use_case

class ValueString {

    operator fun invoke(value: Float): String {
        return String.format("%.1f", value) + " M€"
    }
}