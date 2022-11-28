package screen.home.content.order.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import screen.home.content.order.state.OrderStatusState
import theme.Grey50

@Composable
fun OrderStatus(
    modifier: Modifier = Modifier
        .fillMaxWidth()
) {
    var orderStatus by remember {
        mutableStateOf<OrderStatusState>(OrderStatusState.NewOrder)
    }

    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(24.dp),
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, top = 12.dp, bottom = 8.dp),
        ) {
            OrderItemStatus(
                "Orderan Baru (2)",
                orderStatus is OrderStatusState.NewOrder,
                onClick = {
                    orderStatus = OrderStatusState.NewOrder
                }
            )
            Spacer(modifier = Modifier.width(18.dp))
            OrderItemStatus(
                "Menunggu Konfirmasi (1)",
                orderStatus is OrderStatusState.WaitingConfirmation,
                onClick = {
                    orderStatus = OrderStatusState.WaitingConfirmation
                }
            )
            Spacer(modifier = Modifier.width(18.dp))
            OrderItemStatus(
                "Dijemput",
                orderStatus is OrderStatusState.PickedUp,
                onClick = {
                    orderStatus = OrderStatusState.PickedUp
                }
            )
            Spacer(modifier = Modifier.width(18.dp))
            OrderItemStatus(
                "Diproses",
                orderStatus is OrderStatusState.Processing,
                onClick = {
                    orderStatus = OrderStatusState.Processing
                }
            )
            Spacer(modifier = Modifier.width(18.dp))
            OrderItemStatus(
                "Siap dikirim",
                orderStatus is OrderStatusState.Delivered,
                onClick = {
                    orderStatus = OrderStatusState.Delivered
                }
            )
            Spacer(modifier = Modifier.width(18.dp))
            OrderItemStatus(
                "Orderan selesai",
                orderStatus is OrderStatusState.Completed,
                onClick = {
                    orderStatus = OrderStatusState.Completed
                }
            )
        }
    }
}

@Composable
fun OrderItemStatus(
    title: String,
    isActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body2,
            color = if (isActive) MaterialTheme.colors.primary else Grey50,
            modifier = Modifier
                .clickable(onClick = onClick)
        )
        if (isActive) {
            Spacer(Modifier.height(4.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
                    .height(2.dp),
            )
        }
    }
}