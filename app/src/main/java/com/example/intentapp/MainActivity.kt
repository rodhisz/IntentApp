package com.example.intentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // 5
    lateinit var tvResult : TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null){
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Yang dipilih adalah ${selectedValue}"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Explicit Intent
        //1. Move Activity
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        //2. Move Activity With Data
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_with_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        //3. Move Activity With Object
        val btnMoveActivityWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveActivityWithObject.setOnClickListener(this)

        //Implicit Intent
        //4. Implicit Intent
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        //5. Move Activity With Result
        val btnMoveForresult : Button = findViewById(R.id.btn_move_for_result)
        btnMoveForresult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
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

            //3. Move Activity With Object
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "DicodingAcademy", 5, "academy@dicoding.com", "Bandung"
                )

                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            //4. Implicit Intent
            R.id.btn_dial_number -> {
                //Telpon
                val number = "089516122000"
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(dialIntent)

                //Share
//                val share = Intent(Intent.ACTION_SEND)
//                share.type = "text/plain"
//                share.putExtra(Intent.EXTRA_TEXT, "Belajar bareng disini www.idn.id")
//                startActivity(Intent.createChooser(share, "Share Link"))

                //Web
//                val web = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.idn.id"))
//                startActivity(web)

                //Maps
//                val maps = Intent(Intent.ACTION_VIEW, Uri.parse("geo:-7.053948,110.4318891,z=15"))
//                startActivity(maps)

                //SMS
//                val sms = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:085740482440"))
//                sms.putExtra("sms_body", "Assalamualaikum")
//                startActivity(sms)
            }

            //5. Move Activity With Result
            R.id.btn_move_for_result -> {
                val moveForResult = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResult)
            }

        }
    }
}