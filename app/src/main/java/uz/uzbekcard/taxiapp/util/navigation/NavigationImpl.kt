package uz.uzbekcard.taxiapp.util.navigation

import uz.uzbekcard.taxiapp.util.AppScreen
import uz.uzbekcard.taxiapp.util.Navigation
import kotlinx.coroutines.flow.MutableSharedFlow

class NavigationImpl : uz.uzbekcard.taxiapp.util.navigation.Navigation, NavigationDispatcher {
    override val dispatcher = MutableSharedFlow<Navigation.() -> Unit>()

    private suspend fun navigate(navigator: Navigation.() -> Unit){
        dispatcher.emit(navigator)
    }

    override suspend fun navigateTo(screen: AppScreen) {
        navigate { push(screen) }
    }

    override suspend fun replace(screen: AppScreen) {
        navigate { replace(screen) }
    }

    override suspend fun back() = navigate {
        pop()
    }
}