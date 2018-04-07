package ser210.quinnipiac.edu.triviaapinavdrawer;

/**
 * Created by markrusso on 4/3/18.
 * this is a list fragment class
 * implemented in Faavorites Activity
 * used to display favorites
 */

import android.app.Activity;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FavsListFragment extends ListFragment {

    //empty constructor
    public FavsListFragment() {

    }

    //interface used to communicate, implemented by faavorites activity
    static interface FavsListListener {
        void itemClickedMoveToDetail(int position);
    }

    FavsListListener myActivity;

    //inflates layout
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        return view;
    }

    //Activity created, sets the list adapter
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, SQLiteFavorites.list);
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.myActivity = (FavsListListener) activity;
    }

    //Responds to list item clicks
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (myActivity != null) {
            super.onListItemClick(l, v, position, id);
            myActivity.itemClickedMoveToDetail(position);
        }

    }

}