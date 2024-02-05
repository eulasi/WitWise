package com.example.navbaranalysisone.data.remote

import com.example.navbaranalysisone.data.model.endptone.EndPtOneModelItem
import com.example.navbaranalysisone.data.model.endptthree.EndPtThreeModelItem
import com.example.navbaranalysisone.data.model.endpttwo.EndPtTwoModelItem
import retrofit2.http.GET

interface ApiService {

    @GET(ApiDetails.END_POINT_API1)
    suspend fun getApi1(): List<EndPtOneModelItem>

    @GET(ApiDetails.END_POINT_API2)
    suspend fun getApi2(): EndPtTwoModelItem  // Change to return a single item

    @GET(ApiDetails.END_POINT_API3)
    suspend fun getApi3(): EndPtThreeModelItem

}