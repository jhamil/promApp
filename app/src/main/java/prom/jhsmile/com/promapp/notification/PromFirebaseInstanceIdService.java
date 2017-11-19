package prom.jhsmile.com.promapp.notification;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by jhdev on 18-11-17.
 */

public class PromFirebaseInstanceIdService extends FirebaseInstanceIdService {
    private static String TAG = "firebase app";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token);
    }
}
