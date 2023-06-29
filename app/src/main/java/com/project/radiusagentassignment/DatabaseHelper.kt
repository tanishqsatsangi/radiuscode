package com.project.radiusagentassignment

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.google.gson.Gson
import com.project.radiusagentassignment.models.FacilitiesAPIModel

class DatabaseHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "MVP_DB"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "FaciltiesList"
        private const val COLUMN_FACILITIES = "facilities"
        private const val COLUMN_ID = "id"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "CREATE TABLE $TABLE_NAME ( $COLUMN_ID INTEGER  UNIQUE, $COLUMN_FACILITIES TEXT PRIMARY KEY);"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun saveList(apiModel: FacilitiesAPIModel?) {
        try {
            if (apiModel == null) {
                return
            }
            val json = Gson().toJson(apiModel)
            val db = this.writableDatabase
            val values = ContentValues()
            values.put(COLUMN_FACILITIES, json)
            values.put(COLUMN_ID, 1)
            db.replace(TABLE_NAME, null, values)
            db.close()
        } catch (_: Exception) {

        }
    }

    fun getList(): FacilitiesAPIModel? {
        try {
            val db = this.writableDatabase
            val cursor = db.query(
                TABLE_NAME,
                arrayOf(
                    COLUMN_ID,
                    COLUMN_FACILITIES,
                ),
                null,
                null,
                null,
                null,
                null,
                null
            ) ?: return null
            cursor.moveToFirst()
            val json = cursor.getString(0)
            return Gson().fromJson(json, FacilitiesAPIModel::class.java)
        } catch (exception: Exception) {

        }
        return null
    }
}