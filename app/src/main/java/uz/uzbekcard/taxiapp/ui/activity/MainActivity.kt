package uz.uzbekcard.taxiapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import uz.uzbekcard.taxiapp.ui.screen.SplashScreen
import uz.uzbekcard.taxiapp.util.navigation.NavigationDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.get
import uz.uzbekcard.taxiapp.ui.screen.ContainerScreen
import uz.uzbekcard.taxiapp.ui.screen.LoginScreen
import uz.uzbekcard.taxiapp.ui.theme.TaxiAppTheme

class MainActivity : ComponentActivity() {

    private val dispatcher : NavigationDispatcher = get()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaxiAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Navigator(ContainerScreen()) { navigation ->
                        LaunchedEffect(key1 = navigation){
                            dispatcher.dispatcher.onEach {
                                   it(navigation)
                            }.collect()
                        }
                        CurrentScreen()
//                        SlideTransition(navigation)
                    }
                }
            }
        }
    }
}
