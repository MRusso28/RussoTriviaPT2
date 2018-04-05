package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Comment;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;

/**
 * Created by markrusso on 3/5/18.
 * Assignment 3 Part 2
 * SER210
 * this class displays a listview of favorites
 * implements FavsListFragment which is a ListFragment
 *
 */

public class FaavoritesActivity extends AppCompatActivity implements FavsListFragment.CountryListListener {
    private static final String TAG = "ListDataActivity";
    SQLiteFavorites mDatabaseHelper;
    private ListView mListView;
    private String selectedID;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(ThemeActivity.theme_color);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faavorites);
        mListView = (ListView) findViewById(R.id.list_fav);
        mDatabaseHelper = new SQLiteFavorites(this);
        populateListView();

//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mDatabaseHelper.deleteName(selectedID);
//                toastMessage("removed from database");
//            }
//        });

    }

    public void itemClickedMoveToDetail(int position) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //ft.replace(R.id.fragment_container);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    //populates the list view
    public void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get value from the database in col 1
            //then add TO ArrayList
            listData.add(data.getString(1));
        }

        //creates list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getItemID(name); //get the id associated with that name
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }

            }
        });
    }

    /**
     * customizable Toasty
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        //  setIntent("");
        return super.onCreateOptionsMenu(menu);
    }

    //switches action bar item when selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, ThemeActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_display_fav:
                Intent intent2 = new Intent(this, FaavoritesActivity.class );
                startActivity(intent2);
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_changeQ:
                return true;
            case R.id.action_delete:
                default:
                return super.onOptionsItemSelected(item);
        }
    }
}