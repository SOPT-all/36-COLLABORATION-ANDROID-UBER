package com.sopt.at.uber.data.repositoryimpl

import android.util.Log
import com.sopt.at.uber.data.datasource.LocationDataSource
import com.sopt.at.uber.data.mapper.toSearchKeywordListModel
import com.sopt.at.uber.domain.model.SearchKeywordListModel
import com.sopt.at.uber.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource
) : LocationRepository {
    override suspend fun getSearchList(): Result<SearchKeywordListModel> =
        runCatching {
            val response = locationDataSource.getSearchList()
            response.data?.toSearchKeywordListModel() ?: throw Exception("데이터가 없습니다.")
        }
    override suspend fun postLocation(departures: String, destination: String): Result<Unit> =
        runCatching {
            val response = locationDataSource.postLocation(departures, destination)
            response.data
        }

    override suspend fun deleteSearchHistoryWithId(id: Long): Result<Unit> =
        runCatching {
            val response = locationDataSource.deleteSearchHistoryWithId(id)
            response.data
        }
}