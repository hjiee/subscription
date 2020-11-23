package com.hjiee.subscription.ui.setting

import android.os.Bundle
import com.hjiee.base.BaseActivity
import com.hjiee.subscription.R
import com.hjiee.subscription.databinding.ActivitySettingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingActivity : BaseActivity<ActivitySettingBinding>(R.layout.activity_setting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.includeToolbar.ibBack.setOnClickListener { finish() }
    }
}