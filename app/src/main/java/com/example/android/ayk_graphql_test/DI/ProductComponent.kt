package com.example.android.ayk_graphql_test.DI

import com.example.android.ayk_graphql_test.MainActivity
import dagger.Component

@Component (modules = [HomeModule::class])
interface ProductComponent {
    fun inject (view : MainActivity)
}