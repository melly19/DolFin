package com.example.dolfin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.verticalScroll

@Composable
fun SeekHelpDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Close")
            }
        },
        title = { Text("How to Seek Help") },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(buildAnnotatedString {
                    append("Paragraph 1: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Steps to take if you are scammed")
                    }
                    append("...")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    append("Paragraph 2: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("How to report a scam")
                    }
                    append("...")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    append("Paragraph 3: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Available resources for scam victims")
                    }
                    append("...")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    append("Paragraph 4: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Legal advice and support options")
                    }
                    append("...")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    append("Paragraph 5: ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Preventive measures to avoid future scams")
                    }
                    append("...")
                })
            }
        }
    )
}