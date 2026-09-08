package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComponentScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ComponentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "ProgressBar",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        ProgressBarSection()

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Slider",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        SliderSection()
    }
}

// ── ProgressBar ──────────────────────────────────────────────────────────────

@Composable
fun ProgressBarSection() {
    var progress by remember { mutableFloatStateOf(0.5f) }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Indeterminado")
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Determinado — arrastra el slider para controlar")
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("0%")
            Slider(
                value = progress,
                onValueChange = { progress = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )
            Text("${(progress * 100).toInt()}%")
        }
    }
}

// ── Slider ───────────────────────────────────────────────────────────────────

@Composable
fun SliderSection() {
    var sliderValue by remember { mutableFloatStateOf(50f) }
    var stepValue by remember { mutableFloatStateOf(2f) }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Básico")
        Text(
            text = "Valor: ${sliderValue.toInt()}",
            style = MaterialTheme.typography.bodyMedium
        )
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Con pasos (discretos)")
        Text(
            text = "Paso seleccionado: ${stepValue.toInt()}",
            style = MaterialTheme.typography.bodyMedium
        )
        Slider(
            value = stepValue,
            onValueChange = { stepValue = it },
            valueRange = 0f..10f,
            steps = 9,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Deshabilitado")
        Slider(
            value = 40f,
            onValueChange = {},
            valueRange = 0f..100f,
            enabled = false,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// ── Preview ──────────────────────────────────────────────────────────────────

@Preview(showBackground = true)
@Composable
fun ComponentScreenPreview() {
    Lab4Theme {
        ComponentScreen()
    }
}
