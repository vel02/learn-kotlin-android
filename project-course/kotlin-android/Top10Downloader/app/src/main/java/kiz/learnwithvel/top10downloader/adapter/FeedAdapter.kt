package kiz.learnwithvel.top10downloader.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kiz.learnwithvel.top10downloader.FeedEntry
import kiz.learnwithvel.top10downloader.R


class ViewHolder(v: View) {
    val name: TextView = v.findViewById(R.id.tv_name)
    val artist: TextView = v.findViewById(R.id.tv_artist)
    val summary: TextView = v.findViewById(R.id.tv_summary)
}

class FeedAdapter(
    context: Context,
    private val resource: Int,
    private var applications: List<FeedEntry>
) :
    ArrayAdapter<FeedEntry>(context, resource) {

    private val inflater = LayoutInflater.from(context)

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val currentApp = applications[position]

        viewHolder.name.text = currentApp.name
        viewHolder.artist.text = currentApp.artist
        viewHolder.summary.text = currentApp.summary

        return view
    }

    override fun getCount(): Int {
        return applications.size
    }

    fun setFeedList(feedList: List<FeedEntry>) {
        this.applications = feedList
        notifyDataSetChanged()
    }
}