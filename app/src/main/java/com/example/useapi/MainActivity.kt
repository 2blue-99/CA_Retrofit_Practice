package com.example.useapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.useapi.databinding.ActivityMainBinding
import com.example.useapi.presenter.MainContract
import com.example.useapi.presenter.MainPresenter
import com.example.useapi.recycler.recyclerAdapter
import com.example.useapi.recycler.recyclerData
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.fragment_recycler.view.*
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity :FragmentActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    val recyclerData = mutableListOf<recyclerData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment()

        val mainPresenter = MainPresenter()

//        CoroutineScope(Dispatchers.IO).launch {
//            var arrayData = mainPresenter.getData()
//            with(recyclerData) {
//                for (i in arrayData.indices) {
//                    add(recyclerData("${i + 1}", "${arrayData[i].name}", arrayData[i].id))
//                }
//            }
//            runOnUiThread{initRecyclerView()}
//        }
    }

    fun setFragment(){
        val transactionRecycler = supportFragmentManager.beginTransaction()
            .add(R.id.fragment, FragmentRecycler())
        transactionRecycler.commit()
    }

    fun changeFragment(index: Int, id: String = ""){
        when(index){
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment, FragmentRecycler())
                    .commit()
            }

            2 -> {
                val myData = Bundle()
                myData.putString("id", id)
                println("main id : $id")

                val FragmentDetaieA = FragmentDetail()
                FragmentDetaieA.arguments = myData

                val transactionDetail = supportFragmentManager.beginTransaction()
                transactionDetail.replace(R.id.fragment, FragmentDetaieA)
                transactionDetail.commit()
            }
        }
    }
//    fun dataClick(view: View) {
//        binding.fragment.star.textColors
//        println("dataClick")
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
//
    fun backBtn(view: View) {
    changeFragment(1)
}
//        val transactionRecycler = supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment, FragmentRecycler())
//        transactionRecycler.commit()
//
//        val mainPresenter = MainPresenter()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            var arrayData = mainPresenter.getData()
//            with(recyclerData) {
//                for (i in arrayData.indices) {
//                    add(recyclerData("${i + 1}", "${arrayData[i].name}", arrayData[i].id))
//                }
//                println(recyclerData)
//            }
//            runOnUiThread{initRecyclerView()}
//        }


}