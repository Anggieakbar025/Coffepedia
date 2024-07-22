package com.anggie.coffepedia.domain.usecase

import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.domain.repository.AppRepository
import com.anggie.coffepedia.extention.SourceResult
import kotlinx.coroutines.flow.Flow

class GetCoffeListUseCase(private val appRepository: AppRepository) {
    suspend operator fun invoke(): Flow<SourceResult<List<CoffeModel>>> {
        return appRepository.getCoffeList()
    }
}