package br.com.igorbag.githubapp.data.remote.repository

import br.com.igorbag.githubapp.data.data.source.GithubDataSource
import br.com.igorbag.githubapp.data.remote.extensions.getOrThrow
import br.com.igorbag.githubapp.data.remote.service.GithubService
import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User

class GithubDataSourceRemote constructor(
    private val githubService: GithubService,
) : GithubDataSource.Remote {

    override suspend fun getAllUsers(): List<User> {
        return runCatching {
            githubService.getUsers()
        }.getOrThrow()
    }

    override suspend fun getUserByName(userName: String): User {
        return runCatching {
            githubService.getUserByName(userName)
        }.getOrThrow()
    }

    override suspend fun getUserRepositorysByName(name: String): List<Repository> {
        return runCatching {
            githubService.getRepositoriesByUserName(name)
        }.getOrThrow()
    }
}
