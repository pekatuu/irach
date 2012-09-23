package jp.pekatuu.android.irach;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.os.Bundle;

public class IrachActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager am = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        List<RecentTaskInfo> tasks = am.getRecentTasks(3, ActivityManager.RECENT_IGNORE_UNAVAILABLE); 
        if(tasks.size() < 3) return;
        
        int tid = tasks.get(2).id; 
        am.moveTaskToFront(tid, 0);
        finish();
    }
}