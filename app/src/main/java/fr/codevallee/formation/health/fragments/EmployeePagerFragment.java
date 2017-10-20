package fr.codevallee.formation.health.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import fr.codevallee.formation.health.R;
import fr.codevallee.formation.health.databases.Employee;

/**
 * @author Maxime REVEL
 * @date 20/10/2017
 */

public class EmployeePagerFragment extends Fragment {
    private static final String PARCEL_EMPLOYEE_TAG = "pagerEmployee";

    public static EmployeePagerFragment newInstance(Employee employee) {
        EmployeePagerFragment frag = new EmployeePagerFragment();
        Bundle bundle = new Bundle();
        assert employee != null;
        bundle.putParcelable(PARCEL_EMPLOYEE_TAG,employee);
        Log.d("ACTION","************************************");
        Log.d("ACTION","Put employee in Bundle : " + employee.toString());
        Log.d("ACTION","************************************");
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("ACTION","************************************");
        Log.d("ACTION","Creating employeePagerFragment in UI");
        Log.d("ACTION","************************************");
        View view = inflater.inflate(R.layout.fragment_pager_employee, container, false);
        // Need to check if users exist in the database
        /*
        if (EmployeeDataSource.getDS(getContext()).getEmployeeDAO().readAll().size() == 0) {
            Log.d("STATE","No need for showing, no user yet.");
            return view;
        }*/
        if (getArguments() != null) {
            Employee employee = getArguments().getParcelable(PARCEL_EMPLOYEE_TAG);
            // Set the right button for gender
            Button genderButton1 = view.findViewById(R.id.radio_female_view);
            Button genderButton2 = view.findViewById(R.id.radio_male_view);
            Button genderButton3 = view.findViewById(R.id.radio_other_view);
            Button[] genderButtons = {genderButton1, genderButton2, genderButton3};
            for (Button b : genderButtons) {
                b.setVisibility(View.VISIBLE);
                if (b.getText().toString().equals(employee.getGender())) {
                    b.setActivated(true);
                } else {
                    b.setActivated(false);
                    // b.setEnabled(false);
                }
            }

            // Set the spinner
            // TODO - Test
            Spinner serviceSpinner = view.findViewById(R.id.service_spinner_view);
            serviceSpinner.setVisibility(View.VISIBLE);
            serviceSpinner.setPrompt(employee.getService().toString());

            // Get all the text fields
            TextView family_name_tv = view.findViewById(R.id.family_name_textview);
            TextView first_name_tv = view.findViewById(R.id.first_name_textview);
            TextView job_tv = view.findViewById(R.id.job_textview);
            TextView email_tv = view.findViewById(R.id.email_textview);
            TextView phone_tv = view.findViewById(R.id.phone_textview);
            TextView cv_tv = view.findViewById(R.id.cv_textview);
            // Fill these fields
            family_name_tv.setText(employee.getFamilyName());
            first_name_tv.setText(employee.getFirstName());
            job_tv.setText(employee.getJob());
            email_tv.setText(employee.getEmail());
            phone_tv.setText(employee.getPhone());
            cv_tv.setText(employee.getCV());

            // Show the button
            Button backButton = view.findViewById(R.id.pager_back_button);
            backButton.setVisibility(View.VISIBLE);
        }
        return view;
    }
}
