package com.hjiee.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hjiee.base.BaseRecyclerView
import com.hjiee.util.RecyclerItemDecoration

@BindingAdapter(value = ["bindItems"])
fun RecyclerView.bindItems(items : List<Any>?) {
    items?.let {
        (adapter as? BaseRecyclerView.Adapter<Any,*>)?.run {
//            replaceAll(items)
            updateItems(items)
        }
    }
}

@BindingAdapter(value = ["bindDecoration"])
fun RecyclerView.bindDecoration(offset : Int) {
    addItemDecoration(RecyclerItemDecoration(offset))
}