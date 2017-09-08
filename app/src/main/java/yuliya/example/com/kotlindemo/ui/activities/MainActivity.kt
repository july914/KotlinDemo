package yuliya.example.com.kotlindemo.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

import yuliya.example.com.kotlindemo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSearchButtonClick(view: View) {
        val userEditText = findViewById(R.id.editTextUserId) as EditText
        val depthEditText = findViewById(R.id.editTextDepth) as EditText

        val intent = Intent(this@MainActivity, MyListActivity::class.java)
        intent.putExtra("User ID", userEditText.text.toString())
        intent.putExtra("Depth", depthEditText.text.toString())
        startActivity(intent)
    }
}
