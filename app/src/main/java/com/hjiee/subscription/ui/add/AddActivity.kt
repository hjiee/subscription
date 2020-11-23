package com.hjiee.subscription.ui.add

import android.os.Bundle
import com.hjiee.base.BaseActivity
import com.hjiee.subscription.R
import com.hjiee.subscription.databinding.ActivityAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddActivity : BaseActivity<ActivityAddBinding>(R.layout.activity_add) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.includeToolbar.ibBack.setOnClickListener { finish() }
    }
}