package com.github.kmachida12345.coroutinesplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kmachida12345.coroutinesplayground.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}