package com.example.navbaranalysisone.data.repository

import com.example.navbaranalysisone.data.model.endptone.EndPtOneModelItem
import com.example.navbaranalysisone.data.model.endptthree.EndPtThreeModelItem
import com.example.navbaranalysisone.data.model.endpttwo.EndPtTwoModelItem

// Interface in an attempt to implement a Repository pattern
interface Repository {

    suspend fun getApi1(): List<EndPtOneModelItem>

    suspend fun getApi2(): EndPtTwoModelItem

    suspend fun getApi3(): EndPtThreeModelItem
}