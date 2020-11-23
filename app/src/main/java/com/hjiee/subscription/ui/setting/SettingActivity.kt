package com.hjiee.subscription.ui.setting

import android.os.Bundle
import com.hjiee.base.BaseActivity
import com.hjiee.subscription.R
import com.hjiee.subscription.databinding.ActivitySettingBinding

class SettingActivity : BaseActivity<ActivitySettingBinding>(R.layout.activity_setting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.includeToolbar.ibBack.setOnClickListener { finish() }
    }
}