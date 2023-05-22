package br.com.igorbag.githubapp.domain.repository

import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User

interface GithubReporitory {
    suspend fun getAllUsers(): List<User>
    suspend fun getUserByName(name: String): User
    suspend fun getUserRepositorysByName(repositoryName: String): List<Repository>
}
