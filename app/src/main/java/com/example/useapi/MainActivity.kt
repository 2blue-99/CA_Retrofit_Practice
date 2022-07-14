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

        val mainPresenter = MainPresenter()

        CoroutineScope(Dispatchers.IO).launch {
            var arrayData = mainPresenter.getData()
            with(recyclerData) {
                for (i in arrayData.indices) {
                    add(recyclerData("${i + 1}", "${arrayData[i].name}", arrayData[i].id))
                }
                println(recyclerData)
            }
            runOnUiThread{initRecyclerView()}
        }
    }

    fun initRecyclerView(){
        val adapter= recyclerAdapter() //어댑터 객체 만듦
        adapter.datalist = recyclerData //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager= LinearLayoutManager(this) //레이아웃 매니저 연결
    }

    fun dataClick(view: View) {

        val fragment1 = SubFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment, fragment1).commit()



        println("check")
//        val fragment = SubFragment()
//        supportFragmentManager.beginTransaction().add(R.id.fragment, fragment).commit()
//        println("view.context ${view.context}")
//        println("id ${view.id}")
//        println("textAlignment ${view.textAlignment}")
//        println("textDirection ${view.textDirection}")
//        println("@@@ ${view.textView6.text}")
//        println("@@@ ${view.textView7.text}")
//        println("@@@ ${recyclerData[view.textAlignment].id}")
//        val intent = Intent(this, SubFragment::class.java)
//        intent.putExtra("data","${recyclerData[view.textAlignment].id}")
//        startActivity(intent)
//        val _Fragement = supportFragmentManager.beginTransaction()
//        _Fragement.add(SubFragment)

    }
}