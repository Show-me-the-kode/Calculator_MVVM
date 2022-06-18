package sehun.org.calculator_mvvm.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import sehun.org.calculator_mvvm.R
import sehun.org.calculator_mvvm.databinding.ActivityCalculatorBinding
import sehun.org.calculator_mvvm.presentation.record.RecordFragment

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private var visibility = INVISIBLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
        changeVisibility()
    }

    private fun initFragment() {
        val recordFragment = RecordFragment()

        supportFragmentManager.beginTransaction().add(R.id.fcv_calculator_torecord, recordFragment)
            .commit()
    }

    private fun changeVisibility() {
        binding.ivCalculatorTorecord.setOnClickListener {
            when (visibility) {
                INVISIBLE -> {
                    binding.fcvCalculatorTorecord.visibility = View.VISIBLE
                    visibility = VISIBLE
                }
                VISIBLE -> {
                    binding.fcvCalculatorTorecord.visibility = View.GONE
                    visibility = INVISIBLE
                }
            }
        }
    }

    companion object {
        const val INVISIBLE = 8
        const val VISIBLE = 0
    }
}
