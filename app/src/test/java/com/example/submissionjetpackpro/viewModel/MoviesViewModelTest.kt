package com.example.submissionjetpackpro.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.remote.DataRepository
import com.example.submissionjetpackpro.utils.DataDummy
import com.example.submissionjetpackpro.vo.Resources
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<Resources<List<MoviesEntity>>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(dataRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resources.success(DataDummy.getMovies())
        val listMovies = MutableLiveData<Resources<List<MoviesEntity>>>()
        listMovies.value = dummyMovies

        `when`(dataRepository.movies()).thenReturn(listMovies)
        val dataMovie = viewModel.getMovies().value?.data
        verify(dataRepository).movies()
        assertNotNull(dataMovie)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}