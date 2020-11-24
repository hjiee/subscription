package com.hjiee.subscription.ui.add

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.library.baseAdapters.BR
import com.hjiee.base.BaseActivity
import com.hjiee.base.BaseItemsApdater
import com.hjiee.ext.showKeyboard
import com.hjiee.subscription.R
import com.hjiee.subscription.data.local.db.SubscriptionEntity
import com.hjiee.subscription.databinding.ActivityAddBinding
import com.hjiee.subscription.util.SnackbarView
import com.hjiee.util.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddActivity : BaseActivity<ActivityAddBinding>(R.layout.activity_add) {

    private val viewModel by viewModels<AddViewModel>()
    private val snackbar by lazy { SnackbarView.create(binding.root,resources.getString(R.string.str_save)) }

    private val itemClickListener by lazy {
        object : ItemClickListener {
            override fun <T> onItemClick(item: T) { viewModel.subscribe(item as SubscriptionEntity) }
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
            ibBack.setOnClickListener { finish() }
            ibSearch.setOnClickListener {
                edtSearch.requestFocus()
                showKeyboard(edtSearch)
            }
            adapter = this@AddActivity.adapter
        }
        initViewModelObserving()
        viewModel.load()
    }

    private fun initViewModelObserving() {
        viewModel.apply {
            items.observe(this@AddActivity) { adapter.updateItems(it) }
            isSubscribed.observe(this@AddActivity) {
                if(!snackbar.isShown) {
                    snackbar.show()
                }
            }
        }
    }
}