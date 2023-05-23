package br.com.igorbag.githubapp.presentation.features.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.igorbag.githubapp.presentation.theme.GitHubAppTheme

@Composable
fun LoaderComponent() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = Color.Cyan)
    }
}

@Preview
@Composable
fun LoaderComponentePreview() {
    GitHubAppTheme {
        LoaderComponent()
    }
}
