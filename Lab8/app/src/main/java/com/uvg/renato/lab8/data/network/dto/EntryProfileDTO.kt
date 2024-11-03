package com.uvg.renato.lab8.data.network.dto

import kotlinx.serialization.Serializable


//En teoría, esto nunca se usará. Pero por si acaso de deja acá :)
@Serializable
data class EntryCharacterProfileDto(
    val data: EntryCharacterDto,
    val message: String,
    val status: Int
)


@Serializable
data class EntryLocationProfileDto(
    val data: EntryLocationDto,
    val message: String,
    val status: Int
)