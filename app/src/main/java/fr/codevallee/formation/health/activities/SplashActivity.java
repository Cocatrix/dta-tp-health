package fr.codevallee.formation.health.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.codevallee.formation.health.R;
import fr.codevallee.formation.health.activities.CreateOrModifyEmployeeActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Does nothing for now, goes to next screen
         * TODO - Put UX on this screen
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent(this,ListEmployeesActivity.class);
        startActivity(intent);
    }
}
