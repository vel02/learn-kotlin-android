package kiz.learnwithvel.tasktimer.database

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log

/**
 * Provider for the TaskTimer App. This is the only class that knows about [AppDatabase]
 */

private const val TAG = "AppProvider"

private const val CONTENT_AUTHORITY =
    "kiz.learnwithvel.tasktimer.provider"// <-- A name of the provider

val CONTENT_AUTHORITY_URI: Uri =
    Uri.parse("content://$CONTENT_AUTHORITY")// <-- Act as a key (to allows access the data)


private const val TASKS = 100
private const val TASKS_ID = 101

private const val TIMINGS = 200
private const val TIMINGS_ID = 201

private const val TASK_DURATIONS = 400
private const val TASK_DURATIONS_ID = 401

class AppProvider : ContentProvider() {

    private val uriMatcher by lazy { buildUriMatcher() }

    //creating a location for uri
    private fun buildUriMatcher(): UriMatcher {
        Log.d(TAG, "buildUriMatcher: starts")
        val matcher = UriMatcher(UriMatcher.NO_MATCH)


        return matcher
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun onCreate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

}