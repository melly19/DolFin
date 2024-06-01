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
import androidx.compose.ui.text.withStyle


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
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("1) Fee fraud: ")
                    }
                    append("Fee frauds involve the sale of products or services, the offering of investments, lottery winnings, found money and more. One example of this is advance/loan fee fraud, where fraudsters target victims to make advance or upfront payments for goods, services or financial gains that do not materialise.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("2) Recovery fraud: ")
                    }
                    append("When a scam victim has already been harmed by other frauds, other scammers may offer to recover your lost funds. This is known as a recovery fraud.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("3) Romance fraud: ")
                    }
                    append("Fraudsters create fake profiles on online dating sites or dating apps, and pretend to be fara way and need money to meet. Alternatively, they pretend they are in need of cash quickly and use the relationship as leverage.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("4) Impersonation fraud: ")
                    }
                    append("Fraudsters send unsolicited emails and text messages, impersonating the bank, a government authority or someone that you know personally, prompting you to pay.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("5) Online shopping fraud: ")
                    }
                    append("Sellers pretend to sell goods at a steep discount and deliver you the wrong item or not deliver you anything at all.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("6) Job fraud: ")
                    }
                    append("Job scammers pose as employment agencies and promise lucrative employment opportunities, only to dupe victims into giving personal information or money.")
                })
            }
        }
    )
}