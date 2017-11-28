package pl.edu.amu.wmi.students.mario.bif.zad1

import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

fun main(args: Array<String>) {

    val pow = 320000000
    var progress = 0.0
    val documents = IntStream.range(0, pow).parallel()
            .boxed()
            .map { it ->
                val newProgress = it.div(pow.toDouble())
                if (newProgress > progress) {
                    progress = newProgress
                    println(String.format("%.2f%%", progress * 100))
                }
                UUID.randomUUID().toString()
            }
            .collect(Collectors.toMap<String, String, String>({ it }, { CryptoBox.hash(it) }))

    val counts = documents.entries.groupBy { it.value }

    val filteredCounts = counts.filter { it.value.size > 1 }

    if (filteredCounts.any()) {
        val duplication = filteredCounts.iterator().next()
        println(duplication.key)
        duplication.value.forEach { println(it.value) }
    }

}