package fi.oamk.heartratelimits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import fi.oamk.heartratelimits.ui.theme.HeartRateLimitsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeartRateLimitsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HeartRateLimits(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HeartRateLimits(modifier: Modifier = Modifier) {
    var ageInput by remember { mutableStateOf("") } // State variable for age
    val age = ageInput.toIntOrNull() ?: 0 // Age as int
    val upper = if (age > 0) (220 - age) * 0.85f else 0.0f// Upper age limit
    val lower = if ( age > 0) (220 - age) * 0.65f else 0.0f // Lower age limit
    val upperFormatted = String.format("%.2f", upper)  // Results to two decimal places
    val lowerFormatted = String.format("%.2f", lower)
    //  Put composables below each other
    Column (
        // Add padding and space
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Ask the user to enter their age
        TextField(
            value = ageInput,
            onValueChange = {ageInput = it}, // Update input when the user types something
            label = {Text(text = stringResource(R.string.age))}, // "Age" above the input field
            singleLine = true, // Keep the input field on one line
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // Number keyboard
            modifier = Modifier.fillMaxWidth() // Text field use the full available width
        )
        // Show the calculated heart rate limits
        Text(
            text = stringResource(R.string.your_heart_rate_limits_are, lowerFormatted, upperFormatted)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeartRateLimitsPreview() {
    HeartRateLimitsTheme {
        HeartRateLimits()
    }
}
