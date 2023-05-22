package br.com.igorbag.githubapp.domain.usecase

import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.repository.GithubReporitory

class GetUserByNameUseCase(
    private val repository: GithubReporitory,
) {
    suspend operator fun invoke(name: String): User {
        return repository.getUserByName(name)
    }
}