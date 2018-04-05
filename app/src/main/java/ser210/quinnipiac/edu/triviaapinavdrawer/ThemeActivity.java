package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * CREATED BY MARK RUSSO
 * this class is the theme of the trivia game
 * fonts and toolbar colors are set here
 */
public class ThemeActivity extends AppCompatActivity {
    public static int theme_color = R.style.AppTheme;
    public static String font_type;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        final Toolbar myToolbar;
        setTheme(theme_color);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        Button btn1 = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btnFont = (Button) findViewById(R.id.buttonFont);
        Button btnFont2 = (Button) findViewById(R.id.button2Font);
        Button btnFont3 = (Button) findViewById(R.id.button3Font);
        Button back = (Button) findViewById(R.id.back);
        final TextView settings = (TextView) findViewById(R.id.settings_text);
        final TextView question = (TextView) findViewById(R.id.question);
        font_type = ("default.ttf");



        //all on click methods for each theme button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme_color = R.style.AppThemeNew;
                recreate();
                Toast.makeText(ThemeActivity.this, "Theme Changed!!", Toast.LENGTH_LONG).show();

                //myToolbar.setBackgroundColor(Color.YELLOW);
               // myToolbar.getResources().getColor(R.color.colorBlack);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme_color = R.style.AppThemeNew2;
                recreate();
                //myToolbar.setBackgroundColor(Color.BLACK);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme_color = R.style.AppThemeNew3;
                recreate();
               // myToolbar.setBackgroundColor(Color.RED);

            }
        });

        //back buttons sends user to the home screen
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemeActivity.this, MainActivity.class );
                startActivity(intent);
            }
        });

        //sets the fonts of the settings text and font_type to be used by other classes
        btnFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               settings.setTypeface(Typeface.createFromAsset(getAssets(), "drivingaround.ttf"));
                font_type = ("drivingaround.ttf");
            }
        });

        btnFont2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setTypeface(Typeface.createFromAsset(getAssets(), "conditionfont.ttf"));
                font_type = ("conditionfont.ttf");

            }
        });

        btnFont3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setTypeface(Typeface.createFromAsset(getAssets(), "gaming.TTF"));
                font_type = ("gaming.TTF");
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
       // shareActionProvider = (android.support.v7.widget.ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
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
