//package com.example.useapi
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView
//import com.example.useapi.data.CoinInfo
//import kotlinx.android.synthetic.main.item_list.view.*
//
//class ExRecyclerAdapter(private val items: ArrayList<CoinInfo>) :
//    RecyclerView.Adapter<ExRecyclerAdapter.ViewHolder>() {
//
//    //RecyclerView 초기화때 호출된다.
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)	//아이템 뷰 xml설정
//        return ExRecyclerAdapter.ViewHolder(inflatedView)
//    }
//
//    //생성된 View에 보여줄 데이터를 설정
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        //클릭 리스너 설정
//        val listener = View.OnClickListener {it ->
//            Toast.makeText(it.context, items[position].userId.toString(), Toast.LENGTH_SHORT).show()
//        }
//        //
//        holder.bind(listener, items[position])
//
//    }
//
//    //보여줄 아이템 개수가 몇개인지 알려줍니다
//    override fun getItemCount(): Int = items.size
//
//
//    //ViewHolder 단위 객체로 View의 데이터를 설정합니다
//    class ViewHolder(private var v: View) : RecyclerView.ViewHolder(v){
//        fun bind(listener: View.OnClickListener, item: CoinInfo){
//            v.setOnClickListener(listener)
//            v.textView6.text = item.userId.toString()
//        }
//    }
//}