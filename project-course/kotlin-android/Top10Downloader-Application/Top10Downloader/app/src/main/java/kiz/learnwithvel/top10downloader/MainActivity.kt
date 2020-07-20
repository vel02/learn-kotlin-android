package kiz.learnwithvel.top10downloader

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kiz.learnwithvel.top10downloader.util.ParseApplications
import java.net.URL

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

        private class DownloadData : AsyncTask<String, Void, String>() {

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
            }

            private fun downloadXML(urlPath: String?): String {
//                //solution #1
//                val xmlResult = StringBuilder()
//
//                try {
//                    val url = URL(urlPath)
//                    val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
//                    val code = connection.responseCode
//                    Log.d(TAG, "downloadXML: code: $code")
//
//                    connection.inputStream
//                        .buffered()
//                        .reader()
//                        .use { xmlResult.append(it.readText()) }
//
//                    return xmlResult.toString()
//
//                } catch (e: Exception) {
//                    val message = when (e) {
//                        is MalformedURLException -> "downloadXML: Invalid URL ${e.message}"
//                        is IOException -> "downloadXML: IO Exception ${e.message}"
//                        is SecurityException -> "downloadXML: SecurityException. Need permissions? ${e.message}"
//                        else -> "downloadXML: Unknown ERROR: ${e.message}"
//                    }
//                    Log.e(TAG, "downloadXML: $message")
//                }

                //solution #2: with limit.
                return URL(urlPath).readText()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate() called.")
        val downloadData = DownloadData()
        downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml")
    }

}