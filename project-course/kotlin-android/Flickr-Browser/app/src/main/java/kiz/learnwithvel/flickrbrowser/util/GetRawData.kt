package kiz.learnwithvel.flickrbrowser.util

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

private const val TAG = "GetRawData"

enum class DownloadStatus { OK, IDLE, NOT_INITIALIZED, FAILED_OR_EMPTY, PERMISSION_ERROR, ERROR }

class GetRawData(private val listener: OnDownloadComplete) : AsyncTask<String, Void, String>() {

    private var downloadStatus =
        DownloadStatus.IDLE

    interface OnDownloadComplete {
        fun onDownloadComplete(data: String, status: DownloadStatus)
    }

    override fun doInBackground(vararg p0: String?): String {
        if (p0[0] == null) {
            downloadStatus =
                DownloadStatus.NOT_INITIALIZED
            return "No URL specified"
        }

        try {
            downloadStatus =
                DownloadStatus.OK
            return URL(p0[0]).readText()
        } catch (e: Exception) {
            val message = when (e) {
                is MalformedURLException -> {
                    downloadStatus =
                        DownloadStatus.NOT_INITIALIZED
                    "doInBackground: Invalid URL ${e.message}"
                }
                is IOException -> {
                    downloadStatus =
                        DownloadStatus.FAILED_OR_EMPTY
                    "doInBackground: IO Exception reading data ${e.message}"
                }
                is SecurityException -> {
                    downloadStatus =
                        DownloadStatus.PERMISSION_ERROR
                    "doInBackground: Security Exception. Need Permission? ${e.message}"
                }
                else -> {
                    downloadStatus =
                        DownloadStatus.ERROR
                    "Unknown error: ${e.message}"
                }
            }
            Log.e(TAG, message)
            return message
        }

    }

    override fun onPostExecute(result: String) {
        listener.onDownloadComplete(result, downloadStatus)
    }
}