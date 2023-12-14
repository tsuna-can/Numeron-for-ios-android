package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.Result

@Composable
fun History(resultList: List<Result>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Color(0xFFECECEC), shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        HistoryHeader()
        Divider(color = Color.Black, thickness = 1.dp)

        if (resultList.isEmpty()) {
            Text("No history")
        } else {
            LazyColumn {
                items(resultList) { item ->
                    HistoryItem(result = item)
                }
            }
        }
    }
}

@Composable
fun HistoryHeader() {
    Row() {
        Text("Value", modifier = Modifier.weight(VALUE_WEIGHT))
        Text("Hit", modifier = Modifier.weight(HIT_WEIGHT))
        Text("Blow", modifier = Modifier.weight(BLOW_WEIGHT))
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
