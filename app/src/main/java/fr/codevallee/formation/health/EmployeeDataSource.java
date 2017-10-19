package fr.codevallee.formation.health;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class EmployeeDataSource {
    /**
     * Class managing the datasource.
     * It's a database factory AND an EmployeeDAO factory.
     * Method getDB returns the database (after initialising it if needed).
     * Method getEmployeeDAO returns the employeeDAO (after creating it if needed).
     */
    private final EmployeeDBHelper helper;
    private SQLiteDatabase db;

    private EmployeeDAO employeeDAO;

    public EmployeeDataSource(Context context) {
        helper = new EmployeeDBHelper(context);
    }

    // Database factory
    public SQLiteDatabase getDB() {
        if (db == null) {
            this.open();
        }
        return db;
    }

    private void open() {
        db = helper.getWritableDatabase();
    }

    private void close() {
        helper.close();
    }

    // EmployeeDAO factory
    public EmployeeDAO getEmployeeDAO() {
        if(this.employeeDAO == null) {
            this.employeeDAO = new EmployeeDAO(this);
        }
        return this.employeeDAO;
    }
}
