package com.anggie.coffepedia.presentations.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.domain.usecase.GetCoffeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCoffeDetailUseCase: GetCoffeDetailUseCase
): ViewModel() {
    private val _coffe = MutableStateFlow<CoffeModel?>(null)
    val coffe: StateFlow<CoffeModel?> = _coffe

    fun getCoffeDetail(id: Int) = viewModelScope.launch {
        getCoffeDetailUseCase(id).collect {
            it.fold(
                loading = {},
                success = { data: List<CoffeModel>, _ ->
                    if (data.isNotEmpty()) {
                        _coffe.value = data[0]
                    }
                },
                failure = { _, _ -> },
                noInternet = {}
            )
        }
    }
}