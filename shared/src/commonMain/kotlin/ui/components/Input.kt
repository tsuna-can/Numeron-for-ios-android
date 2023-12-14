package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Input(
    first: String,
    second: String,
    third: String,
    onFirstChange: (String) -> Unit,
    onSecondChange: (String) -> Unit,
    onThirdChange: (String) -> Unit,
    solved: Boolean = false,
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Input(
            value = first,
            onValueChange = {
                onFirstChange(it)
                if (it.isNotEmpty()) focusManager.moveFocus(FocusDirection.Next) // TODO: move duplicated code to common component
            },
            solved = solved,
            modifier = Modifier.focusRequester(focusRequester),
            keyboardActions = KeyboardActions {
                focusManager.moveFocus(FocusDirection.Next)
            }
        )
        Input(
            value = second,
            onValueChange = {
                onSecondChange(it)
                if (it.isNotEmpty()) focusManager.moveFocus(FocusDirection.Next)
            },
            solved = solved,
            modifier = Modifier,
            keyboardActions = KeyboardActions {
                focusManager.moveFocus(FocusDirection.Next)
            }
        )
        Input(
            value = third,
            onValueChange = {
                onThirdChange(it)
                if (it.isNotEmpty()) focusManager.moveFocus(FocusDirection.Next)
            },
            solved = solved,
            modifier = Modifier,
            keyboardActions = KeyboardActions {
                focusManager.moveFocus(FocusDirection.Next)
            }
        )
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    solved: Boolean = false,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.height(80.dp).width(72.dp).padding(8.dp),
        readOnly = solved,
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = keyboardActions,
    )
}
