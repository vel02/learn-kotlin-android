package kiz.learnwithvel.top10downloader.model

class FeedEntry {

    var name: String = ""
    var artist: String = ""
    var releaseData: String = ""
    var summary: String = ""
    var imageUrl: String = ""

    override fun toString(): String {
        return "FeedEntry(name='$name', " +
                "artist='$artist', " +
                "releaseData='$releaseData', " +
                "imageUrl='$imageUrl')"
    }


}