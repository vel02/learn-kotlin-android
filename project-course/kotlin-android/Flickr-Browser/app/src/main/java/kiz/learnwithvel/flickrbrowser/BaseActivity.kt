package kiz.learnwithvel.flickrbrowser

import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


private const val TAG = "BaseActivity"

internal const val FLICKR_QUERY = "FLICKR_QUERY"
internal const val FLICKR_TRANSFER = "FLICKR_QUERY"

open class BaseActivity : AppCompatActivity() {

    internal fun activateToolbar(enableHome: Boolean) {
        Log.d(TAG, "activateToolbar()")
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(enableHome)
    }

}