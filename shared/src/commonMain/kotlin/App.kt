import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.screens.Numeron
import ui.theme.NumeronTheme

@Composable
fun App() {
    NumeronTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ){
            Numeron()
        }
    }
}

expect fun getPlatformName(): String
