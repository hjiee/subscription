package com.hjiee.subscription.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.library.baseAdapters.BR
import com.hjiee.base.BaseActivity
import com.hjiee.base.BaseItemsApdater
import com.hjiee.ext.moveToActivity
import com.hjiee.subscription.R
import com.hjiee.subscription.data.local.db.SubscriptionEntity
import com.hjiee.subscription.databinding.ActivityHomeBinding
import com.hjiee.subscription.ui.add.AddActivity
import com.hjiee.subscription.ui.detail.DetailActivity
import com.hjiee.subscription.ui.setting.SettingActivity
import com.hjiee.util.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val viewModel by viewModels<HomeViewModel>()
    private var backKeyPressedTime = 0L
    private val toast by lazy { Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT) }

    private val itemClickListener by lazy {
        object : ItemClickListener {
            override fun <T> onItemClick(item: T) {
                Intent(this@HomeActivity, DetailActivity::class.java).let {
                    it.putExtra(resources.getString(R.string.key_detail),item as? SubscriptionEntity)
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
        initViewModelObserving()
    }

    override fun onResume() {
        super.onResume()
        viewModel.read()
    }

    override fun onBackPressed() {
        if (!supportFragmentManager.popBackStackImmediate()) {
            if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis()
                toast.show()
                return
            }
        }

        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            super.onBackPressed()
            toast.cancel()
        }

    }

    private fun initViewModelObserving() {
        viewModel.run {
            items.observe(this@HomeActivity) {
                adapter.updateItems(it)
            }
            total.observe(this@HomeActivity) {
                binding.sumValue = it
            }
        }
    }

    private fun addSubscriptionItem() {
        moveToActivity(Intent(this@HomeActivity, AddActivity::class.java))
    }
}