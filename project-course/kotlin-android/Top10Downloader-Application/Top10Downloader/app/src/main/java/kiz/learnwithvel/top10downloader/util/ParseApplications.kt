package kiz.learnwithvel.top10downloader.util

import android.util.Log
import kiz.learnwithvel.top10downloader.FeedEntry
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.util.*
import kotlin.collections.ArrayList

class ParseApplications {
    companion object {
        private const val TAG = "ParseApplications"
    }

    val applications = ArrayList<FeedEntry>()

    fun parse(xmlData: String): Boolean {
        Log.d(TAG, "parse called with $xmlData")
        var status = true
        var inEntry = false
        var textValue = ""

        try {

            //setup
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true

            val xpp = factory.newPullParser()
            xpp.setInput(xmlData.reader())

            var eventType = xpp.eventType
            var currentRecord = FeedEntry()

            //processing
            while (eventType != XmlPullParser.END_DOCUMENT) {

                val tagName = xpp.name?.toLowerCase(Locale.ROOT)

                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        if (tagName == "entry") {
                            inEntry = true
                        }
                    }

                    XmlPullParser.TEXT -> textValue = xpp.text

                    XmlPullParser.END_TAG -> {
                        if (inEntry) {

                            when (tagName) {
                                "entry" -> {
                                    applications.add(currentRecord)
                                    inEntry = false
                                    currentRecord = FeedEntry()
                                }
                                "name" -> currentRecord.name = textValue
                                "artist" -> currentRecord.artist = textValue
                                "releasedate" -> currentRecord.releaseDate = textValue
                                "summary" -> currentRecord.summary = textValue
                                "image" -> currentRecord.imageUrl = textValue
                            }
                        }
                    }
                }

                eventType = xpp.next()
            }

            for (app in applications) {
                Log.d(TAG, "***************************")
                Log.d(TAG, "parse: $app")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }

        return status
    }

}