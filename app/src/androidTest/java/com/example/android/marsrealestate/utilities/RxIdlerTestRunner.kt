package com.example.android.marsrealestate.utilities

import androidx.test.runner.AndroidJUnitRunner
import com.squareup.rx2.idler.Rx2Idler
import io.reactivex.plugins.RxJavaPlugins

class RxIdlerTestRunner : AndroidJUnitRunner() {
    override fun onStart() {
        RxJavaPlugins.setInitComputationSchedulerHandler(Rx2Idler.create("Comp Scheduler Handler"))
        RxJavaPlugins.setInitIoSchedulerHandler(Rx2Idler.create("IO Handler"))
        RxJavaPlugins.setInitNewThreadSchedulerHandler(Rx2Idler.create("New Thread Handler"))
        RxJavaPlugins.setInitSingleSchedulerHandler(Rx2Idler.create("Single Handler"))
        super.onStart()
    }
}