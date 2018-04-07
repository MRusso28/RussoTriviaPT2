package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by markrusso on 3/5/18.
 * Assignment 3 Part 2
 * SER210
 * this class displays details
 */

public class FavoriteDetailActivity extends AppCompatActivity {
    SQLiteFavorites mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_detail);
        final TextView details = (TextView) findViewById(R.id.question_details);
        TextView title = (TextView) findViewById(R.id.question_title);
        Button back = (Button) findViewById(R.id.details_back);
        Button delete = (Button) findViewById(R.id.details_remove);
        details.setText(getIntent().getStringExtra("fav"));


        //change the fonts if changed in settings else use default font
        if (SettingsActivity.font_type != null) {
            details.setTypeface(Typeface.createFromAsset(getAssets(), SettingsActivity.font_type));
            title.setTypeface(Typeface.createFromAsset(getAssets(), SettingsActivity.font_type));
        } else {
            details.setTypeface(Typeface.createFromAsset(getAssets(), "default.ttf"));
            title.setTypeface(Typeface.createFromAsset(getAssets(), "default.ttf"));
        }
        details.setText("You Favorited a Movie Question!!");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    //share not available in this activity due to lack of info
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
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
