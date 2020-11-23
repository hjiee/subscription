package com.hjiee.subscription.ui.detail

import android.os.Bundle
import com.hjiee.base.BaseActivity
import com.hjiee.subscription.R
import com.hjiee.subscription.SubscriptionModel
import com.hjiee.subscription.databinding.ActivityAddBinding
import com.hjiee.subscription.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private val data by lazy { intent?.extras?.get(resources.getString(R.string.key_detail)) as? SubscriptionModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.includeToolbar.ibBack.setOnClickListener { finish() }
        binding.includeToolbar.title = data?.title
    }
}