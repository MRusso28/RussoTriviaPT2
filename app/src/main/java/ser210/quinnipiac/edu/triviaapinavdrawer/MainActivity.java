package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.ShareActionProvider;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * The main activity of Russos Trivia
 * Updated April 6, 2018
 * @author markrusso
 * SER210
 */

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int currentPostion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(ThemeActivity.theme_color);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OptionsFragment frag = (OptionsFragment) getFragmentManager().findFragmentById(R.id.options_frag);


    }

    //play button sends user to trivia
    public void onClickPlay(View view) {
        Intent intent = new Intent(this, TriviaActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.action_create_order:
                finish();
                Intent intent = new Intent(this, ThemeActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_share:
                setIntent(" ");
                return true;
            case R.id.action_display_fav:
               Intent intent2 = new Intent(this, FaavoritesActivity.class );
               startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //shows credits
    public void onClickInfo(View view) {
        android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(this);

        alert.setMessage(R.string.Welcome);
        alert.setTitle("Info");
        alert.setCancelable(true);
        alert.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        alert.show();
    }

    //how to play with answers
    public void HowtoPlay(View view) {
        android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(this);
        alert.setMessage(R.string.HowTo);
        alert.setTitle("Welcome!!");
        alert.setCancelable(true);
        alert.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        alert.show();

    }

    //exits the application
    public void onClickExit(View view) {
       System.exit(1);
    }

    public void setIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
//        shareActionProvider.setShareIntent(intent);
        startActivity(intent);
    }
}
