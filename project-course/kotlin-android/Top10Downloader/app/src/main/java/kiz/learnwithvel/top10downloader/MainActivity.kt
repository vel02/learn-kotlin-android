package kiz.learnwithvel.top10downloader

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kiz.learnwithvel.top10downloader.adapter.FeedAdapter
import kiz.learnwithvel.top10downloader.viewmodel.EMPTY_FEED_LIST
import kiz.learnwithvel.top10downloader.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.activity_main.*

class FeedEntry {
    var name: String = ""
    var artist: String = ""
    var releaseDate: String = ""
    var summary: String = ""
    var imageUrl: String = ""
}

private const val TAG = "MainActivity"
private const val KEY_LINK = "feed_link"
private const val KEY_LIMIT = "feed_limit"


class MainActivity : AppCompatActivity() {


    private var feedUrl: String =
        "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=%d/xml"
    private var feedLimit: Int = 10
    private val feedViewModel: FeedViewModel by lazy { ViewModelProvider(this).get(FeedViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val feedAdapter = FeedAdapter(this, R.layout.layout_list_item, EMPTY_FEED_LIST)
        list_item.adapter = feedAdapter


        if (savedInstanceState != null) {
            feedUrl = savedInstanceState.getString(KEY_LINK)!!
            feedLimit = savedInstanceState.getInt(KEY_LIMIT)
        }
        feedViewModel.feedEntries.observe(this, Observer<List<FeedEntry>> {
            feedAdapter.setFeedList(it ?: EMPTY_FEED_LIST)
        })
        feedViewModel.downloadUrl(feedUrl.format(feedLimit))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_feed, menu)
        if (feedLimit == 10) {
            menu?.findItem(R.id.action_top10)?.isChecked = true
        } else menu?.findItem(R.id.action_top25)?.isChecked = true
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_free ->
                feedUrl =
                    "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=%d/xml"
            R.id.action_paid ->
                feedUrl =
                    "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/toppaidapplications/limit=%d/xml"
            R.id.action_songs ->
                feedUrl =
                    "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=%d/xml"
            R.id.action_top10, R.id.action_top25 -> {
                if (!item.isChecked) {
                    item.isChecked = true
                    feedLimit = 35 - feedLimit
                }
            }
            R.id.action_refresh -> {
                feedViewModel.invalidate()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        feedViewModel.downloadUrl(feedUrl.format(feedLimit))
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_LINK, feedUrl)
        outState.putInt(KEY_LIMIT, feedLimit)
    }

}