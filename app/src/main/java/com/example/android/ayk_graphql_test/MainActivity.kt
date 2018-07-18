package com.example.android.ayk_graphql_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.android.ayk_graphql_test.DI.DaggerProductComponent
import com.example.android.ayk_graphql_test.DI.HomeModule
import com.example.android.ayk_graphql_test.Presenter.ProductPresenter
import com.example.android.ayk_graphql_test.View.ProductAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() , ProductView {


    var mproductsList = ArrayList<GetAllProductsQuery.List_product>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    @Inject
    lateinit var mPresenter :ProductPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerProductComponent
                .builder()
                .homeModule(HomeModule(this))
                .build()
                .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecycler()

        mPresenter.loadData()
    }

    override fun setProductsList (productsList: MutableList<GetAllProductsQuery.List_product>){
        Log.i("Entered",""+ productsList[0].name)
        mproductsList.addAll(productsList)
        runOnUiThread {         viewAdapter.notifyDataSetChanged()
        }
    }

    fun setRecycler () {
        viewAdapter = ProductAdapter(mproductsList)
        viewManager = LinearLayoutManager(this@MainActivity)
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = viewAdapter
        recyclerView.layoutManager = viewManager
    }
}
