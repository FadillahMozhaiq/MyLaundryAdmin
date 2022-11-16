// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import theme.MyLaundryAdminTheme

@Composable
@Preview
fun App() {
    MyLaundryAdminTheme {
        LoginScreen()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Laundry Business",
        state = rememberWindowState(width = Dp.Unspecified, height = Dp.Unspecified),
        resizable = false
    ) {
        App()
    }
}