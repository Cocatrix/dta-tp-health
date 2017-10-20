package fr.codevallee.formation.health.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.codevallee.formation.health.R;
import fr.codevallee.formation.health.adapters.EmployeePagerAdapter;
import fr.codevallee.formation.health.listeners.ViewPagerOnPageChangeListener;

/**
 * @author Maxime REVEL
 * @date 20/10/2017
 */

public class EmployeeFragment extends Fragment {
    public final static String ARG_POSITION = "position";
    private int currentPosition = -1;
    private ViewPager pager;
    private ListEmployeesFragment employeeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        View view = inflater.inflate(R.layout.fragment_employee, container, false);
        pager = (ViewPager) view.findViewById(R.id.viewPager);
        pager.setAdapter(new EmployeePagerAdapter(getChildFragmentManager(),getContext()));
        pager.setCurrentItem(currentPosition);

        employeeList = (ListEmployeesFragment) getFragmentManager().findFragmentById(R.id.fragListEmployees);

        pager.addOnPageChangeListener(new ViewPagerOnPageChangeListener(employeeList));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        pager.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (currentPosition != -1) {
            updateArticleView(currentPosition);
        }
    }

    public void updateArticleView(int position) {
        if (pager != null) {
            pager.setCurrentItem(position);
            currentPosition = position;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, currentPosition);
    }

    public ViewPager getPager() {
        return pager;
    }
}
