package fr.codevallee.formation.health.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import fr.codevallee.formation.health.R;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class SplashActivity extends AppCompatActivity {
    /**
     * First called activity, empty for now, so does intent to next activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Does nothing for now, goes to next screen
         * TODO - Put UX on this screen
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d("ACTION","Move from Splash to listEmployees");
        Intent intent = new Intent(this,ListEmployeesActivity.class);
        startActivity(intent);
    }
}
