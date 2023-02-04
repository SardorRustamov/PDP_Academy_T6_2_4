package com.example.pdp_academy_t6_2_4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdp_academy_t6_2_4.databinding.ItemRvBinding
import com.example.pdp_academy_t6_2_4.model.Phone

class PhoneAdapter(
    val list: List<Phone>,
    val onClickItem : (Int) ->Unit
) : RecyclerView.Adapter<PhoneAdapter.VH>(){

    class VH(val binding: ItemRvBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.idPhoneRv.text=list[position].phoneName

        holder.binding.idPhoneRv.setOnClickListener(View.OnClickListener {
            onClickItem.invoke(position)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }


}