package com.mredrock.cyxbs.freshman.ui.activity

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.annotation.RequiresApi
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.litepal.Share
import kotlinx.android.synthetic.main.app_activity_edit.*
import java.time.LocalDate
import java.time.LocalDateTime
import javax.crypto.Cipher

class EditActivity : AppCompatActivity() {

    private var content=""
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_edit)
        val preference = getSharedPreferences("itemimage", Context.MODE_PRIVATE)
        val image = preference.getString("path", "")
        val bitmap=BitmapFactory.decodeFile(image)
        app_imageview.setImageBitmap(bitmap)
        iv_edit_back.setOnClickListener {
            finish()
        }

        app_edit_edit.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()!=""){
                    tv_edit.visibility=View.VISIBLE
                    content=p0.toString()
                }else{
                    tv_edit.visibility=View.INVISIBLE
                    content=p0.toString()
                }
            }

        })

        tv_edit.setOnClickListener {
            val share= Share()
            share.content=content
            share.path=image
            share.save()
            finish()
        }
    }
}
