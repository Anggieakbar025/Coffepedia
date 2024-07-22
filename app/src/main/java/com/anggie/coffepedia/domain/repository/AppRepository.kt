package com.anggie.coffepedia.domain.repository

import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.extention.SourceResult
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getCoffeList(): Flow<SourceResult<List<CoffeModel>>>
    fun getCoffeDetail(id: Int): Flow<SourceResult<List<CoffeModel>>>
}