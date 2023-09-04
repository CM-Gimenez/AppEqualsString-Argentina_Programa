package com.curso.android.app.practica.equalstext

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*
import com.curso.android.app.practica.equalstext.views.MainEqualsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainEqualsViewModelUnitTest {

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private lateinit var viewModel: MainEqualsViewModel
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel= MainEqualsViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainEqualsViewModel_equalsStrings() = runTest{
        val txt1 = "querty"
        val txt2 = "querty"
        launch {
            viewModel.compararStrings(txt1,txt2)
        }
        advanceUntilIdle()

    }
}