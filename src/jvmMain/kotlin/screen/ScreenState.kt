package screen

sealed class ScreenState {
    object Login : ScreenState()
    object Dashboard : ScreenState()
}
