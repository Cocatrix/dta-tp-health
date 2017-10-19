package fr.codevallee.formation.health;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CreateEmployeeActivity extends AppCompatActivity {
    // TODO - Check if getApplicationContext works here
    private EmployeeDataSource employeeDataSource;

    private static final String COL_FAMILY_NAME = "family_name";
    private static final String COL_FIRST_NAME = "first_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_JOB = "job";
    private static final String COL_SERVICE = "service";
    private static final String COL_EMAIL = "email";
    private static final String COL_PHONE = "phone";
    private static final String COL_CV = "cv";

    private EditText family_nameUI;
    private EditText first_nameUI;
    private RadioGroup genderRadioGroupUI;
    private AutoCompleteTextView jobUI;
    private Spinner serviceUI;
    private EditText emailUI;
    private EditText phoneUI;
    private EditText cvUI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_modify_employee);
        employeeDataSource = new EmployeeDataSource(getApplicationContext());

        // Set views in private fields (because they are used in several methods)
        this.family_nameUI = (EditText) findViewById(R.id.family_name_text);
        this.first_nameUI = (EditText) findViewById(R.id.first_name_text);
        this.genderRadioGroupUI = (RadioGroup) findViewById(R.id.gender_radio_group);
        this.jobUI = (AutoCompleteTextView) findViewById(R.id.job_auto_complete);
        this.serviceUI = (Spinner) findViewById(R.id.service_spinner);
        this.emailUI = (EditText) findViewById(R.id.email_text);
        this.phoneUI = (EditText) findViewById(R.id.phone_text);
        this.cvUI = (EditText) findViewById(R.id.cv_text);

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
            this.setModifyScreenEmployee(receivedIntent); // Adapt the view for modification
        }
    }

    private void setModifyScreenEmployee(Intent receivedIntent) {
        /**
         * Hides create_button and shows modify_button.
         * Set Views to display current fields of user.
         */
        Button createButton = (Button) findViewById(R.id.create_button);
        Button modifyButton = (Button) findViewById(R.id.modify_button);
        createButton.setVisibility(View.GONE);
        modifyButton.setVisibility(View.VISIBLE);
        // TODO - copy createEmployee field getters, and put intent values in it
        Employee employee = receivedIntent.getParcelableExtra("Employee");
        this.family_nameUI.setText(employee.getFamilyName());
        this.first_nameUI.setText(employee.getFirstName());

        // Set the right button for gender
        Button genderButton1 = (Button) findViewById(R.id.radio_female);
        Button genderButton2 = (Button) findViewById(R.id.radio_male);
        Button genderButton3 = (Button) findViewById(R.id.radio_other);
        Button[] genderButtons = {genderButton1,genderButton2,genderButton3};
        for (Button b : genderButtons) {
            if (b.getText().toString().equals(employee.getGender())) {
                b.setActivated(true);
            } else {
                b.setActivated(false);
            }
        }

        this.jobUI.setText(employee.getJob());
        // TODO - Set which choice of spinner is by default // this.serviceUI.
        this.emailUI.setText(employee.getEmail());
        this.phoneUI.setText(employee.getPhone());
        this.cvUI.setText(employee.getCV());

    }

    private void modifyEmployee(View view) {
        /**
         * Affected to button "modify_button".
         * Get the fields, put them in Strings, and launch the update query.
         * Check phone number...
         */
        Log.d("ACTION","Clicked on " + view.getTag());

        ContentValues values = this.getFieldValues();
        Employee newEmployee = new Employee(null,
                values.getAsString(COL_FAMILY_NAME),
                values.getAsString(COL_FIRST_NAME),
                values.getAsString(COL_GENDER),
                values.getAsString(COL_JOB),
                values.getAsString(COL_SERVICE),
                values.getAsString(COL_EMAIL),
                values.getAsString(COL_PHONE),
                values.getAsString(COL_CV));
        this.employeeDataSource.getEmployeeDAO().update(newEmployee);
    }

    protected void createEmployee(View view) {
        /**
         * Affected to button "create_button".
         * Get the fields, put them in Strings, and launch the create query.
         * Check phone number...
         */
        Log.d("ACTION","Clicked on " + view.getTag());

        ContentValues values = this.getFieldValues();

        Employee newEmployee = new Employee(null,
                values.getAsString(COL_FAMILY_NAME),
                values.getAsString(COL_FIRST_NAME),
                values.getAsString(COL_GENDER),
                values.getAsString(COL_JOB),
                values.getAsString(COL_SERVICE),
                values.getAsString(COL_EMAIL),
                values.getAsString(COL_PHONE),
                values.getAsString(COL_CV));
        this.employeeDataSource.getEmployeeDAO().create(newEmployee);
    }

    protected ContentValues getFieldValues() {
        /**
         * Returns an array of the field values.
         * Useful because these values are needed in several methods.
         */

        RadioButton genderRadioUI = (RadioButton) findViewById(
                genderRadioGroupUI.getCheckedRadioButtonId());
        // Method getCheckedRadioButton of RadioGroup gives us the button's id
        // With the id, we use findViewById the same way to find the button

        String family_name = this.family_nameUI.getText().toString();
        String first_name = this.first_nameUI.getText().toString();
        String gender = genderRadioUI.getText().toString();
        String job = this.jobUI.getText().toString();
        String service = this.serviceUI.getSelectedItem().toString();
        String email = this.emailUI.getText().toString();
        String phone = this.phoneUI.getText().toString();
        String cv = this.cvUI.getText().toString();

        Log.d("VALUES",COL_FAMILY_NAME + " : " + family_name);
        Log.d("VALUES",COL_FIRST_NAME + " : " + first_name);
        Log.d("VALUES",COL_GENDER + " : " + gender);
        Log.d("VALUES",COL_JOB + " : " + job);
        Log.d("VALUES",COL_SERVICE + " : " + service);
        Log.d("VALUES",COL_EMAIL + " : " + email);
        Log.d("VALUES",COL_PHONE + " : " + phone);
        Log.d("VALUES",COL_CV + " : " + cv);

        ContentValues values = new ContentValues();
        values.put(COL_FAMILY_NAME, family_name);
        values.put(COL_FIRST_NAME, first_name);
        values.put(COL_GENDER, gender);
        values.put(COL_JOB, job);
        values.put(COL_SERVICE, service);
        values.put(COL_EMAIL, email);
        values.put(COL_PHONE, phone);
        values.put(COL_CV, cv);

        // TODO - Checkings on fields' correctness

        return values;
    }
}
