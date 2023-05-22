package br.com.igorbag.githubapp.domain.usecase

import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.repository.GithubReporitory

class GetUserRepositoryByNameUseCase(
    private val repository: GithubReporitory,
) {
    suspend operator fun invoke(userName: String): List<Repository> {
        return repository.getUserRepositorysByName(userName)
    }
}