package com.example.dolfin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun PreventiveMeasuresDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Close")
            }
        },
        title = { Text("Preventive Measures") },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("If you discover that something is a fraud...")
                    }
                    append("Do not engage with the fraudsters and block them.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("If you have already fallen victim to a scam...")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    append("1) Don't pay any more money, and be on the lookout for recovery frauds.")
                    Spacer(modifier = Modifier.height(8.dp))
                    append("2) Collect all pertinent information and documents, including but not limited to: names, titles or positions used by the fraudsters, social media profiles, website addresses, emails.")
                    Spacer(modifier = Modifier.height(8.dp))
                    append("3) Protect your identity and accounts. If the scam has used credit card information, contact card issuers to make a fraud report.")
                    Spacer(modifier = Modifier.height(8.dp))
                    append("4) Report the fraud to the authorities.")
                    Spacer(modifier = Modifier.height(8.dp))
                    append("5) Check insurance coverage and other financial recovery steps.")
                    Spacer(modifier = Modifier.height(8.dp))
                    append("6) Consider building your resistance to fraud with DolFin's helpful information :)")
                })
            }
        }
    )
}