package theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MyLaundryAdminTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = LightColors,
        typography = Typography,
        content = content
    )
}