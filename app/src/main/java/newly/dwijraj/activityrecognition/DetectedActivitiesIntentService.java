package newly.dwijraj.activityrecognition;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.ArrayList;

/**
 * Created by 1405214 on 23-06-2016.
 */
public class DetectedActivitiesIntentService extends IntentService {

    private final static String TAG="Detected_is";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DetectedActivitiesIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ActivityRecognitionResult result=ActivityRecognitionResult.extractResult(intent);
        Intent localintent=new Intent();
        localintent.setAction(Constants.BROADCAST_ACTION);



        ArrayList<DetectedActivity> detectedActivities=(ArrayList)result.getProbableActivities();
        localintent.putExtra(Constants.ACTIVITY_EXTRA,detectedActivities);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localintent);


    }
}
