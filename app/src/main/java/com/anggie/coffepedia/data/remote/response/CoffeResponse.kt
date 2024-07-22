package com.anggie.coffepedia.data.remote.response

import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.extention.orBlank
import com.anggie.coffepedia.extention.orZero
import com.google.gson.annotations.SerializedName

data class CoffeResponse(
    val id: Int?,
    val name: String?,
    val description:String?,
    val price: Double?,
    val region: String?,
    val weight: Int?,
    @SerializedName("flavor_profile")
    val flavorProfile: List<String>?,
    @SerializedName("grind_option")
    val grindOption: List<String>?,
    @SerializedName("roast_level")
    val roastLevel: Int?,
    @SerializedName("image_url")
    val imageUrl: String?
)

fun CoffeResponse?.toModel() : CoffeModel {
    return CoffeModel(
        id = this?.id.orZero(),
        name = this?.name.orBlank(),
        description = this?.description.orBlank(),
        price = this?.price.orZero(),
        region = this?.region.orBlank(),
        weight = this?.weight.orZero(),
        flavorProfile = this?.flavorProfile ?: listOf(),
        grindOption = this?.grindOption ?: listOf(),
        roastLevel = this?.roastLevel.orZero(),
        imageUrl = this?.imageUrl.orBlank()

    )
}