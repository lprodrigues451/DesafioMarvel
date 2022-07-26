package br.com.zup.marvel.ui.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.marvel.KEY_USER
import br.com.zup.marvel.REGISTRO
import br.com.zup.marvel.data.model.User
import br.com.zup.marvel.databinding.ActivityRegisterBinding
import br.com.zup.marvel.ui.home.view.HomeActivity
import br.com.zup.marvel.ui.register.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayNaAppBar()
        clickButtonRegister()
        initObservers()
    }
    private fun clickButtonRegister(){
        binding.btRegister.setOnClickListener {
            val user = getDataUser()
            viewModel.validateDataUser(user)
        }
    }

    private fun getDataUser(): User {
        return User(
            name = binding.etNameRegister.text.toString(),
            email = binding.etEmailRegister.text.toString(),
            password = binding.etPasswordRegister.text.toString()
        )
    }

    private fun initObservers() {
        viewModel.registerState.observe(this) {
            goToHome(it)
        }

        viewModel.errorState.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun goToHome(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra(KEY_USER, user)
        }
        startActivity(intent)
    }

    private fun displayNaAppBar() {
        supportActionBar?.title = REGISTRO
    }
}