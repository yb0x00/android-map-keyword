package campus.tech.kakao.map

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class RecentDBHelper(context: Context) : SQLiteOpenHelper(context,"RecentData.db",null,2){
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("yeong","Create DB!")
        createRecentDataTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${RecentDataContract.TABLE_NAME}")
        createRecentDataTable(db)
    }

    private fun createRecentDataTable(db: SQLiteDatabase?){
        db?.execSQL(
            "CREATE TABLE ${RecentDataContract.TABLE_NAME} (" +
                    "${RecentDataContract.TABLE_COLUMN_NAME} varchar(30) NOT NULL, " +
                    "${RecentDataContract.TABLE_COLUMN_TIME} integer NOT NULL);"
        )
    }
}