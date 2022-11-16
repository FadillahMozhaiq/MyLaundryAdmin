package component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Toolbar(
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
            Text(
                "Sign Up       |       About Business",
            )
        }
    }
}