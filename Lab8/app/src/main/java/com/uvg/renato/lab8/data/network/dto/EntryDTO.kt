package com.uvg.renato.lab8.data.network.dto

import com.uvg.renato.lab8.data.model.Character
import com.uvg.renato.lab8.data.model.Location
import kotlinx.serialization.Serializable


@Serializable
data class EntryCharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species:String,
    val gender:String,
    val image: String,
)

fun EntryCharacterDto.mapToCharacterModel(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        image = image
    )
}

@Serializable
data class EntryLocationDto(
    val id: Int,
    val name: String,
    val status: String,
    val type :String,
    val dimension:String
)

fun EntryLocationDto.mapToLocationModel(): Location {
    return Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension
    )
}