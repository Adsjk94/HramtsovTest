package com.madhram.hramtsovtest.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.madhram.hramtsovtest.R
import com.madhram.hramtsovtest.R.layout.item_companies
import com.madhram.hramtsovtest.data.model.CompanyResponse
import com.madhram.hramtsovtest.data.model.Results
import kotlinx.android.synthetic.main.item_companies.view.*

class MainAdapter(
        private val companies: ArrayList<Results>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
            DataViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_companies, parent, false
                    )
            )



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(companies[position])
    }

    override fun getItemCount(): Int =
        companies.size



    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(company: Results) {
            itemView.name.text = company.name


            Glide.with(itemView.avatar.context)
                    .load(company.img)
                    .into(itemView.avatar)
        }
    }

    fun addData(list: List<Results>){
        companies.addAll(list)
    }

}
