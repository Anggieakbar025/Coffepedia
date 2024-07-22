package com.anggie.coffepedia.data.repository

import com.anggie.coffepedia.data.remote.response.toModel
import com.anggie.coffepedia.data.remote.service.AppApiService
import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.domain.repository.AppRepository
import com.anggie.coffepedia.extention.SourceResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl(
    private val apiService: AppApiService
): AppRepository {
    override fun getCoffeList(): Flow<SourceResult<List<CoffeModel>>> {
        return flow {
            val response = apiService.getCoffeList()
            if (response != null && response.isSuccessful) {
                val data = response.body()!!
                emit(
                    SourceResult.Success(
                        data.map { it.toModel() },
                        "success"
                    )
                )
            }
        }
    }

    override fun getCoffeDetail(id: Int): Flow<SourceResult<List<CoffeModel>>> {
        return flow {
            val response = apiService.getCoffeDetail(id)
            if (response != null && response.isSuccessful) {
                val data = response.body()!!
                emit(
                    SourceResult.Success(
                        data.map { it.toModel() },
                        "success"
                    )
                )
            }
        }
    }
}