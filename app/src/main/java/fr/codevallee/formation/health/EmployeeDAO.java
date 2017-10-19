package fr.codevallee.formation.health;

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
}
