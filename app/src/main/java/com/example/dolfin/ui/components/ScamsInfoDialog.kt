package com.example.dolfin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight


@Composable
fun ScamsInfoDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Close")
            }
        },
        title = { Text("Types of Frauds") },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(
                    "1) Fee frauds involve the sale of products or services, the offering of investments, lottery winnings, found money and more." +
                            "One example of this is advance/loan fee fraud, where fraudsters target victims to make advance or upfront payments for goods, services" +
                            "or financial gains that do not materialise."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Paragraph 2: Detailed steps to enhance online security...")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Paragraph 3: How to protect personal information...")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Paragraph 4: Best practices for safe online behavior...")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Paragraph 5: Additional resources and support options...")
            }
        }
    )
}