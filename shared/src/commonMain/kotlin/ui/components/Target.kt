package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Target(target: String, isShow: Boolean = false){
    Row {
        TargetNumber(target[0].toString(), isShow)
        TargetNumber(target[1].toString(), isShow)
        TargetNumber(target[2].toString(), isShow)
    }
}

@Composable
fun TargetNumber(targetDigit :String, isShow: Boolean = false){
    Text(
        text = if(isShow) targetDigit else "?"
    )
}
