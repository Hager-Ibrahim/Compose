import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.compose.modules.home.HomeViewModel
import com.example.compose.modules.orderdetails.OrderDetailsScreen
import com.example.compose.modules.orderdetails.OrderDetailsViewModel
import com.example.compose.ui.navigation.model.BottomBarScreen
import com.example.compose.ui.navigation.model.Screens
import com.example.compose.ui.navigation.navGraph.bottomNavGraph

@Composable
fun SetupMainNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route,
    ) {
        navigation(
            route = Screens.MainScreen.route,
            startDestination = BottomBarScreen.Home.route
        ) {
            bottomNavGraph(navController)
        }
        composable(
            route = Screens.OrderDetailsScreen.route
        ) {
            val viewModel: OrderDetailsViewModel = viewModel()
            OrderDetailsScreen(viewModel)
        }
    }
}