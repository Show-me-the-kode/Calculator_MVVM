package sehun.org.calculator_mvvm.presentation.record

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sehun.org.calculator_mvvm.data.Record
import sehun.org.calculator_mvvm.databinding.FragmentRecordBinding
import sehun.org.calculator_mvvm.presentation.MainActivity

class RecordFragment : Fragment() {
    private var _binding: FragmentRecordBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    private val recordListAdapter: RecordListAdapter by lazy {
        RecordListAdapter { onRecordClick(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecordBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        binding.rvRecordItem.adapter = recordListAdapter
        recordListAdapter.submitList(RECORD)
    }

    private fun onRecordClick(record: Record) {
        val intent = Intent(context, MainActivity::class.java).apply {
            putExtra("result", record.result)
        }

        startActivity(intent)
    }

    companion object AddItemList {
        private val RECORD = listOf(
            Record("0", "22", "3+19 = "),
            Record("1", "22", "3+19 = "),
            Record("2", "22", "3+19 = "),
            Record("3", "22", "3+19 = "),
            Record("4", "22", "3+19 = "),
            Record("5", "22", "3+19 = ")

        )
    }
}
