package br.com.zup.marvel.ui.register.viewmodel

import br.com.zup.marvel.data.model.User
import org.junit.Assert.*
import org.junit.Test

class RegisterViewModelTest {
    @Test
    fun validate_informingAllData() {
        val registerViewModel = RegisterViewModel()
        // Arrange
        val user = User(
            "Felipe",
            "felipe@gmail.com.br",
            "melhorProfessorDoMundo"
        )
        // ACT
        val result = registerViewModel.validateDataUser(user)

        // Assert
        assert(result == null)
    }
}