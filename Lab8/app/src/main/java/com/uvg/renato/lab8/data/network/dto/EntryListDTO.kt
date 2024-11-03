package com.uvg.renato.lab8.data.network.dto
import kotlinx.serialization.Serializable


@Serializable
data class EntryCharacterListDto(
    val data: List<EntryCharacterDto>,
    val message: String,
    val status: Int
)

@Serializable
data class EntryLocationListDto(
    val data: List<EntryLocationDto>,
    val message: String,
    val status: Int
)