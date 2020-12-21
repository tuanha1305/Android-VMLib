package me.shouheng.sample.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import me.shouheng.sample.R
import me.shouheng.sample.databinding.ActivitySecondBinding
import me.shouheng.uix.common.listener.onDebouncedClick
import me.shouheng.vmlib.base.CommonActivity
import me.shouheng.vmlib.comn.EmptyViewModel

class SecondActivity : CommonActivity<EmptyViewModel, ActivitySecondBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_second

    override fun doCreateView(savedInstanceState: Bundle?) {
        binding.btn.onDebouncedClick {
            val data = Intent()
            data.putExtra("__result", binding.et.text.toString())
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}