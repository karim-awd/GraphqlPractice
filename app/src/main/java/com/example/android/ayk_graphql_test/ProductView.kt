package com.example.android.ayk_graphql_test

interface ProductView{
    fun setProductsList (list: MutableList<GetAllProductsQuery.List_product>)
}