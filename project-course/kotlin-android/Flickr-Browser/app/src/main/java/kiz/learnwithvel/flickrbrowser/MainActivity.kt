package kiz.learnwithvel.flickrbrowser

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kiz.learnwithvel.flickrbrowser.model.Photo
import kiz.learnwithvel.flickrbrowser.util.DownloadStatus
import kiz.learnwithvel.flickrbrowser.util.GetFlickrJsonData
import kiz.learnwithvel.flickrbrowser.util.GetRawData
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), GetRawData.OnDownloadComplete,
    GetFlickrJsonData.OnDataAvailable {

    override fun onDataAvailable(data: List<Photo>) {
        Log.d(TAG, "onDataAvailable: $data")
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val getRawData = GetRawData(this@MainActivity)
        getRawData.execute("https://www.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags=android,nougat,sdk&tagmode=any")

        fab.setOnClickListener {
            Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}