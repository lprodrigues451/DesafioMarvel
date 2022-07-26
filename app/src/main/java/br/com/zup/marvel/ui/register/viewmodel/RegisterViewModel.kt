package br.com.zup.marvel.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.marvel.*
import br.com.zup.marvel.data.model.User
import br.com.zup.marvel.data.repository.AuthenticationRepository

class RegisterViewModel: ViewModel() {

    private val authenticationRepository = AuthenticationRepository()

    private var _registerState = MutableLiveData<User>()
    val registerState: LiveData<User> = _registerState

    private var _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> = _errorState

    fun validateDataUser(user: User) {
        when {
            user.name.isEmpty() -> {
                _errorState.value = NAME_ERROR
            }
            user.name.length < 3 -> {
                _errorState.value = NAME_FULL
            }
            user.email.isEmpty() -> {
                _errorState.value = EMAIL_ERROR
            }
            user.password.isEmpty() -> {
                _errorState.value = PASSWORD_ERROR
            }
            user.password.length < 8 -> {
                _errorState.value = PASSWORD_EIGHT
            }
            else -> {
                registerUser(user)
            }
        }
    }

    private fun registerUser(user: User) {
        try {
            authenticationRepository.registerUser(
                user.email,
                user.password
            ).addOnSuccessListener {

                authenticationRepository.updateUserProfile(user.name)?.addOnSuccessListener {
                    _registerState.value = user
                }

            }.addOnFailureListener {
                _errorState.value = UNABLE_TO_REGISTRE
            }
        } catch (ex: Exception) {
            _errorState.value = ex.message
        }
    }
}