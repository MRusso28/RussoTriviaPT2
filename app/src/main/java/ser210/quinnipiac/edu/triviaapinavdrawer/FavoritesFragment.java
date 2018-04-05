package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


//not yet implemented
public class FavoritesFragment extends ListFragment {
    FavsListListener myActivity;
    SQLiteFavorites myDB;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myActivity = (FavsListListener) activity;

    }

    static interface FavsListListener{
        void itemClickedMoveToDetail(int countryId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // call a method in myActivity to start an intent
        myActivity.itemClickedMoveToDetail(position);
    }

}
