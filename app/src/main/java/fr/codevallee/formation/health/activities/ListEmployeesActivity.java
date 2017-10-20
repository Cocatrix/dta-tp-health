package fr.codevallee.formation.health.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.codevallee.formation.health.R;

public class ListEmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employees);

        FloatingActionButton plus_button = (FloatingActionButton)
                findViewById(R.id.add_employee_fab);
        plus_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListEmployeesActivity.this,
                        CreateOrModifyEmployeeActivity.class);
                startActivity(intent);
            }
        });

    }
}
