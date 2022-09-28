package com.example.android2

import android.app.Application
import com.example.android2.data.locale.PreferenceHelper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initPreference()
    }

    private fun initPreference(){
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)

    }
}