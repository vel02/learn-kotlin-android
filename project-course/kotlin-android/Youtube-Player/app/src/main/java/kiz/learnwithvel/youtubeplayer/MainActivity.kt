package kiz.learnwithvel.youtubeplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_play_single.setOnClickListener(this@MainActivity)
        btn_standalone.setOnClickListener(this@MainActivity)
    }

    override fun onClick(view: View) {
        val intent = when (view.id) {
            R.id.btn_play_single -> Intent(this@MainActivity, YoutubeActivity::class.java)
            R.id.btn_standalone -> Intent(this@MainActivity, StandaloneActivity::class.java)
            else -> throw IllegalArgumentException("Undefined button clicked!")
        }
        startActivity(intent)
    }
}