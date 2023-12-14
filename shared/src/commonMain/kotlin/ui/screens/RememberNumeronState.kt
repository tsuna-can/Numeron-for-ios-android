package ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import model.Result

@Composable
fun rememberNumeronState(): NumeronState {
    var target by remember { mutableStateOf(makeRandomNumber()) }
    var first by remember { mutableStateOf("") }
    var second by remember { mutableStateOf("") }
    var third by remember { mutableStateOf("") }
    var solved by remember { mutableStateOf(false) }
    var history = remember { mutableStateListOf<Result>() } // TODO: replace by `val history by remember { mutableStateListOf<Result>() }`

    fun onValueChange(value: String, digit: Int) {
        val newValue = if(value.isEmpty()) "" else value.last().toString()
        when (digit) {
            1 -> first = newValue
            2 -> second = newValue
            3 -> third = newValue
        }
    }

    fun onSend() {
        val result = checkHitBlow("$first$second$third", target)
        history.add(result)
        if (result.hit == 3) {
            solved = true
        } else {
            first = ""
            second = ""
            third = ""
        }
    }

    fun onNext() {
        target = makeRandomNumber()
        first = ""
        second = ""
        third = ""
        solved = false
        history.clear()
    }

    return remember(
        target,
        first,
        second,
        third,
        solved,
        history,
    ) {
        NumeronState(
            target = target,
            first = first,
            second = second,
            third = third,
            history = history,
            solved = solved,
            onValueChange = ::onValueChange,
            onSend = ::onSend,
            onNext = ::onNext,
        )
    }
}

data class NumeronState(
    val target: String = "",
    val first: String = "",
    val second: String = "",
    val third: String = "",
    val history: List<Result> = listOf(),
    val solved: Boolean = false,
    val onValueChange: (String, Int) -> Unit,
    val onSend: () -> Unit,
    val onNext: () -> Unit,
)

private fun checkHitBlow(value: String, target: String): Result {
    var hit = 0
    var blow = 0
    for (i in 0..2) {
        if (value[i] == target[i]) {
            hit++
        } else if (value[i] in target) {
            blow++
        }
    }

    return Result(
        value = value,
        hit = hit,
        blow = blow,
    )
}

private fun makeRandomNumber(): String {
    val numberList = (0..9).toMutableList()
    val first = numberList.removeAt((0..<numberList.size).random()).toString()
    val second = numberList.removeAt((0..<numberList.size).random()).toString()
    val third = numberList.removeAt((0..<numberList.size).random()).toString()

    return "$first$second$third"
}
