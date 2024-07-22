package com.anggie.coffepedia.domain.usecase

import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.domain.repository.AppRepository
import com.anggie.coffepedia.extention.SourceResult
import kotlinx.coroutines.flow.Flow

class GetCoffeDetailUseCase(private val appRepository: AppRepository) {
    operator fun invoke(id: Int): Flow<SourceResult<List<CoffeModel>>> {
        return appRepository.getCoffeDetail(id)
    }
}