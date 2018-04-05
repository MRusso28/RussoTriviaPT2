package ser210.quinnipiac.edu.triviaapinavdrawer;

/**
 * Created by markrusso on 4/3/18.
 * this is a list fragment class
 * implemented in Faavorites Activity
 * used to display favorites
 */

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;

public class FavsListFragment extends ListFragment {
    CountryListListener myActivity;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myActivity = (CountryListListener) activity;
    }

    static interface CountryListListener{
        void itemClickedMoveToDetail(int countryId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Instantiating an adapter to store each items
        String[] from = { "txt", };
        int[] to = { R.id.list};
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), new Favs().getAdaptorList(), R.layout.listview_layout, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // call a method in myActivity to start an intent
        myActivity.itemClickedMoveToDetail(position);
    }
}