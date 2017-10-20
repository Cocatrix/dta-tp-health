package fr.codevallee.formation.health.adapters;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.codevallee.formation.health.R;
import fr.codevallee.formation.health.databases.Employee;
import fr.codevallee.formation.health.databases.EmployeeDataSource;
import fr.codevallee.formation.health.fragments.EmployeeFragment;
import fr.codevallee.formation.health.fragments.ListEmployeesFragment;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class EmployeesRecyclerViewAdapter extends RecyclerView.Adapter<
        EmployeesRecyclerViewAdapter.ViewHolder> {
    private int selectedItem;
    private ListEmployeesFragment listEmployeesFragment;
    private EmployeeDataSource employeeDataSource;


    public EmployeesRecyclerViewAdapter(ListEmployeesFragment listEmployeesFragment,
                                        Context context) {
        this.listEmployeesFragment = listEmployeesFragment;
        employeeDataSource = EmployeeDataSource.getDS(context);
    }

    public void setSelectedItem(int selectedItem) {
        notifyItemChanged(this.selectedItem);
        this.selectedItem = selectedItem;
        notifyItemChanged(this.selectedItem);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.textView = (TextView) itemView.findViewById(R.id.employeeName);
        }
        @Override
        public String toString(){
            return super.toString() + " '" + this.textView.getText() + "'";
        }
    }

    @Override
    public EmployeesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.employee_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeesRecyclerViewAdapter.ViewHolder holder,
                                 final int position) {
        List<Employee> employees = this.employeeDataSource.getEmployeeDAO().readAll();
        String name = employees.get(position).getFirstName() + " "
                + employees.get(position).getFamilyName();
        holder.textView.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmployeeFragment articleFrag = (EmployeeFragment)
                        listEmployeesFragment.getFragmentManager().findFragmentById(R.id.fragPagerEmployee);

                if (articleFrag != null) {
                    articleFrag.updateArticleView(position);

                } else {
                    EmployeeFragment newFragment = new EmployeeFragment();
                    Bundle args = new Bundle();
                    args.putInt(EmployeeFragment.ARG_POSITION, position);
                    newFragment.setArguments(args);
                    FragmentTransaction transaction = listEmployeesFragment.getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frag_container, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

                setSelectedItem(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.employeeDataSource.getEmployeeDAO().readAll().size();
    }
}
/*
    private UsersListFragment usersListFragment;

    public RecyclerViewAdapter(UsersListFragment usersListFragment) {
        this.usersListFragment = usersListFragment;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {

        holder.mContentView.setText(DataBase.users.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserFragment articleFrag = (UserFragment)
                        usersListFragment.getFragmentManager().findFragmentById(R.id.article_fragment);

                if (articleFrag != null) {
                    articleFrag.updateArticleView(position);

                } else {
                    UserFragment newFragment = new UserFragment();
                    Bundle args = new Bundle();
                    args.putInt(UserFragment.ARG_POSITION, position);
                    newFragment.setArguments(args);
                    FragmentTransaction transaction = usersListFragment.getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

                setSelectedItem(position);
            }
        });

        holder.mView.setTag(holder);
        // Gestion de la surbrillance.
        holder.itemView.setSelected(position == selectedItem);
        if (selectedItem == position) {
            holder.itemView.setBackgroundColor(Color.GREEN);
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }

    }

}*/
