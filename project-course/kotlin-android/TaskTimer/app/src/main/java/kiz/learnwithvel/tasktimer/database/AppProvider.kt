package kiz.learnwithvel.tasktimer.database

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import android.util.Log
import kiz.learnwithvel.tasktimer.util.TasksContract

/**
 * Provider for the TaskTimer App. This is the only class that knows about [AppDatabase]
 */

private const val TAG = "AppProvider"

const val CONTENT_AUTHORITY =
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

        //content://kiz.learnwithvel.tasktimer.provider/Tasks
        matcher.addURI(CONTENT_AUTHORITY, TasksContract.TABLE_NAME, TASKS)

        //content://kiz.learnwithvel.tasktimer.provider/Tasks/8
        matcher.addURI(CONTENT_AUTHORITY, "${TasksContract.TABLE_NAME}/#", TASKS_ID)

//        matcher.addURI(CONTENT_AUTHORITY, TimingsContract.TABLE_NAME, TIMINGS)
//        matcher.addURI(CONTENT_AUTHORITY, "${TimingsContract.TABLE_NAME}/#", TIMINGS_ID)

//        matcher.addURI(CONTENT_AUTHORITY, DurationsContract.TABLE_NAME, TASK_DURATIONS)
//        matcher.addURI(CONTENT_AUTHORITY, "${DurationsContract.TABLE_NAME}/#", TASK_DURATIONS_ID)

        return matcher
    }

    override fun onCreate(): Boolean {
        Log.d(TAG, "onCreate: starts")
        return true
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun query(
        uri: Uri,
        projections: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        Log.d(TAG, "query: called with uri $uri")
        val match = uriMatcher.match(uri)// location to be access
        Log.d(TAG, "query: match is $match")

        val queryBuilder = SQLiteQueryBuilder()

        when (match) {
            //"SELECT * FROM Tasks"
            TASKS -> queryBuilder.tables = TasksContract.TABLE_NAME
            //"SELECT * FROM Tasks WHERE id = 8"
            TASKS_ID -> {
                queryBuilder.tables = TasksContract.TABLE_NAME
                val taskId = TasksContract.getId(uri)
                queryBuilder.appendWhere("${TasksContract.Columns.ID} = $taskId")
            }
//            TIMINGS -> queryBuilder.tables = TimingsContract.TABLE_NAME
//            TIMINGS_ID -> {
//                queryBuilder.tables = TimingsContract.TABLE_NAME
//                val timingId = TimingsContract.getId(uri)
//                queryBuilder.appendWhere("${TimingsContract.Columns.ID} = $timingId")
//            }
//            TASK_DURATIONS -> queryBuilder.tables = DurationsContract.TABLE_NAME
//            TASK_DURATIONS_ID -> {
//                queryBuilder.tables = DurationsContract.TABLE_NAME
//                val durationId = DurationsContract.getId(uri)
//                queryBuilder.appendWhere("${DurationsContract.Columns.ID} = $durationId")
//            }
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }

        val db = context?.let { AppDatabase.getInstance(it).readableDatabase }
        val cursor = queryBuilder.query(
            db, projections, selection, selectionArgs, null, null, sortOrder
        )
        Log.d(TAG, "query: rows in returned cursor = ${cursor.count}")
        return cursor

    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

}