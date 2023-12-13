package com.example.capstoneceriakids.UI.SplashScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.capstoneceriakids.R
import com.example.capstoneceriakids.UI.Login.LoginActivity
import com.example.capstoneceriakids.UI.Main.MainActivity
import com.example.capstoneceriakids.databinding.ActivitySplashScreenBinding

@SuppressLint("SplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private val viewModel by viewModels<SplashScreenViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding : ActivitySplashScreenBinding

    private val splashTimeOut : Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.getSession().observe(this) { user ->
                if (!user.isLogin) {
                    strartActivity(Intent(this, LoginActivity::class.java))
                } else {
                    StrartActivity(Intent(this, MainActivity::class.java))
                }
                finish()
            }
        },splashTimeOut)
    }
}