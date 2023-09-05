package com.example.intentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "Extra Person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION") intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val text =
                "Halo nama saya ${person.name.toString()} \nEmail : ${person.email.toString()} \nUmur : ${person.age.toString()} \nDan saya tinggal di ${person.city.toString()} "
            tvObject.text = text
        }
    }
}