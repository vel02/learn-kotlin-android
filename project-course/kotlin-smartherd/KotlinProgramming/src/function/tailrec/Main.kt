package function.tailrec

import java.math.BigInteger

fun main(args: Array<String>) {
    println(getFibonacciNumber(10000, BigInteger("1"), BigInteger("0")))
}
//tailrec keyword: to avoid stackOverflow error
tailrec fun getFibonacciNumber(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) {
        b
    } else getFibonacciNumber(n - 1, a + b, a)
}

/*
0 1 1 2 3 5 8 ...

4: 1 + 0: 1 = 1
3: 1 + 1: 1 = 2
2: 2 + 1: 3 = 3
1: 3 + 2: 5 = 5
0: 5 = 5. fibonacci is 5


 */