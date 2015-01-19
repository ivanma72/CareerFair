package com.example.david.careerfairapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class CompanyActivity extends ActionBarActivity {

    TextView companyName;
    TextView description;
    TextView majorTitle;
    TextView majorTxt;
    TextView dateTitle;
    TextView dateTxt;
    TextView industryTitle;
    TextView industryTxt;
    TextView websiteTitle;
    TextView websiteTxt;
    TextView receptionsTitle;
    TextView receptionsTxt;
    TextView locationTitle;
    TextView locationTxt;
    ImageView map;

    company targetCompany;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        companyName = (TextView)findViewById(R.id.Company);
        description = (TextView)findViewById(R.id.description);
        majorTitle = (TextView)findViewById(R.id.majorTl);
        majorTxt = (TextView)findViewById(R.id.majorTxt);
        dateTitle = (TextView)findViewById(R.id.DateTl);
        dateTxt = (TextView)findViewById(R.id.dateTxt);
        industryTitle = (TextView)findViewById(R.id.industryTl);
        industryTxt = (TextView)findViewById(R.id.industryTxt);
        websiteTitle = (TextView)findViewById(R.id.websiteTl);
        websiteTxt = (TextView)findViewById(R.id.websiteTxt);
        map = (ImageView)findViewById(R.id.mapImg);
        receptionsTitle = (TextView)findViewById(R.id.receptionsTl);
        receptionsTxt = (TextView) findViewById(R.id.receptionsTxt);
        locationTitle = (TextView)findViewById(R.id.locationTl);
        locationTxt = (TextView)findViewById(R.id.locationTxt);

        Intent intent = this.getIntent();
        targetCompany = (company)intent.getSerializableExtra("companyObj");

        populateCompany();
    }

    private void populateCompany(){
        companyName.setText(targetCompany.name);
        description.setText(targetCompany.description);

        majorTitle.setText("Majors recruiting");
        String majorStr = "";
        if (targetCompany.majors.size() == 0){
            majorStr = "Company did not provide information on majors recruiting";
        }
        else {
            for (int i = 0; i < targetCompany.majors.size(); i++) {
                majorStr = majorStr + targetCompany.majors.get(i);
                if (i != targetCompany.majors.size() - 1) {
                    majorStr = majorStr + ", ";
                }
            }
        }
        majorTxt.setText(majorStr);

        dateTitle.setText("Date Present");
        if (!targetCompany.date) {
            dateTxt.setText("Day One");
        }
        else dateTxt.setText("Day Two");

        industryTitle.setText("Industry");
        industryTxt.setText(targetCompany.industry);

        websiteTitle.setText("Website");
        websiteTxt.setLinksClickable(true);
        websiteTxt.setText(targetCompany.website);

        //deal with authorizations
        //deal with positions

        receptionsTitle.setText("Receptions");
        if (targetCompany.receptions) {
            receptionsTxt.setText("Yes");
        }
        else receptionsTxt.setText("No");

        locationTitle.setText("Where can you find us?");
        locationTxt.setText(targetCompany.building);
        //proof of concept
        map.setImageResource(R.drawable.bookswaplocation);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_company, menu);
        return true;
    }

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
