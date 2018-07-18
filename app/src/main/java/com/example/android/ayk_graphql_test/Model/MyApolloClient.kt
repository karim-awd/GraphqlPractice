package com.example.android.ayk_graphql_test.Model

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


object MyApolloClient {

    private val BASE_URL = "http://ayk-test.badrit.com/graphql"
    private var mApolloClient: ApolloClient? = null

    val myApolloClient: ApolloClient?
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor).build()

            mApolloClient = ApolloClient.builder()
                    .serverUrl(BASE_URL)
                    .okHttpClient(okHttpClient)
                    .build()

            return mApolloClient
        }
}
