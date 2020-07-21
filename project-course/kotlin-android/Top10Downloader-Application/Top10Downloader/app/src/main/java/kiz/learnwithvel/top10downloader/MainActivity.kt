package kiz.learnwithvel.top10downloader

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kiz.learnwithvel.top10downloader.adapter.FeedAdapter
import kiz.learnwithvel.top10downloader.util.ParseApplications
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates

class FeedEntry {

    var name: String = ""
    var artist: String = ""
    var releaseDate: String = ""
    var summary: String = ""
    var imageUrl: String = ""

    override fun toString(): String {
        return "FeedEntry(name='$name'," +
                " artist='$artist'," +
                " releaseDate='$releaseDate', " +
                "imageUrl='$imageUrl')"
    }

}

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
        private const val KEY_LINK = "feed_link"
        private const val KEY_LIMIT = "feed_limit"


        private class DownloadData(context: Context, list: ListView) :
            AsyncTask<String, Void, String>() {

            //backing properties to avoid memory leak
            private var propContext: Context by Delegates.notNull()
            private var propListView: ListView by Delegates.notNull()

            init {
                propContext = context
                propListView = list
            }

            override fun doInBackground(vararg url: String?): String {
                val rssFeed = downloadXML(url[0])
                if (rssFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground: Error downloading")
                }
                return rssFeed;
            }

            override fun onPostExecute(result: String) {
                val parseApplications = ParseApplications()
                parseApplications.parse(result)

                val adapter =
                    FeedAdapter(
                        propContext,
                        R.layout.layout_list_item,
                        parseApplications.applications
                    )
                propListView.adapter = adapter
            }

            private fun downloadXML(urlPath: String?): String {
                return URL(urlPath).readText()
            }

        }
    }

    private var downloadData: DownloadData? = null
    private var feedUrl: String =
        "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=%d/xml"
    private var feedLimit: Int = 10
    private var feedCached = "CACHED_LINK"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            feedUrl = savedInstanceState.getString(KEY_LINK)!!
            feedLimit = savedInstanceState.getInt(KEY_LIMIT)
        }
        downloadUrl(feedUrl.format(feedLimit))
    }

    private fun downloadUrl(url: String) {
        if (url != feedCached) {
            Log.d(TAG, "downloadUrl: called")
            downloadData = DownloadData(this, list_item)
            downloadData?.execute(url)
            feedCached = url
        }

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
                feedCached = "CACHED_LINK"
            }
            else -> return super.onOptionsItemSelected(item)
        }
        downloadUrl(feedUrl.format(feedLimit))
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_LINK, feedUrl)
        outState.putInt(KEY_LIMIT, feedLimit)
    }

    override fun onDestroy() {
        super.onDestroy()
        downloadData?.cancel(true)
    }

}