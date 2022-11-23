package component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ToolbarDashboard(
    userName: String = "Fadillah Mozhaiq",
    modifier: Modifier = Modifier
        .fillMaxWidth()
) {
    Card(
        modifier = modifier,
        elevation = 8.dp,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 8.dp),
        ) {
            Image(
                painter = painterResource("logo_text.svg"),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(36.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painterResource("profile_icon.xml"),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable { }
                )
                Text(
                    "$userName       |",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.width(24.dp))
                Image(
                    painterResource("settings_icon.xml"),
                    contentDescription = "Settings",
                    modifier = Modifier
                        .clickable { }
                )
                Spacer(modifier = Modifier.width(36.dp))
                Image(
                    painterResource("notification_icon.xml"),
                    contentDescription = "Notification",
                    modifier = Modifier
                        .clickable { }
                )
                Spacer(modifier = Modifier.width(36.dp))
                Image(
                    painterResource("help_icon.xml"),
                    contentDescription = "Help",
                    modifier = Modifier
                        .clickable { }
                )
            }
        }
    }
}