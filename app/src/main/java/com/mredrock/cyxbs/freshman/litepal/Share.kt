package com.mredrock.cyxbs.freshman.litepal

import android.os.Build
import androidx.annotation.RequiresApi
import org.litepal.crud.DataSupport
import java.time.LocalDate
import java.time.LocalDateTime

class Share :DataSupport(){
    var path = ""
    var content = ""
    @RequiresApi(Build.VERSION_CODES.O)
    var date:LocalDateTime= LocalDateTime.now()
}