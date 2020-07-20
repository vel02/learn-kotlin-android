package kiz.learnwithvel.top10downloader

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kiz.learnwithvel.top10downloader.util.ParseApplications
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class MainActivity : AppCompatActivity() {

    companion object {

        private const val TAG = "MainActivity"

        private class DownloadData : AsyncTask<String, Void, String>() {
            override fun doInBackground(vararg url: String?): String {
                val rssFeed = downloadXML(url[0])
                if (rssFeed.isEmpty()) {
                    Log.e(TAG, "doInBackground: Error downloading...")
                }
                return rssFeed
            }

            override fun onPostExecute(result: String) {
                val parseApplications = ParseApplications()
                parseApplications.parse(result)
            }

            private fun downloadXML(urlPath: String?): String {
                val xmlResult = StringBuilder()

                try {
                    val url = URL(urlPath)
                    val connection = url.openConnection() as HttpURLConnection
                    val code = connection.responseCode
                    Log.d(TAG, "downloadXML: response: $code")

                    connection.inputStream
                        .buffered()
                        .reader()
                        .use { xmlResult.append(it.readText()) }

                    return xmlResult.toString()

                } catch (e: Exception) {
                    val message = when (e) {
                        is MalformedURLException -> "Invalid URL ${e.message}"
                        is IOException -> "IO Exception ${e.message}"
                        is SecurityException -> "Security Exception ${e.message}"
                        else -> "Unknown exception ${e.message}"
                    }
                    Log.e(TAG, "downloadXML: $message")
                }

                return ""
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val downloadData = DownloadData()
        downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml")

    }

}