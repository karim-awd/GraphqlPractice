package com.example.android.ayk_graphql_test.View

import com.example.android.ayk_graphql_test.GetAllProductsQuery

interface PresenterInterface {
    fun setProductsList(productsList: MutableList<GetAllProductsQuery.List_product>)

    fun loadData()
}