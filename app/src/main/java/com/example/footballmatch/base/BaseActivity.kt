package com.example.footballmatch.base


import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import dagger.android.support.DaggerAppCompatActivity


open class BaseActivity : DaggerAppCompatActivity() {
    fun <T : View> Activity.bindView(@IdRes res: Int): Lazy<T> {
        return lazy(LazyThreadSafetyMode.NONE) {
            findViewById<T>(res)
        }
    }
}