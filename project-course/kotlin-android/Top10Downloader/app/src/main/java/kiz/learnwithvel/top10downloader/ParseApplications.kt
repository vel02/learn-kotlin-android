package kiz.learnwithvel.top10downloader

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.util.*
import kotlin.collections.ArrayList

private const val TAG = "ParseApplications"

class ParseApplications {
    val applications = ArrayList<FeedEntry>()

    fun parse(xmlData: String): Boolean {
        Log.d(TAG, "parse called with $xmlData")
        var status = true
        var inEntry = false
        var textValue = ""

        try {

            //initialization of pull parser
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val xpp = factory.newPullParser()

            //setting up for reading data
            xpp.setInput(xmlData.reader())
            var eventType = xpp.eventType

            var currentRecord = FeedEntry()

            while (eventType != XmlPullParser.END_DOCUMENT) {

                val tagName = xpp.name?.toLowerCase(Locale.ROOT)

                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        Log.d(TAG, "parse: start tag for  $tagName")
                        if (tagName == "entry") {
                            inEntry = true
                        }
                    }

                    XmlPullParser.TEXT -> textValue = xpp.text

                    XmlPullParser.END_TAG -> {
                        Log.d(TAG, "parse: ending tag for $tagName")
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
                                "image" -> currentRecord.imageURL = textValue
                            }

                        }
                    }
                }

                eventType = xpp.next()
            }

            for (app in applications) {
                Log.d(TAG, "*********************")
                Log.d(TAG, app.toString())
            }

        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }

        return status
    }
}