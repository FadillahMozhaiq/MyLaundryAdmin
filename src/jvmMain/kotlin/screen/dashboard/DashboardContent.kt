package screen.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import screen.dashboard.state.DashboardScreenState
import theme.Black50
import theme.Blue20
import theme.Grey50


@Composable
fun DashboardContent() {
    var dashboardScreenState by remember {
        mutableStateOf<DashboardScreenState>(DashboardScreenState.Dashboard)
    }
    Row {
        DashboardSideBar(
            dashboardScreenState,
            onItemClicked = { newState ->
                dashboardScreenState = newState
            },
        )
    }
}

@Composable
fun DashboardSideBar(
    itemActive: DashboardScreenState,
    onItemClicked: (DashboardScreenState) -> Unit,
    modifier: Modifier = Modifier
        .width(375.dp)
        .fillMaxHeight()
) {
    Column(
        modifier = modifier
            .background(Color.White)
    ) {
        Spacer(Modifier.height(36.dp))
        DashboardProfile()
        DashboardMenu(
            itemActive,
            onItemClicked
        )
    }
}

@Composable
fun DashboardMenu(
    itemActive: DashboardScreenState,
    onItemClicked: (DashboardScreenState) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 80.dp),
    ) {
        Spacer(Modifier.height(48.dp))
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.body2,
            color = if (itemActive == DashboardScreenState.Dashboard) Blue20 else Black50,
            modifier = Modifier
                .clickable {
                    onItemClicked(DashboardScreenState.Dashboard)
                }
        )
        Spacer(Modifier.height(18.dp))
        Text(
            text = "Produk",
            style = MaterialTheme.typography.body2,
            color = if (itemActive == DashboardScreenState.Product) Blue20 else Black50,
            modifier = Modifier
                .clickable {
                    onItemClicked(DashboardScreenState.Product)
                }
        )
        Spacer(Modifier.height(18.dp))
        Text(
            text = "Orderan",
            style = MaterialTheme.typography.body2,
            color = if (itemActive == DashboardScreenState.Order) Blue20 else Black50,
            modifier = Modifier
                .clickable {
                    onItemClicked(DashboardScreenState.Order)
                }
        )
    }
}

@Composable
fun DashboardProfile(
    storeName: String = "Laundry Jaya Raya",
    storeDescription: String = "Jagonya Cuci!  Jasa Lundry untuk \nberbagai jenis pakaian, selimut, \nboneka, sepatu. 3 Jam selesai!! ",
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp),
        backgroundColor = MaterialTheme.colors.secondary,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource("profile_icon.xml"),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                storeName,
                style = MaterialTheme.typography.subtitle1,
                color = Color.Black
            )
            Spacer(Modifier.height(8.dp))
            Text(
                storeDescription,
                style = MaterialTheme.typography.body2,
                color = Grey50
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text("Edit Profile")
            }
        }
    }
}