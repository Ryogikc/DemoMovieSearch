package com.leagueofdevs.demomoviesearch.domain

import com.leagueofdevs.demomoviesearch.data.repositories.FavoriteMovieRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CreateFavoriteMovieUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: FavoriteMovieRepository
    lateinit var useCase: CreateFavoriteMovieUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        useCase = CreateFavoriteMovieUseCase(repository)
    }

    @Test
    fun `invoke should call createFavoriteMovie with correct parameters`() = runBlocking {
        // Arrange
        val imdbID = "tt123456"
        val title = "Example Movie"
        val genre = "Action"
        val plot = "Lorem ipsum dolor sit amet"
        val poster = "https://example.com/poster.jpg"
        // Given
        coEvery {
            repository.createFavoriteMovie(
                any(),
                any(),
                any(),
                any(),
                any()
            )
        } coAnswers { nothing }

        // when
        useCase(imdbID, title, genre, plot, poster)

        // then
        coVerify(exactly = 1) {
            repository.createFavoriteMovie(imdbID, title, genre, plot, poster)
        }
    }

}
