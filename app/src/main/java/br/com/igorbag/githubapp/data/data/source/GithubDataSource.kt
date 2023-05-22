package br.com.igorbag.githubapp.data.data.source

import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User

sealed interface GithubDataSource {
    interface Remote : GithubDataSource {
        suspend fun getAllUsers(): List<User>
        suspend fun getUserByName(userName: String): User
        suspend fun getUserRepositorysByName(name: String): List<Repository>
    }
}
