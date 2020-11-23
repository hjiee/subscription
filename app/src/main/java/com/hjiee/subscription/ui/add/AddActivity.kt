package com.hjiee.subscription.ui.add

import android.os.Bundle
import com.hjiee.base.BaseActivity
import com.hjiee.subscription.R
import com.hjiee.subscription.databinding.ActivityAddBinding

class AddActivity : BaseActivity<ActivityAddBinding>(R.layout.activity_add) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.includeToolbar.ibBack.setOnClickListener { finish() }
    }
}