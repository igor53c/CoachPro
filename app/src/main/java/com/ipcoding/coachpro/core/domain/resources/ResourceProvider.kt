package com.ipcoding.coachpro.core.domain.resources

interface ResourceProvider {

    fun getString(resourceIdentifier: Int): String
}