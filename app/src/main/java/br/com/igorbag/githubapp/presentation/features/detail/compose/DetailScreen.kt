package br.com.igorbag.githubapp.presentation.features.detail.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.presentation.features.common.TopAppBar
import br.com.igorbag.githubapp.presentation.theme.GitHubAppTheme
import br.com.igorbag.githubapp.presentation.theme.SPACING_2
import coil.compose.AsyncImage

@Composable
@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class
)
internal fun DetailScreen(
    user: User,
    repositories: List<Repository>?,
    onBackClick: () -> Unit = {},
) {
    Scaffold(containerColor = Color.Transparent, topBar = {
        TopAppBar(
            navigationIcon = Icons.Outlined.ArrowBack,
            onNavigationClick = onBackClick,
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent
            ),
        )
    }) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        ) {
            Column {
                AsyncImage(
                    model = user.avatarUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(width = 190.dp, height = 170.dp),
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = user.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )

                repositories?.let {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(SPACING_2),
                        text = "Users Repositories:",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color.White
                        ),
                    )
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(repositories) { repository ->
                            RepositoryItem(repository)
                        }
                    }
                }


            }
        }
    }
}

@Composable
fun RepositoryItem(repository: Repository) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF232323))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SPACING_2),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.align(Alignment.Center),
            ) {
                Text(
                    text = repository.name,
                    style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    GitHubAppTheme {
        DetailScreen(
            user = User(name = "Joao Silva", "www.google.com.br"), repositories = null
        )
    }
}
