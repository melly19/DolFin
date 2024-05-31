package com.example.dolfin.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dolfin.ui.components.ScamsInfoDialog
import com.example.dolfin.ui.components.PreventiveMeasuresDialog
import com.example.dolfin.ui.components.SeekHelpDialog

@Composable
fun HomeScreen() {
    var showScamsDialog by remember { mutableStateOf(false) }
    var showMeasuresDialog by remember { mutableStateOf(false) }
    var showHelpDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showScamsDialog = true }) {
            Text("Learn About Scams")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { showMeasuresDialog = true }) {
            Text("Preventive Measures")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { showHelpDialog = true }) {
            Text("Seek Help")
        }
    }

    if (showScamsDialog) {
        ScamsInfoDialog(onDismiss = { showScamsDialog = false })
    }

    if (showMeasuresDialog) {
        PreventiveMeasuresDialog(onDismiss = { showMeasuresDialog = false })
    }

    if (showHelpDialog) {
        SeekHelpDialog(onDismiss = { showHelpDialog = false })
    }
}