package com.madhram.hramtsovtest.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madhram.hramtsovtest.R
import com.madhram.hramtsovtest.data.model.CompanyResponse

class MainAdapter(
        private val companies: ArrayList<CompanyResponse>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
            DataViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                            R.layout.item_company.parent
                    )
            )



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
    }


    class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(companies: CompanyResponse){
            itemView.companiesNameView.text = companies.name


            Glide.with(itemView.avatar.context)
                    .load(companies.img)
                    .into(itemView.avatar)
        }
    }


}