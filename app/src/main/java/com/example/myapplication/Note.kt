package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "text") val text: String) {
    @PrimaryKey var id: Long? = null
}