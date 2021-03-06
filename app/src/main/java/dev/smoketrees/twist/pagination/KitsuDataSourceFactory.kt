package dev.smoketrees.twist.pagination

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import dev.smoketrees.twist.api.anime.AnimeWebClient
import dev.smoketrees.twist.model.twist.AnimeItem

class KitsuDataSourceFactory(
    private val webClient: AnimeWebClient,
    private val sort: String
) : DataSource.Factory<Int, AnimeItem>() {
    val animeLiveDataSource = MutableLiveData<PagedAnimeDatasource>()

    override fun create(): DataSource<Int, AnimeItem> {
        val animeDataSource = PagedAnimeDatasource(webClient, sort)
        animeLiveDataSource.postValue(animeDataSource)
        return animeDataSource
    }
}