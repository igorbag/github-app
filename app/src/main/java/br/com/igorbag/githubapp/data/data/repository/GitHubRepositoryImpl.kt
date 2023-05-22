package br.com.igorbag.githubapp.data.data.repository

import br.com.igorbag.githubapp.data.data.source.GithubDataSource
import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.repository.GithubReporitory

class GitHubRepositoryImpl constructor(
    private val remoteDataSource: GithubDataSource.Remote
) : GithubReporitory {

    override suspend fun getAllUsers(): List<User> {
        return remoteDataSource.getAllUsers()
    }

    override suspend fun getUserByName(name: String): User {
        return remoteDataSource.getUserByName(name)
    }

    override suspend fun getUserRepositorysByName(repositoryName: String): List<Repository> {
        return remoteDataSource.getUserRepositorysByName(repositoryName)

    }
}
