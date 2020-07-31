package kiz.learnwithvel.top10downloader.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kiz.learnwithvel.top10downloader.FeedEntry
import kiz.learnwithvel.top10downloader.util.DownloadData
import java.util.*

private const val TAG = "FeedViewModel"
val EMPTY_FEED_LIST: List<FeedEntry> = Collections.emptyList()

class FeedViewModel : ViewModel(), DownloadData.DownloaderCallBack {

    private var downloadData: DownloadData? = null
    private var feedCached = "CACHED_LINK"

    private val feed = MutableLiveData<List<FeedEntry>>()
    val feedEntries: LiveData<List<FeedEntry>>
        get() = feed

    init {
        feed.postValue(EMPTY_FEED_LIST)
    }

    fun downloadUrl(url: String) {
        if (url != feedCached) {
            Log.d(TAG, "downloadUrl: called")
            downloadData = DownloadData(this)
            downloadData?.execute(url)
            feedCached = url
        }

    }

    fun invalidate() {
        feedCached = "INVALIDATE"
    }

    override fun onDataAvailable(data: List<FeedEntry>) {
        Log.d(TAG, "onDataAvailable: called")
        feed.value = data
        Log.d(TAG, "onDataAvailable: end")
    }

    override fun onCleared() {
        super.onCleared()
        downloadData?.cancel(true)
    }
}