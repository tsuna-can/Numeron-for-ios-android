package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.History
import ui.components.Input

@Composable
fun Numeron(
    state: NumeronState = rememberNumeronState()
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        Input(
            first = state.first,
            second = state.second,
            third = state.third,
            onFirstChange = { state.onValueChange(it, 1) },
            onSecondChange = { state.onValueChange(it, 2) },
            onThirdChange = { state.onValueChange(it, 3) },
            solved = state.solved
        )
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
    }
}
