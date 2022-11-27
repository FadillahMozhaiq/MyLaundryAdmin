package screen.home.content.order

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import screen.home.content.order.component.OrderStatus

@Composable
fun OrderContent(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        OrderStatus()
    }

}