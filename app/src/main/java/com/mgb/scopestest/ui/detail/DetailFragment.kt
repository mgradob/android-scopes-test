package com.mgb.scopestest.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mgb.scopestest.R
import kotlinx.coroutines.delay

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    lateinit var tvValue: TextView

    init {
        lifecycleScope.launchWhenCreated {
            while (true) {
                Log.d("LifecycleScope", "launchWhenCreated | Working...")
                delay(1000)
            }
        }

        lifecycleScope.launchWhenStarted {
            while (true) {
                Log.d("LifecycleScope", "launchWhenStarted | Working...")
                delay(1000)
            }
        }

        lifecycleScope.launchWhenResumed {
            while (true) {
                Log.d("LifecycleScope", "launchWhenResumed | Working...")
                delay(1000)
            }
        }
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.detail_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvValue = view.findViewById(R.id.value)

        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        viewModel.liveData.observe(viewLifecycleOwner, {
            tvValue.text = it
        })
    }
}
