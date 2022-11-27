package screen.home.state

sealed class HomeScreenState {
    object Home : HomeScreenState()
    object Product : HomeScreenState()
    object Order : HomeScreenState()
}
