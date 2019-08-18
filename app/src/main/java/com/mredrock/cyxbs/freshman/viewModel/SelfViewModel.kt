package com.mredrock.cyxbs.freshman.viewModel

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.MediaStore
import android.util.Log
import cn.leancloud.AVObject
import cn.leancloud.AVQuery
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.LoginActivity
import com.mredrock.cyxbs.freshman.ui.activity.SettingActivity
import com.mredrock.cyxbs.freshman.ui.fragment.SelfFragment
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.app_self_fragment.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SelfViewModel : BaseViewModel() {
    private val IMAGE_REQUEST_CODE = 2
    private var paths: String = ""

    @SuppressLint("ResourceType")
    fun toSettings(fragment: SelfFragment) {
        fragment.rl_self_details.setOnClickListener {
            val intent = Intent(fragment.context, SettingActivity::class.java)
            fragment.startActivity(intent)
        }
    }


    fun quitLogin(fragment: SelfFragment) {
        fragment.rl_self_delete.setOnClickListener {
            val intent = Intent(fragment.context, LoginActivity::class.java)
            fragment.startActivity(intent)
        }
    }


    fun changeImage(fragment: SelfFragment) {
        fragment.iv_self_change_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            fragment.startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }
    }

    fun fromphotoalbum(fragment: SelfFragment, requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            try {
                val selectedImage = data.getData()
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val cursor =
                    fragment.activity!!.getContentResolver().query(selectedImage, filePathColumn, null, null, null)
                cursor.moveToFirst()
                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                paths = cursor.getString(columnIndex)
                cursor.close()
                val bitmap = BitmapFactory.decodeFile(paths)
                fragment.activity!!.iv_self_change_image.setImageBitmap(bitmap)
                val editor = fragment.activity!!.getSharedPreferences("selfimage", Context.MODE_PRIVATE)
                    .edit()
                editor.putString("path", paths)
                editor.apply()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}
