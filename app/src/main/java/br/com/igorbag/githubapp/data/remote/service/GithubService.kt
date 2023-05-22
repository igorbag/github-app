package br.com.igorbag.githubapp.data.remote.service

import br.com.igorbag.githubapp.domain.model.Repository
import br.com.igorbag.githubapp.domain.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/users/{userName}")
    suspend fun getUserByName(@Path("userName") userName: String): User

    @GET("/users/{userName}/repos")
    suspend fun getRepositoriesByUserName(@Path("userName") userName: String): List<Repository>
}
