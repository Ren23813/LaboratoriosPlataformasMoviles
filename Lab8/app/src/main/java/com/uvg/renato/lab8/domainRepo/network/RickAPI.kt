package com.uvg.renato.lab8.domainRepo.network

import com.uvg.renato.lab8.data.network.dto.EntryCharacterListDto
import com.uvg.renato.lab8.data.network.dto.EntryLocationListDto
import com.uvg.renato.lab8.domainRepo.network.util.NetworkError
import com.uvg.renato.lab8.domainRepo.network.util.Result

interface RickAPI {
    suspend fun getAllCharacters(): Result<EntryCharacterListDto, NetworkError>
    suspend fun getAllLocations(): Result<EntryLocationListDto, NetworkError>

}