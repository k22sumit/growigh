package com.example.sumit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sumit.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.feedsbtn?.setOnClickListener{
            var intent  = Intent(this,FeedActivity::class.java)
            startActivity(intent)
        }

        binding?.uploadbtn?.setOnClickListener {
            var intent  = Intent(this,UploadActivity::class.java)
            startActivity(intent)
        }

    }
}