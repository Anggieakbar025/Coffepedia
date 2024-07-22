package com.anggie.coffepedia.presentations.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.domain.usecase.GetCoffeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getCoffeListUseCase: GetCoffeListUseCase
): ViewModel() {
    private val _coffeList = MutableStateFlow<List<CoffeModel>>(emptyList())
    val coffeList: StateFlow<List<CoffeModel>> = _coffeList

    init {
        getCoffeList()
    }

    private fun getCoffeList() = viewModelScope.launch {
        getCoffeListUseCase().collect {
            it.fold(
                loading = {},
                success = { coffeModels: List<CoffeModel>, s: String? ->
                    _coffeList.value = coffeModels
                },
                failure = { _, _ -> },
                noInternet = {}
            )
        }
    }
}