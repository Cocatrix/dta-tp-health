package fr.codevallee.formation.health;

import android.content.ContentValues;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

class EmployeeDAO {
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

    // TODO - public synchronized [CRUD]

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
        // TODO
        return employee;
    }
}
