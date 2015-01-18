package com.example.david.careerfairapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Homepage extends ActionBarActivity {
    Button companyListBtn;
    Button announcementBtn;
    Button settingsBtn;
    Button favoriteBtn;
    Button calenderBtn;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        companyListBtn = (Button) findViewById(R.id.companyListBtn);
        announcementBtn = (Button) findViewById(R.id.announcementBtn);
        settingsBtn = (Button) findViewById(R.id.settingsbtn);
        favoriteBtn = (Button) findViewById(R.id.favouriteBtn);
        calenderBtn = (Button) findViewById(R.id.calanderBtn);

        companyListBtn.setOnClickListener(btnHandler);
        announcementBtn.setOnClickListener(btnHandler);
        settingsBtn.setOnClickListener(btnHandler);
        favoriteBtn.setOnClickListener(btnHandler);
        calenderBtn.setOnClickListener(btnHandler);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_homepage, menu);
        return true;
    }

    View.OnClickListener btnHandler = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "button pressed", Toast.LENGTH_SHORT).show();

            if (v == companyListBtn) {
                startActivity(new Intent(context, MainPage.class));
            } else if (v == announcementBtn) {
                //
            } else if (v == settingsBtn) {
                //
            } else if (v == favoriteBtn) {
                //
            } else if (v == calenderBtn) {
                //
            }
        }
    };
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
