package fr.codevallee.formation.health.databases;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class EmployeeDAO {
    /**
     * Allows to access data and store it in Employee instances.
     */
    private static final String TABLE_NAME = "Employee";
    private static final String COL_ID = "id";
    private static final String COL_FAMILY_NAME = "family_name";
    private static final String COL_FIRST_NAME = "first_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_JOB = "job";
    private static final String COL_SERVICE = "service";
    private static final String COL_EMAIL = "email";
    private static final String COL_PHONE = "phone";
    private static final String COL_CV = "cv";
    private static final String CLAUSE = " = ?";

    private final EmployeeDataSource employeeDataSource;

    public EmployeeDAO(EmployeeDataSource employeeDataSource) {
        this.employeeDataSource = employeeDataSource;
    }

    // TODO - check update and delete methods

    public synchronized Employee create(Employee employee) {
        ContentValues values = new ContentValues();
        values.put(COL_FAMILY_NAME, employee.getFamilyName());
        values.put(COL_FIRST_NAME, employee.getFirstName());
        values.put(COL_GENDER, employee.getGender());
        values.put(COL_JOB, employee.getJob());
        values.put(COL_SERVICE, employee.getService());
        values.put(COL_EMAIL, employee.getEmail());
        values.put(COL_PHONE, employee.getPhone());
        values.put(COL_CV, employee.getCV());
        // Processing insert request
        Integer id = (int) employeeDataSource.getDB().insert(TABLE_NAME,null,values);
        employee.setId(id);
        return employee;
    }

    public synchronized Employee update(Employee employee) {
        ContentValues values = new ContentValues();
        values.put(COL_FAMILY_NAME, employee.getFamilyName());
        values.put(COL_FIRST_NAME, employee.getFirstName());
        values.put(COL_GENDER, employee.getGender());
        values.put(COL_JOB, employee.getJob());
        values.put(COL_SERVICE, employee.getService());
        values.put(COL_EMAIL, employee.getEmail());
        values.put(COL_PHONE, employee.getPhone());
        values.put(COL_CV, employee.getCV());
        String clause = COL_ID + CLAUSE;
        String[] clauseArgs = new String[] {employee.getId().toString()};
        // Processing update request
        employeeDataSource.getDB().update(TABLE_NAME,values,clause,clauseArgs);
        return employee;
    }

    public synchronized List<Employee> readAll() {
        String allColumns[] = new String[]{COL_ID,COL_FAMILY_NAME,COL_FIRST_NAME,COL_GENDER,COL_JOB,
                COL_SERVICE, COL_EMAIL, COL_PHONE, COL_CV};
        // Processing select query
        Cursor cursor = employeeDataSource.getDB().query(TABLE_NAME,allColumns,null,null,null,null,
                null);

        List<Employee> employees = new ArrayList<Employee>();
        // Iterate in the list to read all employees
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            employees.add(new Employee(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8)));
            cursor.moveToNext();
        }
        cursor.close();

        return employees;
    }

    public synchronized Employee read(Employee employee) {
        String allColumns[] = new String[]{COL_ID,COL_FAMILY_NAME,COL_FIRST_NAME,COL_GENDER,COL_JOB,
                COL_SERVICE, COL_EMAIL, COL_PHONE, COL_CV};
        // Adding clause "where id = []"
        String clause = COL_ID + CLAUSE;
        String[] clauseArgs = new String[] {employee.getId().toString()};
        // Processing select query
        Cursor cursor = employeeDataSource.getDB().query(TABLE_NAME,allColumns,clause,clauseArgs,
                null,null,null);

        // Read the cursor
        cursor.moveToFirst();
        employee.setFamilyName(cursor.getString(1));
        employee.setFirstName(cursor.getString(2));
        employee.setGender(cursor.getString(3));
        employee.setJob(cursor.getString(4));
        employee.setService(cursor.getString(5));
        employee.setEmail(cursor.getString(6));
        employee.setPhone(cursor.getString(7));
        employee.setCV(cursor.getString(8));
        cursor.close();

        return employee;
    }

    public synchronized void delete(Employee employee) {
        // Adding clause "where id = []"
        String clause = COL_ID + CLAUSE;
        String[] clauseArgs = new String[] {employee.getId().toString()};
        // Processing delete request
        employeeDataSource.getDB().delete(TABLE_NAME,clause,clauseArgs);
    }
}
