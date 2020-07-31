package kiz.learnwithvel.top10downloader

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

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

private const val TAG = "MainActivity"
private const val KEY_LINK = "feed_link"
private const val KEY_LIMIT = "feed_limit"


class MainActivity : AppCompatActivity() {


    private var feedUrl: String =
        "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=%d/xml"
    private var feedLimit: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            feedUrl = savedInstanceState.getString(KEY_LINK)!!
            feedLimit = savedInstanceState.getInt(KEY_LIMIT)
        }
//        downloadUrl(feedUrl.format(feedLimit))
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
//                feedCached = "CACHED_LINK"
            }
            else -> return super.onOptionsItemSelected(item)
        }
//        downloadUrl(feedUrl.format(feedLimit))
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_LINK, feedUrl)
        outState.putInt(KEY_LIMIT, feedLimit)
    }

}