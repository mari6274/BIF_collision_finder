package pl.edu.amu.wmi.students.mario.bif.zad1

import org.jetbrains.exposed.sql.Table

object Entries : Table() {
    val uuid = varchar("uuid", 40).primaryKey().index()
    val hash = varchar("hash", length = 40).index()
}