package fr.codevallee.formation.health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateEmployeeActivity extends AppCompatActivity {
    // TODO - Check if getApplicationContext works here
    private final EmployeeDataSource employeeDataSource = new EmployeeDataSource(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_modify_employee);


    }
}
