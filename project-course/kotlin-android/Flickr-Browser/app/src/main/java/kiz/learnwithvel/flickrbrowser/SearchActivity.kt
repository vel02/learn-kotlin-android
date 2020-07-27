package kiz.learnwithvel.flickrbrowser

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView

private const val TAG = "SearchActivity"

class SearchActivity : BaseActivity() {

    private var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        activateToolbar(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }


}