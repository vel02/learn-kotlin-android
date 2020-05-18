package kiz.learnwithvel.top10downloader

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.net.URL

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
            summary = $summary
            image = $imageURL
        """.trimIndent()
    }
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate() start")
        val downloadData = DownloadData()
        downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml")
        Log.d(TAG, "onCreate() done")
    }

    //static
    companion object {
        private const val TAG = "DownloadData"

        //AsyncTask class for asynchronous process
        private class DownloadData : AsyncTask<String, Void, String>() {

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "doInBackground: starts with ${url[0]}")
                val rssFeed = downloadXML(url[0])
                if (rssFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground: Error downloading")
                }
                return rssFeed
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                Log.d(TAG, "onPostExecute: parameter is $result")
            }

            private fun downloadXML(urlPath: String?): String {
                //One-line code for reading url data but... not recommended for huge files may use long method.
                return URL(urlPath).readText()//This method is not recommended on huge files.
            }

        }
    }

}
