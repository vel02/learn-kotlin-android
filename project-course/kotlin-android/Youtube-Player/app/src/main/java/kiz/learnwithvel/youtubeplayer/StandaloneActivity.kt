package kiz.learnwithvel.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)
        btn_playing_video.setOnClickListener(this)
        btn_playlist.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when (view.id) {
            R.id.btn_playing_video -> YouTubeStandalonePlayer
                .createVideoIntent(
                    this@StandaloneActivity,
                    getString(R.string.GOOGLE_API_KEY),
                    YOUTUBE_VIDEO_ID,
                    0, true, false
                )
            R.id.btn_playlist -> YouTubeStandalonePlayer
                .createPlaylistIntent(
                    this@StandaloneActivity,
                    getString(R.string.GOOGLE_API_KEY),
                    YOUTUBE_PLAYLIST,
                    0, 0, true, true
                )
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}