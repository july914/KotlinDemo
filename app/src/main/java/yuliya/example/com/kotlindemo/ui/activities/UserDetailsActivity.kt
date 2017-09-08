package yuliya.example.com.kotlindemo.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

import yuliya.example.com.kotlindemo.R

class UserDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val catname = intent.getStringExtra("Cat Name")
        val catnumber = intent.getStringExtra("Cat Number")
        val catphoto = intent.getStringExtra("Cat Photo")

        val catnameTextView = findViewById(R.id.CatNametextView) as TextView
        catnameTextView.text = catname

        val catnumberTextView = findViewById(R.id.CatNumbertextView) as TextView
        catnumberTextView.text = catnumber

        val catImageView = findViewById(R.id.imageView) as ImageView
        Picasso.with(this).load(catphoto).fit().into(catImageView)
    }
}
