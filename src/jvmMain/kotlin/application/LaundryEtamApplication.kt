package application

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import screen.ScreenState
import screen.dashboard.DashboardScreen
import screen.login.LoginScreen
import theme.MyLaundryAdminTheme


@Composable
@Preview
fun App() {
    MyLaundryAdminTheme {
        var screenState by remember {
            mutableStateOf<ScreenState>(ScreenState.Login)
        }

        when (screenState) {
            ScreenState.Login -> {
                LoginScreen { _, _ ->
                    screenState = ScreenState.Dashboard
                }
            }
            ScreenState.Dashboard -> {
                DashboardScreen()
            }
        }
    }
}