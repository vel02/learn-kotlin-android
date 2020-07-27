package kiz.learnwithvel.flickrbrowser

import android.os.Bundle
import com.squareup.picasso.Picasso
import kiz.learnwithvel.flickrbrowser.model.Photo
import kotlinx.android.synthetic.main.content_photo_details.*

class PhotoDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)
        activateToolbar(true)

        val photo = intent.getParcelableExtra<Photo>(FLICKR_TRANSFER)

        photo_title.text = resources.getString(R.string.photo_title_text, photo?.title)
        photo_tags.text = resources.getString(R.string.photo_tags_text, photo?.tags)
        photo_author.text = photo?.author

        Picasso.get()
            .load(photo?.image)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(photo_image)
    }
}