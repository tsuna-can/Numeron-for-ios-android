package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.Result

@Composable
fun History(resultList: List<Result>) {
    HistoryHeader()
    LazyColumn {
        items(resultList) {
            HistoryItem(result = it)
        }
    }
}

@Composable
fun HistoryHeader() {
    Row() {
        Text("value", modifier = Modifier.weight(VALUE_WEIGHT))
        Text("hit", modifier = Modifier.weight(HIT_WEIGHT))
        Text("blow", modifier = Modifier.weight(BLOW_WEIGHT))
    }
}

@Composable
fun HistoryItem(result: Result) {
    Row() {
        Text(result.value, modifier = Modifier.weight(VALUE_WEIGHT))
        Text(result.hit.toString(), modifier = Modifier.weight(HIT_WEIGHT))
        Text(result.blow.toString(), modifier = Modifier.weight(BLOW_WEIGHT))
    }
}

private const val VALUE_WEIGHT = 2f
private const val HIT_WEIGHT = 1f
private const val BLOW_WEIGHT = 1f
