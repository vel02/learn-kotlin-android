package kiz.learnwithvel.top10downloader

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
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
                Log.d(TAG, "doInBackground: starts with ${url[0]}")
                val rssFeed = downloadXML(url[0])
                if (rssFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground: Error downloading")
                }
                return rssFeed;
            }

            override fun onPostExecute(result: String) {
                val parseApplications = ParseApplications()
                parseApplications.parse(result)

                val adapter = ArrayAdapter<FeedEntry>(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate() called.")
        val downloadData = DownloadData(this, list_item)
        downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml")
    }

}