package com.example.composesample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//for dependency injection we are using hilt library
//here his defining hilt
@HiltAndroidApp
class AuthApplication : Application() {
}
