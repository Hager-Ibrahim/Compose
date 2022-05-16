package com.example.compose.ui.navigation.test

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.ui.common.helper.visible
import com.example.compose.ui.helper.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



//@Composable
//fun SetupNavGraph(navHostController: NavHostController) {
//    NavHost(
//        navController = navHostController,
//        startDestination = MainScreen.route
//    ) {
//
//        composable(route = MainScreen.route) {
//            val viewModel: MainViewModel = viewModel()
//            MainScreen(navHostController, viewModel)
//        }
//
//        composable(route = DetailsScreen.route) {
//            DetailsScreen()
//        }
//    }
//}
//
//
//@Composable
//fun MainScreen(navController: NavController, viewModel: MainViewModel) {
//    val event = viewModel.navigate.observeAsState().value
//    val isLoading: Boolean by viewModel.isLoading
//
//    DisposableEffect(key1 = isLoading) {
//        Log.d("TEST", "MainScreen: start")
//        onDispose {
//            Log.d("TEST", "MainScreen: stop")
//        }
//    }
//
//    LaunchedEffect(event) {
//        event?.getContentIfNotHandled()?.let {
//            navController.navigate(route = DetailsScreen.route)
//        }
//
//    }
//    MainContent(isLoading) {
//        viewModel.fakeNetworkCall()
//    }
//}
//
//
//@Composable
//fun MainContent(
//    isLoading: Boolean,
//    onClick: () -> Unit
//) {
//    Surface(
//        color = Color.White,
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//        Column() {
//            Text("Main screen", Modifier.clickable {
//
//            })
//
//            Button(onClick = {
//                onClick()
//            }) {
//                Text(text = "login")
//            }
//
//            CircularProgressIndicator(Modifier.visible(isLoading))
//        }
//    }
//}
//
//class MainViewModel: ViewModel() {
//
//    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
//    val isLoading: State<Boolean> get() = _isLoading
//
//    private val _navigate = MutableLiveData<Event<MainEvent>>()
//    val navigate: LiveData<Event<MainEvent>>
//        get() = _navigate
//
//
//    fun fakeNetworkCall() {
//        viewModelScope.launch {
//            _isLoading.value = true
//            delay(2000)
//            Log.d("TAG", "fakeNetworkCall: ")
//            _isLoading.value = false
//            _navigate.postValue(Event(MainEvent.Navigate))
//
//        }
//
//    }
//}
//
//sealed class MainEvent() {
//    object Navigate : MainEvent()
//}
//
//sealed class Screens(val route: String) {
//    object MainScreen : Screens("main_screen")
//    object DetailsScreen : Screens("detail_screen")
//}
//
//@Composable
//fun DetailsScreen() {
//    Surface(
//        color = Color.White,
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//        Text("Detail screen")
//    }
//
//}