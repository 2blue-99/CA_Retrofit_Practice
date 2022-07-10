package com.example.useapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.useapi.presenter.MainContract
import com.example.useapi.presenter.MainPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainPresenter = MainPresenter()

        val pureum = CoroutineScope(Dispatchers.IO).launch {
            println(mainPresenter.getData())
        }

    }
}

//RetrofitBuilder.api.getCoinInfo().enqueue(object : Callback<List<CoinInfo>> {
//    override fun onResponse(call: Call<List<CoinInfo>>, response: Response<List<CoinInfo>>) {
//        val userInfo = response.body()
//        Log.d("response", "${userInfo?.get(0)?.userId} @@@")
//    }
//    override fun onFailure(call: Call<List<CoinInfo>>, t: Throwable) {
//        Log.d("error", t.message.toString())
//    }
//})