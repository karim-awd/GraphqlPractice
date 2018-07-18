package com.example.android.ayk_graphql_test.View

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.ayk_graphql_test.GetAllProductsQuery
import com.example.android.ayk_graphql_test.R

//VIEW
class ProductAdapter (val productsList : List<GetAllProductsQuery.List_product>?) :
        RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val recyclerViewItem  = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false) as View
        return ItemViewHolder(recyclerViewItem)
    }


    override fun getItemCount() = productsList?.size ?: 0

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        var currentProduct = productsList?.get(position)
        holder.itemView.findViewById<TextView>(R.id.product_name_text_view).text = currentProduct?.name()
        holder.itemView.findViewById<TextView>(R.id.product_price_text_view).text = currentProduct?.price().toString()
    }
}