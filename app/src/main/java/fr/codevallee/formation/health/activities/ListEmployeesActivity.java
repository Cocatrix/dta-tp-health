package fr.codevallee.formation.health.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import fr.codevallee.formation.health.R;
import fr.codevallee.formation.health.fragments.ListEmployeesFragment;

/**
 * @author Maxime REVEL
 * @date 20/10/2017
 */

public class ListEmployeesActivity extends AppCompatActivity {
    /**
     * This activity has 2 layouts for large or small screens.
     * Contains a RecyclerView and a Pager.
     * On small :
     *      RecyclerView displaying employee's cards.
     *      Clicking on one displays his/her details,
     *      and pager allows to swype to next/previous employees.
     * On large :
     *      RecyclerView displaying employee's cards, and on the right panel,
     *      are displays current selected employee's details. Swyping works too.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employees);
        Log.d("ACTION","Add FAB in listEmployees");
        FloatingActionButton plus_button = (FloatingActionButton)
                findViewById(R.id.add_employee_fab);
        plus_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ListEmployeesActivity.this,
                        CreateOrModifyEmployeeActivity.class);
                startActivity(intent);
            }
        });
        if (findViewById(R.id.frag_container) != null) {
            // We are on small screen
            if (savedInstanceState != null) {
                Log.d("STATE","Previous existing state");
                return;
            }

            Log.d("ACTION","listEmployees, set frag_container on small screen");
            ListEmployeesFragment employeeList = new ListEmployeesFragment();
            employeeList.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.frag_container, employeeList).commit();
        }

    }
}
