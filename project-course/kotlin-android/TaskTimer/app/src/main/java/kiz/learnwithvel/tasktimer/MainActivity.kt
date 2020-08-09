package kiz.learnwithvel.tasktimer

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kiz.learnwithvel.tasktimer.util.TasksContract
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

        val cursor = contentResolver.query(
//            TasksContract.CONTENT_URI,
            TasksContract.buildUriFromId(1),
            projections, null, null, sortOrder
        )
        Log.d(TAG, "**********************")
        cursor.use {
            while (it!!.moveToNext()) {
//                val id = it.getLong(0)
                with(cursor) {
                    val name = this!!.getString(0)
//                val description = it.getString(2)
                    val sortOrder = getString(1)
                    val result =
//                    "ID: $id. Name: $name. Description: $description. SortOrder: $sortOrder"
                        "Name: $name. SortOrder: $sortOrder"
                    Log.d(TAG, "onCreate: reading data $result")
                }
            }
        }
        Log.d(TAG, "**********************")

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}