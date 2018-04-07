package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * CREATED BY MARK RUSSO
 * this class is the theme of the trivia game
 * fonts and toolbar colors are set here
 */

public class SettingsActivity extends AppCompatActivity {
    public static int theme_color = R.style.AppTheme;
    public static String font_type;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        final Toolbar myToolbar;
        //sets the theme
        setTheme(theme_color);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        //retrieves all of the buttons created in xml
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

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme_color = R.style.AppThemeNew2;
                recreate();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theme_color = R.style.AppTheme;
                recreate();
            }
        });

        //back buttons sends user to the home screen
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
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

    //nothin to share in this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //app should not be able to share the settings
        //MenuItem menuItem = menu.findItem(R.id.action_share);
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
