package com.berkedursunoglu.retrofittutorial.data.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("street") val street: String?,
    @SerializedName("suite") val suite: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("zipcode") val zipcode: String?,
    @SerializedName("geo") val geo: Geo?,
)