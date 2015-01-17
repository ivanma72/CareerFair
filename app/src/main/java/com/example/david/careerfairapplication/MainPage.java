package com.example.david.careerfairapplication;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

class company {
    String name;
    String description;
    String industry;//enum?
    String website;
    boolean date;
    Vector<String> majors;//enum?
    String authorization;//enum?
    String positions;//enum?
    String Locations;//enum?
    boolean receptions;

    public company(String _name, String _description, String _industry, String _website,
                   boolean _date, Vector<String> _majors, String _authorization, String _positions,
                   String _locations, boolean _receptions) {
        name = _name;
        description = _description;
        industry = _industry;
        website = _website;
        date = _date;
        majors = _majors;
        authorization = _authorization;
        positions = _positions;
        Locations = _locations;
        receptions = _receptions;
    }

    @Override public String toString(){
        return name;
    }

}

public class MainPage extends ActionBarActivity {
    ListView masterList;
    ArrayList<company> companyArrayList;
    ArrayAdapter<company> aa;

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        context = this;
        masterList = (ListView)findViewById(R.id.companyList);

        companyArrayList = new ArrayList<company>();

        aa = new ArrayAdapter<company>(this,android.R.layout.simple_list_item_1,companyArrayList);
        masterList.setAdapter(aa);
        masterList.setOnItemClickListener(new ListClickHandler());

        Vector<String> emptyvec = new Vector<String>();
        company newComp = new company("GE","This is a shit company","bat poop", "www.GE.com",true,emptyvec,"good","intern","northeast",true);
        companyArrayList.add(newComp);
        aa.notifyDataSetChanged();

    }

    private class ListClickHandler implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> Adapter, View view, int position, long arg3) {
            Toast.makeText(getApplicationContext(), companyArrayList.get(position).name, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        MenuItem item;
        item = menu.add("Sort by");
        item = menu.add("Refine");
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
