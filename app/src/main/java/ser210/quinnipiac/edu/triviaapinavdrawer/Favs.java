package ser210.quinnipiac.edu.triviaapinavdrawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by markrusso on 4/4/18.
 * samples used to list favorites
 */

public class Favs {
    private String Fav;
    private String fact;

    public static final Favs[] Favs = {
            new Favs("This is a favorite")
    };

    public Favs(){

    }
    public Favs(String fav) {
        this.Fav = fav;

    }

    public List<HashMap<String,String>> getAdaptorList(){
        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<Favs.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            list.add(hm);
        }
        return list;
    }


}
