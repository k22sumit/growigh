package com.example.sumit

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sumit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var progress: Int = 0
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        binding?.skipbtn?.setOnClickListener{
            startHomeActivity()
        }

        binding.forward.setOnClickListener {

            progress++

            binding.progressBar.progress = progress

            when (progress) {
                1 -> showMissionViews()
                2 -> showVisionViews()
                else -> startHomeActivity()
            }
        }

        val editor = sharedPreferences.edit()
        editor.putBoolean("isFirstTime", false)
        editor.apply()

    }



    private fun showMissionViews() {
        binding.abImage.visibility = View.INVISIBLE
        binding.abText.visibility = View.INVISIBLE
        binding.rvImage.visibility = View.INVISIBLE
        binding.rvText.visibility = View.INVISIBLE


        binding.rmImage.visibility = View.VISIBLE
        binding.rmText.visibility = View.VISIBLE

        Toast.makeText(this, "You are in mission page", Toast.LENGTH_SHORT).show()
    }

    private fun showVisionViews() {
        binding.abImage.visibility = View.INVISIBLE
        binding.abText.visibility = View.INVISIBLE
        binding.rvImage.visibility = View.VISIBLE
        binding.rvText.visibility = View.VISIBLE

        binding.rmImage.visibility = View.INVISIBLE
        binding.rmText.visibility = View.INVISIBLE

        Toast.makeText(this, "You are in vision page", Toast.LENGTH_SHORT).show()
    }

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}

