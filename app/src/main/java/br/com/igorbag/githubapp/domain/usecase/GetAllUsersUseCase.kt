package br.com.igorbag.githubapp.domain.usecase

import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.repository.GithubReporitory

class GetAllUsersUseCase(
    private val repository: GithubReporitory,
) {
    suspend operator fun invoke(): List<User> {
        return repository.getAllUsers()
    }
}