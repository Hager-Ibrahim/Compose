package com.example.compose.ui.common.extentions

import androidx.navigation.NavController

fun NavController.navigateAndReplaceStartRoute(newRoute: String) {
    popBackStack(graph.startDestinationId, true)
    graph.setStartDestination(newRoute)
    navigate(newRoute)
}