package com.example.dolfin.ui.screens
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dolfin.model.Article
import com.example.dolfin.model.NewsResponse

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsplashScreen(newsResponse: NewsResponse) {
    Scaffold {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            // Main heading
            Text(
                text = "News Splash",
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Scrollable content
            ScrollableContent(newsResponse)
        }
    }
}

@Composable
fun ScrollableContent(newsResponse: NewsResponse) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Display first two articles
        newsResponse.articles.take(5).forEach { article ->
            NewsArticleButton(article)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun NewsArticleButton(article: Article) {
    val showDialog = remember { mutableStateOf(false) }

    Button(
        onClick = { showDialog.value = true },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = article.title,
            //style = MaterialTheme.typography.button
        )
    }

    if (showDialog.value) {
        NewsArticleCard(article = article) {
            showDialog.value = false
        }
    }
}

@Composable
fun NewsArticleCard(article: Article, onCloseClicked: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium,
        //elevation = CardDefaults.elevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Article title
            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Article description
            Text(
                text = article.description,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

//            // Article content
//            Text(
//                text = article.content,
//                style = MaterialTheme.typography.bodySmall
//            )

            // Article published date
//            Text(
//                text = article.publishedAt,
//                style = MaterialTheme.typography.bodySmall,
//                modifier = Modifier.padding(bottom = 8.dp)
//            )

            // Article url as a clickable hyperlink
            ClickableHyperlink(url = article.url, context = LocalContext.current)

            // Close button
            Button(
                onClick = onCloseClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Close")
            }
        }
    }
}

@Composable
fun ClickableHyperlink(url: String, context: Context) {
    val annotatedString = buildAnnotatedString {
        append(url)
        addStyle(
            style = SpanStyle(textDecoration = TextDecoration.Underline),
            start = 0,
            end = url.length
        )
        addStringAnnotation(
            tag = "URL",
            annotation = url,
            start = 0,
            end = url.length
        )
    }

    Text(
        text = annotatedString,
        style = MaterialTheme.typography.bodySmall,
        fontSize = 14.sp,
        modifier = Modifier.clickable {
            // Open URL when clicked
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
    )
}
