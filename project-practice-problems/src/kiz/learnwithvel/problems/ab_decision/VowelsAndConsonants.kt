package kiz.learnwithvel.problems.ab_decision

fun main() {

    val sentence = "This website is aw3som3."
    var vowel = 0
    var consonant = 0
    var digit = 0
    var whitespaces = 0

    for (i in sentence.indices) {
        val char = sentence[i].toLowerCase()
        when {
            char == 'a' || char == 'e' || char == 'i'
                    || char == 'o' || char == 'u' -> vowel++
            char.isDigit() -> digit++
            char.isWhitespace() -> whitespaces++
            else -> consonant++
        }

    }

    println("Vowels: $vowel\nConsonants: $consonant\nDigit: $digit\nWhitespaces: $whitespaces")

}