package com.example.david.careerfairapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import java.util.Collections;
import java.util.Comparator;
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



public class MainPage extends ActionBarActivity implements DialogInterface.OnClickListener {
    ListView visibleList;
    ArrayList<company> masterList;
    ArrayList<company> curList;
    ArrayAdapter<company> aa;
    String[] sortingTypes = {"Alphabetically", "By Day"};
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        context = this;
        visibleList = (ListView) findViewById(R.id.companyList);

        masterList = new ArrayList<company>();

        aa = new ArrayAdapter<company>(this, android.R.layout.simple_list_item_1, masterList);
        visibleList.setAdapter(aa);
        visibleList.setOnItemClickListener(new ListClickHandler());
        populateList();

    }
	private void populateList(){
        Vector<String> emptyvec = new Vector<String>();

        company newComp = new company("GE", "This is a shit company", "bat poop", "www.GE.com", true, emptyvec, "good", "intern", "northeast", true);
	    masterList.add(newComp);
        newComp = new company("EPIC", "This is an epic company", "merr", "www.EPIC.com", false, emptyvec, "ehhh", "intern", "west", false);
        masterList.add(newComp);
        newComp = new company("Dell", "This is an famous company", "bat shit", "www.DELL.com", true, emptyvec, "ehhh", "Full Time", "south", false);
        masterList.add(newComp);
        newComp = new company("Eli Lilly", "This is an good company", "dog shit", "www.ELILILLY.com", false, emptyvec, "ehhh", "Full Time", "north", true);
        masterList.add(newComp);
        aa.notifyDataSetChanged();
	}
    private class ListClickHandler implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> Adapter, View view, int position, long arg3) {
            Toast.makeText(getApplicationContext(), masterList.get(position).name, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);

        MenuItem item;
        item = menu.add("Sort by");
        item = menu.add("Refine");
        return true;
    }

    private void displayPopup(String title, String[] items) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setItems(items, this);
        builder.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        this.displayPopup("Sort By", sortingTypes);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(DialogInterface dialog, int item) {
        if (item == 0) {
            Collections.sort(curList,   new  Comparator<company>() {
                public int compare(company a, company b) {
                    return a.name.compareTo(b.name);
                }
            });
        }
        else if (item == 1){
            Collections.sort(curList, new Comparator<company>() {
                @Override
                public int compare(company a, company b) {
                    Integer a_date = (a.date) ? 1 : 0;
                    Integer b_date = (b.date) ? 1 : 0;
                    return a_date.compareTo(b_date);
                }
            });
        }
    }

    public void search (String input) {
        curList.clear();
        for(int i = 0; i < masterList.size(); i++) {
            if (masterList.get(i).equals(input)) {
                curList.add(masterList.get(i));
            }
        }
        if (curList.isEmpty()) {
            Toast.makeText(getApplicationContext(), "No results found :(", Toast.LENGTH_SHORT).show();
        }
    }
}
