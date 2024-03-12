package com.example.lifecycledemo

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycledemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var lifecycleViewModel: LifecycleViewModel
    private lateinit var demoOwner: DemoOwner
    private lateinit var binding: ActivityMainBinding
    private val lifecycleEvents = LifecycleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleViewModel = ViewModelProvider(this)[LifecycleViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        demoOwner = DemoOwner(this.lifecycle)
        demoOwner.startOwner()
        demoOwner.stopOwner()
        demoOwner.createOwner()
        demoOwner.resumeOwner()
        demoOwner.pauseOwner()
        demoOwner.destroyOwner()


        binding.textL.text = LifecycleViewModel.addLifecycleEvent(lifecycleEvents).toString()

        setContentView(binding.root)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super<AppCompatActivity>.onConfigurationChanged(newConfig)
        lifecycleViewModel.addLifecycleEvent("ON_CONFIGURATION_CHANGED")
        binding.textL.text = lifecycleViewModel.addLifecycleEvent("").toString()
    }
}



