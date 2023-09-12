package uz.uzbekcard.taxiapp.util.navigation

import uz.uzbekcard.taxiapp.util.Navigation
import kotlinx.coroutines.flow.SharedFlow

interface NavigationDispatcher  {
    val dispatcher : SharedFlow<(Navigation) -> Unit>
}