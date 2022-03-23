import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.compose.ui.navigation.model.Screens
import com.example.compose.ui.navigation.navGraph.setupMainNavGraph

@Composable
fun SetupMainNavHost(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route,
    ) {
        setupMainNavGraph(navController)
    }
}