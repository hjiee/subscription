package com.hjiee.subscription.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.library.baseAdapters.BR
import com.hjiee.base.BaseActivity
import com.hjiee.base.BaseItemsApdater
import com.hjiee.ext.moveToActivity
import com.hjiee.ext.showToast
import com.hjiee.subscription.R
import com.hjiee.subscription.SubscriptionModel
import com.hjiee.subscription.databinding.ActivityHomeBinding
import com.hjiee.subscription.ui.add.AddActivity
import com.hjiee.subscription.ui.detail.DetailActivity
import com.hjiee.subscription.ui.setting.SettingActivity
import com.hjiee.util.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val viewModel by viewModels<HomeViewModel>()

    private val itemClickListener by lazy {
        object : ItemClickListener {
            override fun <T> onItemClick(item: T) {
                Intent(this@HomeActivity, DetailActivity::class.java).let {
                    it.putExtra(resources.getString(R.string.key_detail),item as? SubscriptionModel)
                    moveToActivity(it)
                }
            }
        }
    }
    private val adapter by lazy {
        BaseItemsApdater(
            layoutId = R.layout.item_card_subscription,
            bindingVariableId = BR.subscription,
            clickItemEvent = itemClickListener
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            adapter = this@HomeActivity.adapter
            ibSetting.setOnClickListener { moveToActivity(Intent(this@HomeActivity, SettingActivity::class.java)) }
            ibAdd.setOnClickListener { addSubscriptionItem() }
            fbSubscription.setOnClickListener { addSubscriptionItem() }
            tvTotalPricePerMonth.setOnClickListener { addSubscriptionItem() }
        }
        viewModel.load()

        val list = ArrayList<SubscriptionModel>()

        for(i in 1..5) {
            list.add(SubscriptionModel("$i",10000f))
        }
        var sum = 0f
        list.map {
            sum += it.price
        }
        binding.sumValue = sum
        adapter.updateItems(list)

    }

    private fun addSubscriptionItem() {
        moveToActivity(Intent(this@HomeActivity, AddActivity::class.java))
    }
}