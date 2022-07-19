package com.example.useapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.useapi.databinding.FragmentDetailBinding
import com.example.useapi.databinding.FragmentRecyclerBinding
import com.example.useapi.presenter.MainPresenter
import com.example.useapi.recycler.recyclerData
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDetail : Fragment() {

//    private var _binding : FragmentDetailBinding? = null
//    private val binding get() = _binding!!
    private lateinit var binding: FragmentDetailBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        _binding = FragmentDetailBinding.inflate(inflater,container, false)
        binding = FragmentDetailBinding.inflate(inflater)
//        binding.textView1.text = arguments?.getString("key")
        val idData = arguments?.getString("id")

//        binding.textView1.text = "hello"

        println("frageDetail idData : $idData")
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail, container, false)

        val mainPresenter = MainPresenter()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                var arrayData = mainPresenter.getDetail(idData.toString())
                println("detail arrayData $arrayData")

                withContext(Dispatchers.Main){
                    binding.textView1.text = arrayData.name
                    binding.textView2.text = arrayData.coinId
                    binding.textView3.text = arrayData.symbol
                    binding.textView4.text = arrayData.description
                    binding.textView5.text = arrayData.rank.toString()
                }

            }catch (t:Throwable){
                Log.e(javaClass.simpleName, "onCreateView: ${t.localizedMessage}", )
            }

//            runOnUiThread(new Runnable(){}


//            println("arrayData.coinId : ${arrayData.coinId}")
//
//            println("arrayData.name : ${arrayData.name}")
//            binding.textView3.text = arrayData.symbol
//            binding.textView4.text = arrayData.description
//            binding.textView5.text = arrayData.rank.toString()
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentDetail.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentDetail().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



}