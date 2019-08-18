package com.mredrock.cyxbs.freshman

import android.app.Application
import cn.leancloud.AVLogger
import cn.leancloud.AVOSCloud
import cn.leancloud.service.PushService
import cn.leancloud.AVObject



class MyLeanCloudApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
        AVOSCloud.initialize(this, "6ukVBScpwbSw0EoHAirByqO9-gzGzoHsz", "wfoppUlb1HscBptbVs8UGMYU");
    }
}