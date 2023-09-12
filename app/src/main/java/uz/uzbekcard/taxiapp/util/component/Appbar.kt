package uz.uzbekcard.taxiapp.util.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import uz.uzbekcard.taxiapp.ui.theme.color_primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarApp(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.mediumTopAppBarColors(color_primary),
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        { TextApp(text = title, fontWeight = FontWeight.Bold, color = Color.White, fontSize = 20.sp) },
        modifier,
        navigationIcon,
        actions,
        windowInsets,
        colors,
        scrollBehavior
    )
}