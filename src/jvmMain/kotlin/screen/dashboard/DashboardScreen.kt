package screen.dashboard

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import component.ToolbarDashboard

@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            ToolbarDashboard()
        },
        content = {
            DashboardMainContent()
        }
    )
}

