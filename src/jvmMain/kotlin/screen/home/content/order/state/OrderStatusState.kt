package screen.home.content.order.state

sealed class OrderStatusState {
    object NewOrder : OrderStatusState()
    object WaitingConfirmation : OrderStatusState()
    object PickedUp : OrderStatusState()
    object Processing : OrderStatusState()
    object Delivered : OrderStatusState()
    object Completed : OrderStatusState()
}
