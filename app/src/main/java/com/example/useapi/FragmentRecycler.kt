package com.example.useapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.useapi.databinding.ActivityMainBinding
import com.example.useapi.databinding.FragmentDetailBinding
import com.example.useapi.databinding.FragmentRecyclerBinding
import com.example.useapi.presenter.MainContract
import com.example.useapi.presenter.MainPresenter
import com.example.useapi.recycler.recyclerAdapter
import com.example.useapi.recycler.recyclerData
import kotlinx.android.synthetic.main.fragment_recycler.view.*
import kotlinx.android.synthetic.main.item_list.view.*
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
 * Use the [FragmentRecycler.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentRecycler : Fragment() {

//    private var _binding : FragmentDetailBinding? = null
//    private val binding get() = _binding!!
    private lateinit var binding: FragmentRecyclerBinding
//    var datas = ""

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val recyclerData = mutableListOf<recyclerData>()

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

        binding = FragmentRecyclerBinding.inflate(inflater)
//        val view = inflater!!.inflate(R.layout.fragment_recycler, container, false)
//        val recyclerView: RecyclerView = view.recyclerView
//        _binding = FragmentDetailBinding.inflate(inflater,container, false)
        val mainPresenter = MainPresenter()

        CoroutineScope(Dispatchers.IO).launch {
            var arrayData = mainPresenter.getData()
//            Log.d(javaClass.simpleName, "onCreateView: $arrayData")
            with(recyclerData) {
                for (i in arrayData.indices) {
                    add(recyclerData("${i + 1}", "${arrayData[i].name}", arrayData[i].id))
                }
                withContext(Dispatchers.Main){
                    initRecyclerView()
                }
            }
        }

//        return inflater.inflate(R.layout.fragment_recycler, container, false)
//        return view
        return binding.root
    }

    fun initRecyclerView(){
        val mActivity = activity as MainActivity

        val adapter = recyclerAdapter{ id ->
            println("id : $id")
            mActivity.changeFragment(2, id)
        } //어댑터 객체 만듦
        adapter.datalist = recyclerData //데이터 넣어줌
//        binding.fragment.recyclerView.adapter = adapter
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

//    fun dataClick(view: View) {
////        binding.star.textColors
////        println("dataClick")
//
//        val myData = Bundle()
//        myData.putString("id", "${recyclerData[view.textView6.text.toString().toInt()-1].id}")
//
//        val FragmentDetaieA = FragmentDetail()
//        FragmentDetaieA.arguments = myData
//
//        val transactionDetail = supportFragmentManager.beginTransaction()
//        transactionDetail.replace(R.id.fragment, FragmentDetaieA)
//        transactionDetail.commit()
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentRecycler.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentRecycler().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}