package kiz.learnwithvel.problems.ab_decision

fun main() {


    val words = arrayOf("Ruby", "C", "Python", "Java")

    for (i in 0..2) {
        for (j in (i + 1)..3) {
            if (words[i].compareTo(words[j]) > 0) {
                val word = words[i]
                words[i] = words[j]
                words[j] = word
            }
        }
    }

    for (word in words) {
        println(word)
    }
}