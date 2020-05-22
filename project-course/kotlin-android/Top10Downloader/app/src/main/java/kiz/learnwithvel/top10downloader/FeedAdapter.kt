package kiz.learnwithvel.top10downloader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

private const val TAG = "FeedAdapter"

class FeedAdapter(context: Context, val resource: Int, val applications: List<FeedEntry>) :
    ArrayAdapter<FeedEntry>(context, resource) {

    private val inflater = LayoutInflater.from(context)

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

        viewHolder.tvName.text = currentApp.name
        viewHolder.tvArtist.text = currentApp.artist
        viewHolder.tvSummary.text = currentApp.summary

        return view
    }

    override fun getCount(): Int {
        return applications.size
    }

    companion object {
        private class ViewHolder(v: View) {

            val tvName: TextView = v.findViewById(R.id.tv_name)
            val tvArtist: TextView = v.findViewById(R.id.tv_artist)
            val tvSummary: TextView = v.findViewById(R.id.tv_summary)
        }
    }
}