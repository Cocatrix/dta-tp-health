package fr.codevallee.formation.health.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

import fr.codevallee.formation.health.databases.Employee;
import fr.codevallee.formation.health.databases.EmployeeDataSource;
import fr.codevallee.formation.health.fragments.EmployeePagerFragment;

/**
 * @author Maxime REVEL
 * @date 20/10/2017
 */

public class EmployeePagerAdapter extends FragmentPagerAdapter {
    /**
     * Custom adapter for a pager.
     */
    private EmployeeDataSource employeeDataSource;

    public EmployeePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        Log.d("ACTION","Creating new PagerAdapter");
        this.employeeDataSource = EmployeeDataSource.getDS(context);
    }

    @Override
    public Fragment getItem(int position) {
        List<Employee> employees = this.employeeDataSource.getEmployeeDAO().readAll();
        Log.d("ACTION","Getting item in PagerAdapter, with new Instance of EmpPagerFragment");
        return EmployeePagerFragment.newInstance(employees.get(position));
    }

    @Override
    public int getCount() {
        List<Employee> employees = this.employeeDataSource.getEmployeeDAO().readAll();
        return employees.size();
    }
}
