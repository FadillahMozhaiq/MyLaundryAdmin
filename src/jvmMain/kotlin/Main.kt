// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import application.App

fun main() = application {
    val windowState = rememberWindowState(width = 1280.dp, height = 720.dp)

    Window(
        onCloseRequest = ::exitApplication,
        title = "Laundry Business",
        state = windowState,
        resizable = true
    ) {
        App()
    }
}
