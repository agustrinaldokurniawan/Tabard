package com.dicoding.tabard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val linkedinButton: ImageButton = findViewById(R.id.linkedin_button)
        val callButton: ImageButton = findViewById(R.id.call_button)
        val emailButton: ImageButton = findViewById(R.id.email_button)

        backButton.setOnClickListener(this)
        linkedinButton.setOnClickListener(this)
        callButton.setOnClickListener(this)
        emailButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.back_button -> {
                val listIntent = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(listIntent)
            }
            R.id.linkedin_button -> {
                val linkedinIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/agustrk/"))
                startActivity(linkedinIntent)
            }
            R.id.call_button -> {
                val phoneNumber = "089638672690"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.email_button -> {
                val email = "agustkurniawan0108@gmail.com"
                val emailIntent = Intent().apply {
                    action = Intent.ACTION_SENDTO
                    type = "plain/text"
                    data = Uri.parse("mailto:$email")
                    putExtra(Intent.EXTRA_SUBJECT, "Let's Connect")
                }

                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                }
            }
        }
    }
}