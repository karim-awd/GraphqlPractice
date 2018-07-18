package com.example.android.ayk_graphql_test.Presenter

import com.example.android.ayk_graphql_test.GetAllProductsQuery
import com.example.android.ayk_graphql_test.Model.DataLoader
import com.example.android.ayk_graphql_test.ProductView
import com.example.android.ayk_graphql_test.View.PresenterInterface
import javax.inject.Inject

class ProductPresenter : PresenterInterface {

 private  var view: ProductView
 private  var minteractour: DataLoader

 @Inject
 constructor(  view: ProductView, minteractour: DataLoader) {
  this.view = view
  this.minteractour = minteractour
 }

 override fun loadData() {
  minteractour.loadData(this)
 }

 override fun setProductsList(productsList: MutableList<GetAllProductsQuery.List_product>) {
  view.setProductsList(productsList)
 }
}