package screen.home.content.order.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import theme.Grey50

@Composable
fun OrderStatus(
    modifier: Modifier = Modifier
        .fillMaxWidth()
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 8.dp),
        ) {
            Text(
                text = "Orderan Baru (2)",
                style = MaterialTheme.typography.body2,
                color = Grey50,
                modifier = Modifier
                    .clickable {  }
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = "Menunggu Konfirmasi (1)",
                style = MaterialTheme.typography.body2.copy(
                    textDecoration = TextDecoration.Underline
                ),
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .clickable {  }
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = "Dijemput",
                style = MaterialTheme.typography.body2,
                color = Grey50,
                modifier = Modifier
                    .clickable {  }
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = "Diproses",
                style = MaterialTheme.typography.body2,
                color = Grey50,
                modifier = Modifier
                    .clickable {  }
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = "Siap dikirim",
                style = MaterialTheme.typography.body2,
                color = Grey50,
                modifier = Modifier
                    .clickable {  }
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = "Orderan selesai",
                style = MaterialTheme.typography.body2,
                color = Grey50,
                modifier = Modifier
                    .clickable {  }
            )
            Spacer(modifier = Modifier.width(18.dp))
        }
    }

}