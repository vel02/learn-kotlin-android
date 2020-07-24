package kiz.learnwithvel.flickrbrowser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kiz.learnwithvel.flickrbrowser.R
import kiz.learnwithvel.flickrbrowser.model.Photo


private const val TAG = "FlickrRecyclerAdapter"

class FlickrViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var thumbnail: ImageView = view.findViewById(R.id.browse_thumbnail)
    var title: TextView = view.findViewById(R.id.browse_title)
}

class FlickrRecyclerAdapter(private var photoList: List<Photo>) :
    RecyclerView.Adapter<FlickrViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlickrViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.browse, parent, false)
        return FlickrViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (photoList.isNotEmpty()) photoList.size else 0
    }

    override fun onBindViewHolder(holder: FlickrViewHolder, position: Int) {
        val photoItem = photoList[position]

        Picasso.get()
            .load(photoItem.image)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(holder.thumbnail)

        holder.title.text = photoItem.title
    }

    fun loadNewData(newPhoto: List<Photo>) {
        photoList = newPhoto
        notifyDataSetChanged()
    }

    fun getPhoto(position: Int): Photo? {
        return if (photoList.isNotEmpty()) photoList[position] else null
    }
}