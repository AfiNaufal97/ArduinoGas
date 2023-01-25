package com.example.arduinoapps.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arduinoapps.activity.DetailTipsActivity
import com.example.arduinoapps.adapter.DisorderAdapter
import com.example.arduinoapps.adapter.TipsAdapter
import com.example.arduinoapps.data.DisorderData
import com.example.arduinoapps.data.TipsData
import com.example.arduinoapps.databinding.FragmentHomeBinding
import com.example.arduinoapps.model.Disorder
import com.example.arduinoapps.model.Tips


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var tipsAdapter: TipsAdapter
    private lateinit var disorderAdapter: DisorderAdapter
    private var listTips : ArrayList<Tips> = arrayListOf()
    private var listDisorder : ArrayList<Disorder> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        showTipsToRv()
        showDisorderToRv()
        hideProgressBar()
        return binding.root
    }

    fun showTipsToRv(){
        listTips.addAll(TipsData.listTips)
        tipsAdapter = TipsAdapter(listTips, object : TipsAdapter.onTipsClick{
            override fun onTipsClickListener(tips: Tips) {
                startActivity(Intent(activity, DetailTipsActivity::class.java).apply {
                    putExtra("idTips", tips.id_news)
                })
            }
        })
        binding.RvTips.apply {
            adapter = tipsAdapter
            val mLayout = LinearLayoutManager(activity)
            mLayout.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = mLayout
        }

    }

    fun showDisorderToRv(){
        listDisorder.addAll(DisorderData.listDisorder)
        disorderAdapter = DisorderAdapter(listDisorder, object : DisorderAdapter.onDisorderClick{
            override fun onDisorderClickListener(disorder: Disorder) {
                startActivity(Intent(activity, DetailTipsActivity::class.java).apply {
                    putExtra("idDisorder", disorder.id_news)
                })
            }

        })
        binding.RvDisorder.apply {
            adapter = disorderAdapter
            val mLayout = LinearLayoutManager(activity)
            mLayout.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = mLayout
        }
    }

    private fun hideProgressBar() {
        binding.loading.visibility = View.INVISIBLE
    }
}