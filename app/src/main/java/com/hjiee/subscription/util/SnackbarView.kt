package com.hjiee.subscription.util

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.hjiee.subscription.R

object SnackbarView {
    fun create(itemView : View, message : String) : Snackbar {
        return Snackbar.make(itemView,message, Snackbar.LENGTH_SHORT).apply {
            view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.default_main_system_mode_color))
            val textView = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            textView.textAlignment = (View.TEXT_ALIGNMENT_CENTER)
            textView.setTextColor(ContextCompat.getColor(view.context, R.color.default_reversal_color))
        }
    }
}