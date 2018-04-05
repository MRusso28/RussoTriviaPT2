package ser210.quinnipiac.edu.triviaapinavdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * The is a fragment used by the tivia activity of Russos Trivia
 * Updated April 6, 2018
 * @author markrusso
 * SER210
 */

public class TriviaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia, container, false);
    }
}
