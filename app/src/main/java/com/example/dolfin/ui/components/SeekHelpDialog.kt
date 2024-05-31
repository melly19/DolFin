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
        title = { Text("Seeking Help as a Victim of Scams") },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("1) Confide in your loved ones")
                    }
                    append("It is common for victims of scams to feel shame and helplessness. Being scammed might lead to lower self-esteem and isolating behaviour. The loss of self-esteem that comes with internalised shame may cause victims to isolate themselves and choose not to disclose their struggles.")
                    append("Therefore, it is important that you talk about what happened to you with trusted family members and friends. While this can be a vulnerable step, having someone know about what happened and walk with you through the difficult emotions, thoughts and consequences will be helpful in the long run.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("2) Report the scam to the authorities")
                    }
                    append("Those who have information on scams can call the Police Hotline at 1800-255-0000, or submit the information online at www.police.gov.sg/iwitness or via the Police@SG mobile app.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("3) Plan things out")
                    }
                    append("Work on a plan to recover financially, emotionally, and/or relationally. Remember that it will be a long journey, but everyone has to start somewhere. Find out what you next step towards recovery is and take it, be it doing research on the process of recovering the money, making reports or attending counselling sessions to work on personal trauma.")
                })
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("4) Safeguard yourself against future scams")
                    }
                    append("Remember that if a deal appears too good ot be true, it probably is not. Scammers will tend to reach out to you first - approach instead of respond. Official and credible organisations will rarely contact you directly via your phone number or email, and at the very most will rely only on advertisements targeted at the general public. Remember to only use official and credible sources.")
                })
            }
        }
    )
}