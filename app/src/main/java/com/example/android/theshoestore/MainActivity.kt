package com.example.android.theshoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.theshoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
    }
}