package fr.codevallee.formation.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CreateEmployeeActivity extends AppCompatActivity {
    // TODO - Check if getApplicationContext works here
    private EmployeeDataSource employeeDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_modify_employee);
        employeeDataSource = new EmployeeDataSource(getApplicationContext());

        // TODO - Get these jobs from DB
        List<String> listJobs = new ArrayList<String>();
        listJobs.add("Médecin");
        listJobs.add("Infirmier");

        // We need an ArrayAdapter to fill the list of possible autocompletions
        final ArrayAdapter<String> autoCompletionAdapter = new ArrayAdapter<String>(
                CreateEmployeeActivity.this, android.R.layout.simple_list_item_1,listJobs);
        AutoCompleteTextView jobsUI = (AutoCompleteTextView) findViewById(R.id.job_auto_complete);
        jobsUI.setAdapter(autoCompletionAdapter);

        Intent receivedIntent = getIntent();
        if (receivedIntent.getStringExtra("modify") != null) {
            this.setModifyScreenEmployee(receivedIntent);
        }
    }

    private void setModifyScreenEmployee(Intent receivedIntent) {
        // TODO - copy createEmployee field getters, and put intent values in it
    }

    private void modifyEmployee() {
        // TODO - copy createEmployee field getters, and launch update query
    }

    protected void createEmployee(View view) {
        /**
         * Affected to button "create_button".
         * Get the fields, put them in Strings, and launch the query.
         * Check phone number...
         */
        Log.d("ACTION","Clicked on " + view.getTransitionName());
        EditText family_nameUI = (EditText) findViewById(R.id.family_name_text);
        EditText first_nameUI = (EditText) findViewById(R.id.first_name_text);
        RadioGroup genderRadioGroupUI = (RadioGroup) findViewById(R.id.gender_radio_group);
        // Method getCheckedRadioButton of RadioGroup gives us the button's id
        // With the id, we use findViewById the same way to find the button
        RadioButton genderRadioUI = (RadioButton) findViewById(
                genderRadioGroupUI.getCheckedRadioButtonId());
        AutoCompleteTextView jobUI = (AutoCompleteTextView) findViewById(R.id.job_auto_complete);
        Spinner serviceUI = (Spinner) findViewById(R.id.service_spinner);
        EditText emailUI = (EditText) findViewById(R.id.email_text);
        EditText phoneUI = (EditText) findViewById(R.id.phone_text);
        EditText cvUI = (EditText) findViewById(R.id.cv_text);

        String family_name = family_nameUI.getText().toString();
        String first_name = first_nameUI.getText().toString();
        String gender = genderRadioUI.getText().toString();
        String job = jobUI.getText().toString();
        String service = serviceUI.getSelectedItem().toString();
        String email = emailUI.getText().toString();
        String phone = phoneUI.getText().toString();
        String cv = cvUI.getText().toString();

        Log.d("VALUES","family_name : " + family_name);
        Log.d("VALUES","first_name : " + first_name);
        Log.d("VALUES","gender : " + gender);
        Log.d("VALUES","job : " + job);
        Log.d("VALUES","service : " + service);
        Log.d("VALUES","email : " + email);
        Log.d("VALUES","phone : " + phone);
        Log.d("VALUES","cv : " + cv);

        // TODO - Checkings on fields' correctness

        // TODO - Launch create query
    }
}
