package kiz.learnwithvel.tasktimer.util.contract.timings

import android.content.ContentUris
import android.net.Uri
import android.provider.BaseColumns
import kiz.learnwithvel.tasktimer.database.CONTENT_AUTHORITY
import kiz.learnwithvel.tasktimer.database.CONTENT_AUTHORITY_URI

object TimingsContract {

    internal const val TABLE_NAME = "Timings"

    private val CONTENT_URI: Uri = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME)

    const val CONTENT_TYPE = "vnd.android.cursor.dir/vnd.$CONTENT_AUTHORITY.$TABLE_NAME"
    const val CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.$CONTENT_AUTHORITY.$TABLE_NAME"

    object Columns {
        const val ID = BaseColumns._ID
        const val TIMING_TASK_ID = "TasksId"
        const val TIMING_START_TIME = "StartTime"
        const val TIMING_DURATION = "Duration"
    }

    fun getId(uri: Uri): Long {
        return ContentUris.parseId(uri)
    }

    fun buildUriFromId(id: Long): Uri {
        return ContentUris.withAppendedId(CONTENT_URI, id)
    }

}