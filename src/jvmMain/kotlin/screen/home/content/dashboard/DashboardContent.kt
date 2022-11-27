package screen.home.content.dashboard

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.Grey50
import java.util.*

@Composable
fun DashboardContent(
    modifier: Modifier = Modifier,
) {
    val stateVertical = rememberScrollState(0)

    Box {
        Column(
            modifier = modifier
                .verticalScroll(stateVertical)
        ) {
            Text(
                "Tinjauan Bisnis",
                style = MaterialTheme.typography.body2,
                fontSize = 36.sp,
                color = Color.Black
            )
            Text(
                "Ringkasan aktivitas penting yang mempermudah kamu dalam memantau bisnismu",
                style = MaterialTheme.typography.body2,
                color = Grey50
            )
            BusinessReviewCard()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Analisis Produk",
                style = MaterialTheme.typography.body2,
                fontSize = 36.sp,
                color = Color.Black
            )
            Text(
                "Update terakhir  : ${Date()} WITA",
                style = MaterialTheme.typography.body2,
                color = Grey50
            )
            ProductAnalysisCard()
        }

        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(stateVertical)
        )
    }
}

@Composable
fun BusinessReviewCard() {
    Spacer(modifier = Modifier.height(24.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        DashboardCardContent(
            title = "Jumlah produk",
            value = "10",
            modifier = Modifier
                .weight(1f)
                .padding(end = 24.dp),
        )
        DashboardCardContent(
            title = "Orderan baru",
            value = "5",
            modifier = Modifier
                .weight(1f)
                .padding(end = 24.dp),
        )
        DashboardCardContent(
            title = "Akan dijemput",
            value = "3",
            modifier = Modifier
                .weight(1f)
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        DashboardCardContent(
            title = "Sedang diproses",
            value = "9",
            modifier = Modifier
                .weight(1f)
                .padding(end = 24.dp),
        )
        DashboardCardContent(
            title = "Siap dikirim",
            value = "4",
            modifier = Modifier
                .weight(1f)
                .padding(end = 24.dp),
        )
        DashboardCardContent(
            title = "Orderan selesai",
            value = "1",
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun ProductAnalysisCard() {
    Spacer(modifier = Modifier.height(24.dp))
    Card(
        shape = RoundedCornerShape(28.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 36.dp, vertical = 16.dp)
        ) {
            Text(
                "Statistik Toko",
                style = MaterialTheme.typography.body2,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                DashboardCardContent(
                    title = "Profit toko",
                    value = "Rp.21.000",
                    textValueColor = MaterialTheme.colors.primary,
                    descriptionText = "++100% dari 30 hari terakhir",
                    cardBackgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 24.dp),
                )
                DashboardCardContent(
                    title = "Pelanggan",
                    value = "5",
                    textValueColor = MaterialTheme.colors.primary,
                    descriptionText = "++100% dari 30 hari terakhir",
                    cardBackgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 24.dp),
                )
                DashboardCardContent(
                    title = "Pengunjung",
                    value = "3",
                    textValueColor = MaterialTheme.colors.primary,
                    descriptionText = "++100% dari 30 hari terakhir",
                    cardBackgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
private fun DashboardCardContent(
    title: String,
    value: String,
    textValueColor: Color = Color.Black,
    descriptionText: String = "",
    cardBackgroundColor: Color = Color.White,
    modifier: Modifier = Modifier
        .padding(18.dp),
) {
    Card(
        shape = RoundedCornerShape(28.dp),
        backgroundColor = cardBackgroundColor,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(18.dp)
        ) {
            Row {
                Text(
                    title,
                    style = MaterialTheme.typography.body2,
                    color = Grey50
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource("information_icon.xml"),
                    contentDescription = "Information",
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                value,
                style = MaterialTheme.typography.h6,
                color = textValueColor
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                descriptionText,
                style = MaterialTheme.typography.body2,
                color = Grey50,
                fontSize = 16.sp
            )
        }
    }
}