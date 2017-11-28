package pl.edu.amu.wmi.students.mario.bif.zad1

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import java.util.stream.IntStream

fun main(args: Array<String>) {
    Database.connect("jdbc:h2:file:P:\\s396378\\hashes.db", driver = "org.h2.Driver")

    transaction {
        SchemaUtils.create(Entries)
    }

    val pow = 320000000
    IntStream.range(0, pow).parallel()
            .boxed()
            .map { UUID.randomUUID().toString() }
            .forEach { generatedUUID ->
                transaction {
                    Entries.insert {
                        it[uuid] = generatedUUID
                        it[hash] = CryptoBox.hash(generatedUUID)
                    }
                }
                println(++counter.c)
            }
}

object counter {
    @Volatile
    var c = 0
}