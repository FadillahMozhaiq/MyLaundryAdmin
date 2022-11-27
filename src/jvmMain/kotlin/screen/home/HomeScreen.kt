package screen.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import component.ToolbarDashboard

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            ToolbarDashboard()
        },
        content = {
            MainHomeContent()
        }
    )
}

