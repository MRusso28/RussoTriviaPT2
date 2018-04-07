package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by markrusso on 3/5/18.
 * Assignment 3 Part 2
 * SER210
 * implements FavsListFragment which is a ListFragment
 */

public class FaavoritesActivity extends AppCompatActivity implements FavsListFragment.FavsListListener {
    private ListView myListView;
    private ShareActionProvider shareActionProvider;
    private SQLiteFavorites myDB;
    private FragmentTransaction fragTransaction;
    private FragmentManager fragManager;
    private LinearLayout linear;
    SQLiteFavorites myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(SettingsActivity.theme_color);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faavorites);
        myListView = (ListView) findViewById(R.id.list_fav);
        myDatabaseHelper = new SQLiteFavorites(this);

        //add fragment list to favorites
        myDB = new SQLiteFavorites(this);
        fragManager = getFragmentManager();
        fragTransaction = fragManager.beginTransaction();
        fragTransaction.add(R.id.favfragc, new FavsListFragment());
        fragTransaction.commit();
        linear = (LinearLayout) findViewById(R.id.favorites_layout);
        Button deleteBtn = (Button) findViewById(R.id.btn_delete);
        Button deleteBtnAll = (Button) findViewById(R.id.btn_deleteAll);

        //used to delete items in the data base
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseHelper.deletAll();
                myDatabaseHelper.popList();
                recreate();
            }
        });

        //used to delete items in the data base
        deleteBtnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseHelper.deletAll();
                myDatabaseHelper.popList();
                recreate();
            }
        });
    }

    //move favorites to a new activity with details when item seledcted
    public void itemClickedMoveToDetail(int position) {
        Intent intent = new Intent(FaavoritesActivity.this, FavoriteDetailActivity.class);
        startActivity(intent);

    }

    //used to create tool bar options
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
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_display_fav:
                Intent intent2 = new Intent(this, FaavoritesActivity.class);
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