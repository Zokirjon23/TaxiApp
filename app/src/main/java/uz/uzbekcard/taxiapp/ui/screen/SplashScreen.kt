package uz.uzbekcard.taxiapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import uz.uzbekcard.taxiapp.presenter.SplashViewModel
import uz.uzbekcard.taxiapp.presenter.impl.SplashViewModelImpl
import uz.uzbekcard.taxiapp.R
import uz.uzbekcard.taxiapp.ui.intent.SplashIntent
import uz.uzbekcard.taxiapp.util.AppScreen

class SplashScreen : AppScreen {
    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = getScreenModel<SplashViewModelImpl>()
        SplashContent(viewModel::onEventDispatch)
    }

    @Composable
    fun SplashContent(intent: (SplashIntent) -> Unit) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_animation))

        val progress by animateLottieCompositionAsState(
            composition,
        )

        if (progress == 1f){
            intent(SplashIntent.OpenScreen)
        }

        Box(Modifier.fillMaxSize()) {
            LottieAnimation(
                composition = composition,
                progress = {
                    progress
                }, modifier = Modifier
                    .align(Alignment.Center)
                    .size(150.dp)
            )
        }
    }
}