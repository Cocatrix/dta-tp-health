package fr.codevallee.formation.health.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.codevallee.formation.health.adapters.EmployeesRecyclerViewAdapter;
import fr.codevallee.formation.health.R;
import fr.codevallee.formation.health.databases.Employee;
import fr.codevallee.formation.health.databases.EmployeeDataSource;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class ListEmployeesFragment extends Fragment {
    /**
     * This class is a fragment managing the RecyclerView that displays employee's cards.
     * Adds a LayoutManager to the RecyclerView, and a custom adapter.
     */

    private List<Employee> employees;
    private EmployeeDataSource employeeDataSource;

    private RecyclerView employeesRecyclerView;
    private RecyclerView.Adapter eRVAdapter;
    private RecyclerView.LayoutManager eRVLayoutManager;

    public ListEmployeesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("ACTION","Create fragment of employees' list");
        employeeDataSource = EmployeeDataSource.getDS(this.getContext());
        View view = inflater.inflate(R.layout.fragment_list_employees, container, false);

        this.employeesRecyclerView = view.findViewById(R.id.employees_recycler_view);
        this.eRVLayoutManager = new LinearLayoutManager(view.getContext());
        Log.d("ACTION","Add LayoutManager to fragment of employees' list");
        this.employeesRecyclerView.setLayoutManager(eRVLayoutManager);

        this.employees = employeeDataSource.getEmployeeDAO().readAll();
        Log.d("VALUE", "Employees length : " + this.employees.size());

        this.eRVAdapter = new EmployeesRecyclerViewAdapter(this,getContext());
        Log.d("ACTION","Add custom adapter for fragment of employees' list");
        this.employeesRecyclerView.setAdapter(this.eRVAdapter);

        return view;
    }

    public RecyclerView.Adapter getAdapter() {
        return eRVAdapter;
    }
}
