package prom.jhsmile.com.promapp.promotion;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;
import java.util.Set;

import prom.jhsmile.com.promapp.model.ProductOfert;

/**
 * Created by jhdev on 18-11-17.
 */

public class SessionManager {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "promapp";
    private Context _context;
    private int PRIVATE_MODE = 0;
    private String KEY_TITLE = "ktitle";
    private String KEY_DESCRIPTION = "kdescription";
    private String KEY_SHORDESCRIPTION = "kshordescription";
    private String KEY_URLIMAGE = "kurlimage";
    private String KEY_LAT = "klat";
    private String KEY_LON = "klon";


    public SessionManager(Context context) {
        _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public String getTitle() {
        return pref.getString(KEY_TITLE, "No hay datos");
    }

    public void saveTitle(String title) {
        editor.putString(KEY_TITLE, title);
        editor.commit();
    }

}
