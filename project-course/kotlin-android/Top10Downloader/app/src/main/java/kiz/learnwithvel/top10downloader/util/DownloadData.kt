package kiz.learnwithvel.top10downloader.util

import android.os.AsyncTask
import android.util.Log
import kiz.learnwithvel.top10downloader.FeedEntry
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

const val TAG = "DownloadData"

class DownloadData(private val callback: DownloaderCallBack) : AsyncTask<String, Void, String>() {

    interface DownloaderCallBack {
        fun onDataAvailable(data: List<FeedEntry>)
    }

    override fun doInBackground(vararg url: String): String {
        val rssFeed = downloadXML(url[0])
        if (rssFeed.isEmpty()) {
            Log.e(TAG, "doInBackground: Error downloading")
        }
        return rssFeed;
    }

    override fun onPostExecute(result: String) {
        val parseApplications = ParseApplications()
        if (result.isNotEmpty()) {
            parseApplications.parse(result)
        }

        callback.onDataAvailable(parseApplications.applications)
    }

    private fun downloadXML(urlPath: String): String {
        try {
            return URL(urlPath).readText()
        } catch (e: MalformedURLException) {
            Log.d(TAG, "downloadXML: Invalid URL ${e.message}")
        } catch (e: IOException) {
            Log.d(TAG, "downloadXML: IO Exception ${e.message}")
        } catch (e: SecurityException) {
            Log.d(TAG, "downloadXML: Security Exception. Need Permission? ${e.message}")
        }
        return ""
    }
}