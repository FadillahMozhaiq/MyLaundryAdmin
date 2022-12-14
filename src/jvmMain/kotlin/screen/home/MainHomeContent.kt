package screen.home

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
import screen.home.content.dashboard.DashboardContent
import screen.home.content.order.OrderContent
import screen.home.content.product.ProductContent
import screen.home.state.HomeScreenState
import theme.Black50
import theme.Blue20
import theme.Grey50


@Composable
fun MainHomeContent() {
    var homeScreenState by remember {
        mutableStateOf<HomeScreenState>(HomeScreenState.Home)
    }
    Row {
        HomeSideBar(
            homeScreenState,
            onItemClicked = { newState ->
                homeScreenState = newState
            },
        )

        when (homeScreenState) {
            HomeScreenState.Home -> DashboardContent(Modifier.padding(24.dp))
            HomeScreenState.Product -> ProductContent(Modifier.padding(24.dp))
            HomeScreenState.Order -> OrderContent(Modifier.padding(24.dp))
        }
    }
}

@Composable
fun HomeSideBar(
    itemActive: HomeScreenState,
    onItemClicked: (HomeScreenState) -> Unit,
    modifier: Modifier = Modifier
        .width(375.dp)
//        .fillMaxWidth(0.25f)
        .fillMaxHeight()
) {
    Column(
        modifier = modifier
            .background(Color.White)
    ) {
        Spacer(Modifier.height(36.dp))
        HomeProfile()
        HomeMenu(
            itemActive,
            onItemClicked
        )
    }
}

@Composable
fun HomeMenu(
    itemActive: HomeScreenState,
    onItemClicked: (HomeScreenState) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 80.dp),
    ) {
        Spacer(Modifier.height(48.dp))
        Text(
            text = "Home",
            style = MaterialTheme.typography.body2,
            color = if (itemActive == HomeScreenState.Home) Blue20 else Black50,
            modifier = Modifier
                .clickable {
                    onItemClicked(HomeScreenState.Home)
                }
        )
        Spacer(Modifier.height(18.dp))
        Text(
            text = "Produk",
            style = MaterialTheme.typography.body2,
            color = if (itemActive == HomeScreenState.Product) Blue20 else Black50,
            modifier = Modifier
                .clickable {
                    onItemClicked(HomeScreenState.Product)
                }
        )
        Spacer(Modifier.height(18.dp))
        Text(
            text = "Orderan",
            style = MaterialTheme.typography.body2,
            color = if (itemActive == HomeScreenState.Order) Blue20 else Black50,
            modifier = Modifier
                .clickable {
                    onItemClicked(HomeScreenState.Order)
                }
        )
    }
}

@Composable
fun HomeProfile(
    storeName: String = "Laundry Jaya Raya",
    storeDescription: String = "Jagonya Cuci!  Jasa Lundry untuk \nberbagai jenis pakaian, selimut, \nboneka, sepatu. 3 Jam selesai!! ",
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp),
        backgroundColor = MaterialTheme.colors.secondary,
    ) {
        Row(
            Modifier
                .height(IntrinsicSize.Min)
        ) {
            Box(
                modifier = Modifier
                    .width(30.dp)
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.primaryVariant)
            )
            Spacer(Modifier.width(8.dp))
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
}