package fr.codevallee.formation.health;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.codevallee.formation.health.databases.Employee;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class EmployeesRecyclerViewAdapter extends RecyclerView.Adapter<
        EmployeesRecyclerViewAdapter.ViewHolder> {
    private List<Employee> employees;

    public EmployeesRecyclerViewAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.employeeName);
        }
    }

    @Override
    public EmployeesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.employee_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = this.employees.get(position).getFirstName() + " "
                + this.employees.get(position).getFamilyName();
        holder.textView.setText(name);
    }

    @Override
    public int getItemCount() {
        return this.employees.size();
    }
}
