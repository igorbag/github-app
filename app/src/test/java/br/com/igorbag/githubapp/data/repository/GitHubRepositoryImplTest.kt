package br.com.igorbag.githubapp.data.repository

import br.com.igorbag.githubapp.data.data.repository.GitHubRepositoryImpl
import br.com.igorbag.githubapp.data.data.source.GithubDataSource
import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GitHubRepositoryImplTest {

    // Cenário 1: Teste do método getAllUsers
    @Test
    fun `getAllUsers should return list of users`() = runBlocking {
        // Mock do data source remoto
        val remoteDataSource = mockk<GithubDataSource.Remote>()

        // Dados de exemplo
        val users = listOf(User("John", "www.image.com"), User("Jane", "www.image.com"))

        // Configuração do comportamento esperado do mock
        coEvery { remoteDataSource.getAllUsers() } returns users

        // Classe a ser testada
        val repository = GitHubRepositoryImpl(remoteDataSource)

        // Chamada do método sob teste
        val result = repository.getAllUsers()

        // Verificação do resultado
        assertEquals(users, result)
    }

    // Cenário 2: Teste do método getUserByName
    @Test
    fun `getUserByName should return user by name`() = runBlocking {
        // Mock do data source remoto
        val remoteDataSource = mockk<GithubDataSource.Remote>()

        // Dados de exemplo
        val name = "John"
        val user = User(name, "www.image.com")

        // Configuração do comportamento esperado do mock
        coEvery { remoteDataSource.getUserByName(name) } returns user

        // Classe a ser testada
        val repository = GitHubRepositoryImpl(remoteDataSource)

        // Chamada do método sob teste
        val result = repository.getUserByName(name)

        // Verificação do resultado
        assertEquals(user, result)
    }

    // Cenário 3: Teste do método getUserRepositorysByName
    @Test
    fun `getUserRepositorysByName should return user repositories by name`() = runBlocking {
        // Mock do data source remoto
        val remoteDataSource = mockk<GithubDataSource.Remote>()

        // Dados de exemplo
        val repositoryName = "my_repo"
        val repositories = listOf(Repository("repo1"), Repository("repo2"))

        // Configuração do comportamento esperado do mock
        coEvery { remoteDataSource.getUserRepositorysByName(repositoryName) } returns repositories

        // Classe a ser testada
        val repository = GitHubRepositoryImpl(remoteDataSource)

        // Chamada do método sob teste
        val result = repository.getUserRepositorysByName(repositoryName)

        // Verificação do resultado
        assertEquals(repositories, result)
    }
}
