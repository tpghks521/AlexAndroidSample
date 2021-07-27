package com.example.androidmvvmsample

import com.example.androidmvvmsample.data.repository.MainRepository
import com.example.androidmvvmsample.viewmodels.MainViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
internal class ExampleUnitTest {


    private lateinit var loginViewModel: MainViewModel

    // Use a fake UseCase to be injected into the viewModel
    private val dataRepository: MainRepository = mockk()


    @BeforeEach
    fun setup() {

    }

    @AfterEach
    fun tearDown() {

    }

    @Test
    fun test() {
        // Let's do an answer for the liveData
        val userName = "ahmed@ahmed.ahmed"
        val password = "ahmed"
        val loginResponse = LoginResponse("123", "Ahmed", "Mahmoud",
            "FrunkfurterAlle", "77", "12000", "Berlin",
            "Germany", "ahmed@ahmed.ahmed")

        //1- Mock calls
        coEvery { dataRepository.doLogin(LoginRequest(userName, password)) } returns flow {
            emit(Resource.Success(loginResponse))
        }

        //2-Call
        loginViewModel = LoginViewModel(dataRepository)
        loginViewModel.doLogin(userName, password)
        //active observer for livedata
        loginViewModel.loginLiveData.observeForever { }

        //3-verify
        val loginSuccess = loginViewModel.loginLiveData.value?.data
        assertEquals(loginSuccess, loginResponse)
    }
}