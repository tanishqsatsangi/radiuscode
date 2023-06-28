package com.project.radiusagentassignment.workmangers

import androidx.work.*
import java.util.concurrent.TimeUnit

class WorkerHelper {

    fun startSyncWorker() {
        val tag = "SyncWorker"
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workManager = WorkManager.getInstance();
        val workRequest = PeriodicWorkRequest.Builder(SyncWorker::class.java, 24, TimeUnit.HOURS)
            .addTag(tag)
            .setConstraints(constraint)
            .build()
        workManager.enqueueUniquePeriodicWork(tag, ExistingPeriodicWorkPolicy.KEEP, workRequest)
    }
}