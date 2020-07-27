package kiz.learnwithvel.flickrbrowser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kiz.learnwithvel.flickrbrowser.adapter.FlickrRecyclerAdapter
import kiz.learnwithvel.flickrbrowser.model.Photo
import kiz.learnwithvel.flickrbrowser.util.DownloadStatus
import kiz.learnwithvel.flickrbrowser.util.GetFlickrJsonData
import kiz.learnwithvel.flickrbrowser.util.GetRawData
import kiz.learnwithvel.flickrbrowser.util.RecyclerItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

private const val TAG = "MainActivity"

class MainActivity : BaseActivity(), GetRawData.OnDownloadComplete,
    GetFlickrJsonData.OnDataAvailable,
    RecyclerItemClickListener.OnRecyclerClickListener {

    override fun onDataAvailable(data: List<Photo>) {
        adapter.loadNewData(data)
    }

    override fun onError(exception: Exception) {
        Log.d(TAG, "onError: ${exception.message}")
    }

    override fun onDownloadComplete(data: String, status: DownloadStatus) {
        if (status == DownloadStatus.OK) {
            Log.d(TAG, "onDownloadComplete called, data is $data")
            val getFlickrJsonData = GetFlickrJsonData(this)
            getFlickrJsonData.execute(data)
        } else {
            Log.d(TAG, "onDownloadComplete failed with status $status. Error message is $data")
        }
    }

    override fun onItemClick(view: View, position: Int) {
        Log.d(TAG, "onItemClick: position $position")
    }

    override fun onItemLongClick(view: View, position: Int) {
        Log.d(TAG, "onItemLongClick: position $position")
        val photo = adapter.getPhoto(position)
        if (photo != null) {
            val intent = Intent(this@MainActivity, PhotoDetailsActivity::class.java)
            intent.putExtra(FLICKR_TRANSFER, photo)
            startActivity(intent)
        }
    }

    private val adapter = FlickrRecyclerAdapter(ArrayList())

    override fun onResume() {
        super.onResume()
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val query = sharedPref.getString(FLICKR_QUERY, "")!!
        if (query.isNotEmpty()) {
            val url = createUri(
                "Https://www.flickr.com/services/feeds/photos_public.gne",
                query,
                "en-us",
                false
            )
            val getRawData = GetRawData(this@MainActivity)
            getRawData.execute(url)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activateToolbar(false)

        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler_view.addOnItemTouchListener(RecyclerItemClickListener(this, recycler_view, this))
        recycler_view.adapter = adapter

        fab.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    private fun createUri(
        baseUrl: String,
        searchCriteria: String,
        lang: String,
        matchAll: Boolean
    ): String {
        Log.d(TAG, "createUri: starts")
        return Uri.parse(baseUrl)
            .buildUpon()
            .appendQueryParameter("tags", searchCriteria)
            .appendQueryParameter("tagmode", if (matchAll) "ALL" else "ANY")
            .appendQueryParameter("lang", lang)
            .appendQueryParameter("format", "json")
            .appendQueryParameter("nojsoncallback", "1")
            .build().toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                startActivity(Intent(this@MainActivity, SearchActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}