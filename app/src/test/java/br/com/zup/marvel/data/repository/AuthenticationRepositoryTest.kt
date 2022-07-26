//package br.com.zup.marvel.data.repository
//
//import br.com.zup.marvel.data.model.User
//import br.com.zup.marvel.ui.login.viewmodel.LoginViewModel
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//import org.junit.Assert.*
//import org.junit.Test
//import org.junit.experimental.theories.suppliers.TestedOn
//
//class AuthenticationRepositoryTest{
//
//    @Test
//    fun regiterUser_informingAllData() {
//
//        val authenticationRepository = AuthenticationRepository()
//
//        // Arrange
//        val user = User(
//            "Felipe",
//            "felipe@gmail.com.br",
//            ""
//        )
////        val auth: FirebaseAuth = Firebase.auth
////        Mokito.when(Firebase.auth).thenReturn(authTask)
//        // ACT
//        val result = authenticationRepository.registerUser(auth, user.email, user.password)
//
//        // Assert
//        assertEquals(result.result.user?.email, "felipe@gmail.com.br")
//    }
//
//
//    @Test
//    fun registerUser(){
//
//        // Arrange
//        val authenticationRepository = AuthenticationRepository()
//        val email = "email@email.com"
//        val password = "ABC1234"
//        val auth: FirebaseAuth = Firebase.auth
//
//
//
//        // ACT
//        val result = authenticationRepository.registerUser(auth, email, password)
//
//
//        // Assert
//        assertEquals(result.result.user?.email, "felipe@gmail.com.br")
//
//
//
//
//    }
//
//    @Test
//    fun validateDataUserComDadosCompletos(){
//        //Arranje
//        val user = User()
//        user.email = "asdasd"
//        user.password = "asdasd"
//        val viemModel = LoginViewModel()
//
//
//        //ACT
//       val resultado =  viemModel.validateDataUser(user)
//
//      //Assert
//        assertEquals(resultado, true)
//
//
//
//    }
//
//    @Test
//    fun validateDataUserSemEmail(){
//        //Arranje
//        val user = User()
//        user.password = "asdasd"
//        val viemModel = LoginViewModel()
//
//
//        //ACT
//        val resultado =  viemModel.validateDataUser(user)
//
//        //Assert
//        assertEquals(resultado, false)
//
//
//
//    }
//
//}