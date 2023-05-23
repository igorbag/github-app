package br.com.igorbag.githubapp.domain

import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.repository.GithubReporitory
import br.com.igorbag.githubapp.domain.usecase.GetAllUsersUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAllUsersUseCaseTest {

    @Test
    fun `invoke should return list of users`() = runBlocking {
        // Mock do repositório
        val repository = mockk<GithubReporitory>()

        // Dados de exemplo
        val users = listOf(
            User("John", "www.google.com"),
            User("Jane", "www.google.com")
        )

        // Configuração do comportamento esperado do mock
        coEvery { repository.getAllUsers() } returns users

        // Classe a ser testada
        val useCase = GetAllUsersUseCase(repository)

        // Chamada do método sob teste
        val result = useCase()

        // Verificação do resultado
        assertEquals(users, result)
    }
}
