package br.com.igorbag.githubapp.domain

import br.com.igorbag.githubapp.domain.model.User
import br.com.igorbag.githubapp.domain.repository.GithubReporitory
import br.com.igorbag.githubapp.domain.usecase.GetUserByNameUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetUserByNameUseCaseTest {

    @Test
    fun `invoke should return user by name`() = runBlocking {
        // Mock do repositório
        val repository = mockk<GithubReporitory>()

        // Dados de exemplo
        val user = User("Joao", "www.google")

        // Configuração do comportamento esperado do mock
        coEvery { repository.getUserByName("Joao") } returns user

        // Classe a ser testada
        val useCase = GetUserByNameUseCase(repository)

        // Chamada do método sob teste
        val result = useCase("Joao")

        // Verificação do resultado
        assertEquals(user, result)
    }
}
