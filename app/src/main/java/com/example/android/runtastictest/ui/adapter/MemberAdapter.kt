package com.example.android.runtastictest.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.runtastictest.R
import com.example.android.runtastictest.model.Member
import com.squareup.picasso.Picasso

class MemberAdapter (private val context: Context)
    : RecyclerView.Adapter<MemberAdapter.ItemViewHolder>() {

    var memberList: List<Member> = emptyList()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val memberImage: ImageView = view.findViewById(R.id.iv_member_image)
        val memberName: TextView = view.findViewById(R.id.tv_member_name)
        val membersLastName: TextView = view.findViewById(R.id.tv_member_last_name)
        val averagePace:TextView=view.findViewById(R.id.tv_average_pace)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.member_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = memberList[position]
        holder.memberName.text = item.member_first_name
        holder.membersLastName.text = item.member_last_name
        val pace = item.member_active_minutes/item.member_distance_covered
        holder.averagePace.text= "$pace min/km"
        Picasso.get()
            .load("http://download.runtastic.com/meetandcode/mobile_and_web_2016/images/members/${item.member_id}")
            .fit()
            .centerCrop()
            .into(holder.memberImage)

    }

    override fun getItemCount()= memberList.size

}