package screen.login

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import component.MultiStyleText
import component.Toolbar

@Composable
@Preview
fun LoginScreen(onButtonLoginClicked: (email: String, password: String) -> Unit) {
    Scaffold(
        topBar = {
            Toolbar()
        },
        content = {
            LoginContent(
                onButtonLoginClicked,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
    )
}

@Composable
fun LoginContent(
    onButtonLoginClicked: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(128.dp))
        LeftContent(Modifier.weight(0.5f))
        Spacer(modifier = Modifier.width(48.dp))
        RightContent(
            onButtonLoginClicked,
            Modifier.weight(0.5f)
        )
        Spacer(modifier = Modifier.width(128.dp))
    }
}

@Composable
private fun LeftContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Hello, Laundrypreneur!",
            color = Color.Black,
            style = MaterialTheme.typography.body1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Ingin Jadi Pengusaha Laundry Terbaik? \nLaundry Etam Business solusinya",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Mulailah kelola Laundry anda dengan Laundry Etam Business",
            color = Color.Black,
            style = MaterialTheme.typography.body1,
        )
        Spacer(modifier = Modifier.height(48.dp))
        Image(
            painter = painterResource("laundry_store.png"),
            contentDescription = "Logo",
            modifier = Modifier
                .height(200.dp)
        )
    }
}

@Composable
private fun RightContent(
    onButtonLoginClicked: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 8.dp,
        modifier = modifier
    ) {
        CardContent(onButtonLoginClicked)
    }
}

@Composable
fun CardContent(
    onButtonLoginClicked: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(vertical = 60.dp, horizontal = 40.dp)
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        Text(
            text = "Log In ke Laundry Etam Business",
            color = Color.Black,
            style = MaterialTheme.typography.subtitle1,
            fontFamily = FontFamily.SansSerif,
        )
        Spacer(modifier = Modifier.height(54.dp))
        InputEmail(
            email = email,
            onEmailChange = { email = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        InputPassword(
            password = password,
            onPasswordChange = { password = it },
            passwordVisible = passwordVisible,
            onPasswordVisibleChange = { passwordVisible = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        RememberMeAndForgotPassword()
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                onButtonLoginClicked(email, password)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.body1,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        MultiStyleText(
            text1 = "Belum punya akun? ",
            color1 = Color.Gray,
            text2 = "Buat akun disini!",
            color2 = MaterialTheme.colors.primary,
        )
    }
}

@Composable
fun RememberMeAndForgotPassword() {
    var rememberMe by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = {
                    rememberMe = it
                },
                colors = CheckboxDefaults.colors(
                    checkmarkColor = MaterialTheme.colors.primary,
                    disabledColor = Color.DarkGray,
                    uncheckedColor = Color.Gray,
                )
            )
            Text(
                text = "Ingat Saya",
                color = Color.Black,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .clickable(true) {
                        rememberMe = !rememberMe
                    }
            )
        }

        Spacer(modifier = Modifier.width(50.dp))

        Text(
            text = "Lupa Password?",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .clickable(true) {
                    //TODO
                }
        )
    }
}

@Composable
private fun InputEmail(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = {
            Text(
                text = "Email/Telepon",
                style = MaterialTheme.typography.body1
            )
        },
        modifier = modifier
            .fillMaxWidth(),
        placeholder = {
            Text(
                "Email/Telepon",
                style = MaterialTheme.typography.body1
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = Color.Gray
        )
    )
}

@Composable
private fun InputPassword(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordVisible: Boolean,
    onPasswordVisibleChange: (Boolean) -> Unit,
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = {
            Text(
                text = "Password",
                style = MaterialTheme.typography.body1
            )
        },
        modifier = modifier
            .fillMaxWidth(),
        singleLine = true,
        placeholder = {
            Text(
                text = "Masukkan Password",
                style = MaterialTheme.typography.body1
            )
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Outlined.Lock
            else
                Icons.Filled.Lock

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {
                onPasswordVisibleChange(!passwordVisible)
            }) {
                Icon(imageVector = image, description)
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = Color.Gray
        )
    )
}