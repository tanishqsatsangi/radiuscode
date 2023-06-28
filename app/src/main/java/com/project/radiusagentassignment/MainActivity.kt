package com.project.radiusagentassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.radiusagentassignment.databinding.ActivityMainBinding
import com.project.radiusagentassignment.views.ListFragment
import com.project.radiusagentassignment.workmangers.WorkerHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadListFragment()
        WorkerHelper().startSyncWorker()
    }

    private fun loadListFragment() {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .add(binding.baseFragmentContainer.id, ListFragment.newInstance(), "ListFragment")
            .commitAllowingStateLoss()
    }
}