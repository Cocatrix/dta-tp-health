package fr.codevallee.formation.health;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class EmployeeDBHelper extends SQLiteOpenHelper {
    /**
     * Class with data to create the database.
     * Does create/drop table queries.
     */
    private static String DB_NAME = "Employees";
    private static Integer DB_VERSION = 2;

    public EmployeeDBHelper(Context context) {
        /**
         * Allows to call constructor with context only.
         */
        this(context, DB_NAME, null, DB_VERSION);
    }

    private EmployeeDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                             int version) {
        /**
         * Matches abstract parent constructor.
         */
        super(context, DB_NAME, null, DB_VERSION);
    }

    private String queryCreate() {
        //TODO - return Resources.getSystem().getString(R.string.create_table_employee_query);
        return "CREATE TABLE Employee ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "family_name VARCHAR(30) NOT NULL,"
                + "first_name VARCHAR(15) NOT NULL,"
                + "gender VARCHAR(15) NOT NULL,"
                + "job VARCHAR(60) NOT NULL,"
                + "service VARCHAR(60) NOT NULL,"
                + "email VARCHAR(60) NOT NULL,"
                + "phone VARCHAR(30) NOT NULL,"
                + "cv VARCHAR(1000) NOT NULL"
                + ");";
    }

    private String queryDrop() {
        //TODO - return Resources.getSystem().getString(R.string.drop_table_employee_query);
        return "DROP TABLE IF EXISTS Employee";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.queryCreate());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(this.queryDrop());
        db.execSQL(this.queryCreate());

    }
}
