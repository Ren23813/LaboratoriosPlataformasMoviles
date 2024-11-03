package com.uvg.renato.lab8.data.network

import com.uvg.renato.lab8.data.network.dto.EntryCharacterDto
import com.uvg.renato.lab8.data.network.dto.EntryCharacterListDto
import com.uvg.renato.lab8.data.network.dto.EntryCharacterProfileDto
import com.uvg.renato.lab8.data.network.dto.EntryLocationListDto
import com.uvg.renato.lab8.data.network.util.safeCall
import com.uvg.renato.lab8.domainRepo.network.RickAPI
import com.uvg.renato.lab8.domainRepo.network.util.NetworkError
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import com.uvg.renato.lab8.domainRepo.network.util.Result

class KtorRickAPI(
    private val httpClient: HttpClient
): RickAPI {
    override suspend fun getAllCharacters(): Result<EntryCharacterListDto, NetworkError> {
        return safeCall<EntryCharacterListDto> {
            httpClient.get(
                "https://rickandmortyapi.com/api/character"
            )
        }
    }


    override suspend fun getAllLocations(): Result<EntryLocationListDto, NetworkError> {
        return safeCall<EntryLocationListDto> {
            httpClient.get(
                "https://rickandmortyapi.com/api/location"
            )
        }
    }
}