package com.example.android.ayk_graphql_test.Model

import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.android.ayk_graphql_test.GetAllProductsQuery
import com.example.android.ayk_graphql_test.View.PresenterInterface
import com.example.android.ayk_graphql_test.type.ProductSearchInput

class DataLoader {

    fun loadData (productPresenter: PresenterInterface) {
        MyApolloClient.myApolloClient?.
                query(
                GetAllProductsQuery
                        .builder()
                        .search(ProductSearchInput.builder().has_discount(true)
                                .build())
                        .build())?.
                enqueue(object : ApolloCall.Callback<GetAllProductsQuery.Data>() {
            override fun onResponse(response: Response<GetAllProductsQuery.Data>){
                productPresenter.setProductsList(response.data()!!.list_products())
            }
            override fun onFailure(e: ApolloException) {
                Log.i("DataLoader class","MyApolloClient Failed To Load Data")
            }
        })
    }
}