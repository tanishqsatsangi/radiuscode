package com.project.radiusagentassignment.retrofit.fetchers

class FetcherFactory<T> {

    fun getFetcher(): Fetcher<T> {
        return DataListFetcher() as Fetcher<T>
    }
}