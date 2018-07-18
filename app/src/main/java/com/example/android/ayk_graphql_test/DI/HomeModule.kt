package com.example.android.ayk_graphql_test.DI

import com.example.android.ayk_graphql_test.Model.DataLoader
import com.example.android.ayk_graphql_test.Presenter.ProductPresenter
import com.example.android.ayk_graphql_test.ProductView
import dagger.Module
import dagger.Provides

@Module
class HomeModule (val view : ProductView) {

    @Provides
    fun getProductInteractour () :DataLoader = DataLoader()

    @Provides
    fun getProductPresenter (minteractour:DataLoader) : ProductPresenter = ProductPresenter(view,minteractour)
}