package screen.dashboard.state

sealed class DashboardScreenState {
    object Dashboard : DashboardScreenState()
    object Product : DashboardScreenState()
    object Order : DashboardScreenState()
}
