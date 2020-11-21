package com.hjiee.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.hjiee.util.LogUtil.LogW

abstract class BaseDialogFragment<B : ViewDataBinding>(private val layoutId : Int) : DialogFragment() {

    lateinit var binding : B
    abstract fun initBind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        lifeCylceLog("onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        binding.lifecycleOwner = this
        lifeCylceLog("onCreateView")
        initBind()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifeCylceLog("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeCylceLog("onDestroy")
    }


    override fun onStart() {
        super.onStart()
        lifeCylceLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        lifeCylceLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        lifeCylceLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        lifeCylceLog("onStop")
    }

    private fun lifeCylceLog(name : String) {
        LogW("DialogFragment : ${binding.lifecycleOwner} / $name")
    }

}