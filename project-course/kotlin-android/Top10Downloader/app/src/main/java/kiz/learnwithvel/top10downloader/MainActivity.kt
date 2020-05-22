package kiz.learnwithvel.top10downloader

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates

private const val TAG = "MainActivity"

class FeedEntry {
    var name: String = ""
    var artist: String = ""
    var releaseDate: String = ""
    var summary: String = ""
    var imageURL: String = ""

    override fun toString(): String {
        return """
            name = $name
            artist = $artist
            releaseDate = $releaseDate
            image = $imageURL
        """.trimIndent()
    }
}

class MainActivity : AppCompatActivity() {

    private val downloadData by lazy { DownloadData(this, list_item_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate() start")
        downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml")
        Log.d(TAG, "onCreate() done")
    }

    override fun onDestroy() {
        super.onDestroy()
        downloadData.cancel(true)
    }

    companion object {
        private const val TAG = "DownloadData"

        private class DownloadData(context: Context, list: ListView) :
            AsyncTask<String, Void, String>() {

            //backing fields
            var context: Context by Delegates.notNull()
            var list: ListView by Delegates.notNull()

            //initialization
            init {
                this.context = context
                this.list = list
            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "doInBackground: starts with ${url[0]}")
                val rssFeed = downloadXML(url[0])
                if (rssFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground: Error downloading")
                }
                return rssFeed
            }

            override fun onPostExecute(result: String) {

                val parse = ParseApplications()
                parse.parse(result);

                val arrayAdapter =
                    FeedAdapter(context, R.layout.list_record, parse.applications)
                this.list.adapter = arrayAdapter
            }

            private fun downloadXML(urlPath: String?): String {
                return URL(urlPath).readText()
            }

        }
    }

}
