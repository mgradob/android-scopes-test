package com.mgb.scopestest.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mgb.scopestest.R
import com.mgb.scopestest.ui.detail.DetailFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var btnNext: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        btnNext = view.findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DetailFragment.newInstance())
                ?.addToBackStack("detail")
                ?.commit()
        }

        GlobalScope.launch {
            while (true) {
                Log.d("GlobalScope", "Working...")
                delay(1000)
            }
        }

        lifecycleScope.launch {
            while (true) {
                Log.d("LifecycleScope", "Working...")
                delay(1000)
            }
        }
    }
}
