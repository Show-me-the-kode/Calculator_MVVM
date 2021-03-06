package sehun.org.calculator_mvvm.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import sehun.org.calculator_mvvm.R
import sehun.org.calculator_mvvm.databinding.ActivityCalculatorBinding
import sehun.org.calculator_mvvm.presentation.record.RecordFragment

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
    }

    private fun initFragment() {
        val recordFragment = RecordFragment()

        supportFragmentManager.beginTransaction().add(R.id.fcv_main_torecord, recordFragment)
            .commit()
        Log.d("ㅇㅇㅇ", "ㅇㅇㅇㅇ")
    }
}
