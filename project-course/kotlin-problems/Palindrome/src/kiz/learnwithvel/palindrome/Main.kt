package kiz.learnwithvel.palindrome

fun main(args: Array<String>) {

    var input = 121;
    val original = input;
    var reverseOutput = 0;

    while (input != 0) {
        reverseOutput = (reverseOutput * 10) + (input % 10);
        input /= 10;
    }
    val isPalindrome = if (reverseOutput == original) "$original is a palindrome"
    else "$original is not a palindrome"
    println(isPalindrome)


}