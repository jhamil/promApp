package prom.jhsmile.com.promapp.notification;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by jhdev on 18-11-17.
 */

public class PromFirebaseMessagingService extends FirebaseMessagingService {
    private static String TAG = "firebase app";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String data = remoteMessage.getFrom();
        Log.d(TAG, data);

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, remoteMessage.getNotification().getBody());
        }
    }

}
