package kiz.learnwithvel.tasktimer

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kiz.learnwithvel.tasktimer.util.contract.tasks.TasksContract
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val projections =
            arrayOf(TasksContract.Columns.TASK_NAME, TasksContract.Columns.TASK_SORT_ORDER)
        val sortOrder = TasksContract.Columns.TASK_SORT_ORDER

//        testInsert()
//        testUpdate()
//        testUpdateTwo()
//        testDelete()
        testDeleteTwo()

        val cursor = contentResolver.query(
            TasksContract.CONTENT_URI,
//            TasksContract.buildUriFromId(2),
            null, null, null, sortOrder
        )
        Log.d(TAG, "**********************")
        cursor.use {
            while (it!!.moveToNext()) {
                val id = it.getLong(0)
                val name = it.getString(1)
                val description = it.getString(2)
                val order = it.getString(3)
                val result =
                    "ID: $id. Name: $name. Description: $description. SortOrder: $order"
                Log.d(TAG, "onCreate: reading data $result")
            }
        }
        Log.d(TAG, "**********************")

    }

    private fun testDeleteTwo() {

        val selection = TasksContract.Columns.TASK_DESCRIPTION + " = ?"
        val selectionArgs = arrayOf("For deletion")

        val row = contentResolver.delete(
            TasksContract.CONTENT_URI,
            selection,
            selectionArgs
        )
        Log.d(TAG, "Number of rows delete is $row")

    }

    private fun testDelete() {

        val taskUri = TasksContract.buildUriFromId(3)
        val row = contentResolver.delete(taskUri, null, null)
        Log.d(TAG, "Number of row deleted is $row")

    }

    private fun testUpdateTwo() {
        val values = ContentValues().apply {
            put(TasksContract.Columns.TASK_SORT_ORDER, 999)
            put(TasksContract.Columns.TASK_DESCRIPTION, "For deletion")
        }

        val selection = TasksContract.Columns.TASK_SORT_ORDER + " = ?"
        val selectionArgs = arrayOf("99")

        val row = contentResolver.update(
            TasksContract.CONTENT_URI,
            values,
            selection,
            selectionArgs
        )
        Log.d(TAG, "Number of row updated is $row")

    }

    private fun testUpdate() {
        val values = ContentValues().apply {
            put(TasksContract.Columns.TASK_NAME, "Content Provider")
            put(TasksContract.Columns.TASK_DESCRIPTION, "Record content providers video")
        }
        val taskUri = TasksContract.buildUriFromId(4)
        val row = contentResolver.update(taskUri, values, null, null)
        Log.d(TAG, "Number of row updated is $row")

    }

    private fun testInsert() {
        val values = ContentValues().apply {
            put(TasksContract.Columns.TASK_NAME, "New Task 1")
            put(TasksContract.Columns.TASK_DESCRIPTION, "Description 1")
            put(TasksContract.Columns.TASK_SORT_ORDER, 2)
        }
        val uri = contentResolver.insert(TasksContract.CONTENT_URI, values)
        Log.d(TAG, "New row id (in uri) is $uri")
        Log.d(TAG, "id (in uri) is ${uri?.let { TasksContract.getId(it) }}")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}