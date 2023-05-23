package br.com.igorbag.githubapp.domain

import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.repository.GithubReporitory
import br.com.igorbag.githubapp.domain.usecase.GetUserRepositoryByNameUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetUserRepositoryByNameUseCaseTest {

    @Test
    fun `invoke should return user repositories by name`() = runBlocking {
        // Mock do repositório
        val repository = mockk<GithubReporitory>()

        // Dados de exemplo
        val userName = "john_doe"
        val repositories = listOf(
            Repository("repo1"),
            Repository("repo2")
        )

        // Configuração do comportamento esperado do mock
        coEvery { repository.getUserRepositorysByName(userName) } returns repositories

        // Classe a ser testada
        val useCase = GetUserRepositoryByNameUseCase(repository)

        // Chamada do método sob teste
        val result = useCase(userName)

        // Verificação do resultado
        assertEquals(repositories, result)
    }
}
