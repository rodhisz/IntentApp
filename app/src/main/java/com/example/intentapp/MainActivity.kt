package com.example.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. Move Activity
        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        //2. Move Activity With Data
        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_move_with_data)
        btnMoveWithDataActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            //1. Move Activity
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            //2. Move Activity With Data
            R.id.btn_move_with_data -> {
                val moveData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Rodhi")
                moveData.putExtra(MoveWithDataActivity.EXTRA_AGE, 23)
                startActivity(moveData)
            }
        }
    }
}