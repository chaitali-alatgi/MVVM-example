package com.example.chaitali.mvvmexample

import android.arch.lifecycle.ViewModel
import injector.DaggerViewModelInjector
import injector.ViewModelInjector
import injector.module.NetworkModule
import ui.PostListViewModel
import ui.PostViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector1: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector1.inject(this)
            is PostViewModel -> injector1.inject(this)
        }
    }
}