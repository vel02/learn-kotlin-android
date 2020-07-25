package kiz.learnwithvel.flickrbrowser

import android.os.Bundle

private const val TAG = "SearchActivity"

class SearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        activateToolbar(true)

    }
}