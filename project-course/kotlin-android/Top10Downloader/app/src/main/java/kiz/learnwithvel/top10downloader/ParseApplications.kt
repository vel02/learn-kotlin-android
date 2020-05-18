package kiz.learnwithvel.top10downloader

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

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

            }

        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }

        return status
    }
}