package kiz.learnwithvel.top10downloader.util

import android.util.Log
import kiz.learnwithvel.top10downloader.model.FeedEntry
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class ParseApplications {

    companion object {
        private const val TAG = "ParseApplications"
    }

    private val applications = ArrayList<FeedEntry>()

    fun parse(xmlData: String): Boolean {
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
            var currentData = FeedEntry()

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
                                    applications.add(currentData)
                                    inEntry = false
                                    currentData = FeedEntry()
                                }
                                "name" -> currentData.name = textValue
                                "artist" -> currentData.artist = textValue
                                "releasedate" -> currentData.releaseData = textValue
                                "summary" -> currentData.summary = textValue
                                "image" -> currentData.imageUrl = textValue
                            }

                        }
                    }
                }

                eventType = xpp.next()
            }

            for (app in applications) {
                Log.d(TAG, "parse: $app")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }

        return status
    }


}