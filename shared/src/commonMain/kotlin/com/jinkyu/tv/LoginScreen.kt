package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jinkyu.tv.domain.user.UserInput
import com.jinkyu.tv.presentation.LoginViewModel
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.EmailHint
import com.jinkyu.tv.ui.EmailLabel
import com.jinkyu.tv.ui.HaveNotAccount
import com.jinkyu.tv.ui.LoginLabel
import com.jinkyu.tv.ui.LoginMessage1
import com.jinkyu.tv.ui.LoginMessage2
import com.jinkyu.tv.ui.PasswordHint
import com.jinkyu.tv.ui.PasswordLabel
import com.jinkyu.tv.ui.SignUpLabel
import com.jinkyu.tv.ui.SpacerWeight
import com.jinkyu.tv.ui.system.AlreadyTextButton
import com.jinkyu.tv.ui.system.AppLogoLabel
import com.jinkyu.tv.ui.system.Button
import com.jinkyu.tv.ui.system.JinKyuPasswordTextField
import com.jinkyu.tv.ui.system.JinKyuTextField
import com.jinkyu.tv.ui.system.Label
import com.jinkyu.tv.ui.system.WelcomeLabel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val loginEnable by viewModel.loginEnable.collectAsState()

    Column(
        modifier = modifier.background(Color.White).padding(horizontal = 26.dp)
    ) {
        AppLogoLabel()
        WelcomeLabel(
            firstLabel = LoginMessage1,
            secondLabel = LoginMessage2
        )
        Label(label = EmailLabel)
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = email,
            onValueChange = { viewModel.onUserInput(type = UserInput.EMAIL, input = it) },
            hint = EmailHint
        )
        Label(label = PasswordLabel)
        JinKyuPasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            text = password,
            onValueChange = { viewModel.onUserInput(type = UserInput.PASSWORD, input = it) },
            hint = PasswordHint
        )
        SpacerWeight()
        Button(
            buttonLabel = LoginLabel,
            enable = loginEnable,
            onClicked = { viewModel.onLoginClicked() }
        )
        AlreadyTextButton(
            message = HaveNotAccount,
            buttonLabel = SignUpLabel,
            onButtonClicked = { viewModel.onSignUpClicked() }
        )
        Divider(height = 38)
    }
}
