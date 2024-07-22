package com.anggie.coffepedia.domain.model

import com.google.gson.annotations.SerializedName

data class CoffeModel(
    val id: Int,
    val name: String,
    val description:String,
    val price: Double,
    val region: String,
    val weight: Int,
    @SerializedName("flavor_profile")
    val flavorProfile: List<String>,
    @SerializedName("grind_option")
    val grindOption: List<String>,
    @SerializedName("roast_level")
    val roastLevel: Int,
    @SerializedName("image_url")
    val imageUrl: String
)