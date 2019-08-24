package com.mredrock.cyxbs.freshman.viewModel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.provider.MediaStore
import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.litepal.Share
import com.mredrock.cyxbs.freshman.ui.activity.EditActivity
import com.mredrock.cyxbs.freshman.ui.fragment.CommulityFragment
import com.mredrock.cyxbs.freshman.ui.fragment.SelfFragment
import com.mredrock.cyxbs.freshman.utils.CommulityRecyclerAdapter
import kotlinx.android.synthetic.main.app_commulity_fragment.*
import kotlinx.android.synthetic.main.app_self_fragment.*
import org.litepal.crud.DataSupport
import java.time.LocalDateTime

class CommulityViewModel : BaseViewModel() {
    private val IMAGE_REQUEST_CODE = 2
    private var paths: String = ""

    fun add(fragment: CommulityFragment){
        fragment.floatbutton_commulity.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            fragment.startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }
    }

    fun fromphotoalbum(fragment: CommulityFragment, requestCode: Int, resultCode: Int, data: Intent) {
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
                val editor = fragment.activity!!.getSharedPreferences("itemimage", Context.MODE_PRIVATE)
                    .edit()
                editor.putString("path", paths)
                editor.apply()
                val intent=Intent(fragment.context,EditActivity::class.java)
                fragment.startActivity(intent)

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    fun initView(fragment: CommulityFragment){
        val paths=ArrayList<String>()
        val contents=ArrayList<String>()
        val dates=ArrayList<LocalDateTime>()
        val shares=DataSupport.findAll(Share::class.java)
        for (i in 0 until shares.size){
            paths.add(shares[i].path)
            contents.add(shares[i].content)
            dates.add(shares[i].date)
        }

        val adapter = CommulityRecyclerAdapter(fragment.context!!,paths,dates,contents)
        val layoutManager=LinearLayoutManager(fragment.activity)
        fragment.commulity_recycler.adapter=adapter
        fragment.commulity_recycler.layoutManager=layoutManager
    }


}
