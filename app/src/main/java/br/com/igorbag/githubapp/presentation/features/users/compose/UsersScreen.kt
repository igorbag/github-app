package br.com.igorbag.githubapp.presentation.features.users.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.presentation.theme.SPACING_1
import br.com.igorbag.githubapp.presentation.theme.SPACING_2
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreen(
    users: List<User>, onDetailClick: (String) -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "GitHubApp",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = SPACING_2)
            ) {
                items(users) { user ->
                    UserItem(user, onDetailClick)
                }
            }
        }
    )
}

@Composable
private fun UserItem(
    user: User, onDetailClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF232323))
            .clickable(onClick = { onDetailClick(user.name) })
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SPACING_2),
        ) {
            Card(
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.CenterStart),
                shape = MaterialTheme.shapes.large,
            ) {
                AsyncImage(
                    contentDescription = null,
                    modifier = Modifier.padding(SPACING_1),
                    model = user.avatarUrl
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.Companion.align(Alignment.Center),
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                )
            }
        }
    }
}

@Preview
@Composable
fun UsersScreenPreview() {
    UsersScreen(emptyList())
}
