package fr.codevallee.formation.health.listeners;

import android.support.v4.view.ViewPager;

import fr.codevallee.formation.health.adapters.EmployeesRecyclerViewAdapter;
import fr.codevallee.formation.health.fragments.ListEmployeesFragment;

/**
 * @author Maxime REVEL
 * @date 20/10/2017
 */

public class ViewPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {
    ListEmployeesFragment listEmployeesFragment;

    public ViewPagerOnPageChangeListener(ListEmployeesFragment employeeList) {
        this.listEmployeesFragment = employeeList;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (listEmployeesFragment != null)
            ((EmployeesRecyclerViewAdapter) listEmployeesFragment.getAdapter()).setSelectedItem(position);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
