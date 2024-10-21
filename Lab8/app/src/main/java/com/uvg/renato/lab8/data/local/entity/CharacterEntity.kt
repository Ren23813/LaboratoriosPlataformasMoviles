package com.uvg.renato.lab8.data.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uvg.renato.lab8.data.model.Character

@Entity
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)

fun CharacterEntity.mapToModel(): Character {
    return Character(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        gender = this.gender,
        image = this.image
    )
}