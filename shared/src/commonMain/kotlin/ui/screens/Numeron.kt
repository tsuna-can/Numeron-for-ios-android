package ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import ui.components.History
import ui.components.Input
import ui.components.Target

@Composable
fun Numeron(
    state: NumeronState = rememberNumeronState()
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        Target(state.target, state.solved)
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Input(
                value = state.first,
                onValueChange = {state.onValueChange(it, 1) },
                enabled = !state.solved,
                modifier = Modifier.weight(0.3f).focusRequester(focusRequester),
                keyboardActions = KeyboardActions{
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
            Input(
                value = state.second,
                onValueChange = { state.onValueChange(it, 2) },
                enabled = !state.solved,
                modifier = Modifier.weight(0.3f),
                keyboardActions = KeyboardActions{
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
            Input(
                value = state.third,
                onValueChange = { state.onValueChange(it, 3) },
                enabled = !state.solved,
                modifier = Modifier.weight(0.3f),
                keyboardActions = KeyboardActions{
                    focusManager.moveFocus(FocusDirection.Next)
                }
            )
        }
        History(state.history)
        Button(
            onClick = state.onSend,
            enabled = !state.solved && state.first.isNotEmpty() && state.second.isNotEmpty() && state.third.isNotEmpty()
        ) {
            Text("Send")
        }
        Button(
            onClick = state.onNext
        ) {
            Text("Next")
        }

        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }
}
