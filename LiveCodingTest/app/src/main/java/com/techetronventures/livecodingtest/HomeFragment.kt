package com.techetronventures.livecodingtest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techetronventures.livecodingtest.databinding.FragmentHomeBinding
import kotlin.random.Random

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var handler: Handler
    var runnable: Runnable? = null
    var delay = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        handler = Handler(Looper.getMainLooper())
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        binding.topcardMoney.text = getString(R.string.money, "0")
        binding.incardMoney.text = getString(R.string.money, "0")
        binding.incardMoney2.text = getString(R.string.money, "0")
        return binding.root
    }

    override fun onResume() {
        handler.postDelayed(Runnable {
            handler.postDelayed(runnable!!, delay.toLong())
            updateUi()
        }.also { runnable = it }, delay.toLong())
        super.onResume()
    }

    fun updateUi() {
        binding.topcardMoney.text = getString(R.string.money, "${generateRandomInts()}")
        binding.incardMoney.text = getString(R.string.money, "${generateRandomInts()}")
        binding.incardMoney2.text = getString(R.string.money, "${generateRandomInts()}")
        binding.incardPercentage.text = "${generateRandomDoubles()}"
        binding.incardPercentage2.text = "${generateRandomDoubles()}"
    }

    fun generateRandomDoubles(): Double {
        return Random.nextDouble(-10.00, 10.00)
    }

    fun generateRandomInts(): Int {
        return Random.nextInt(1, 100)
    }

    override fun onPause() {
        runnable?.let { handler.removeCallbacks(it) }
        super.onPause()
    }

}