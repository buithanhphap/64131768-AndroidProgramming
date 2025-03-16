package ntu.buithanhphap.lt8_gamenhinhinhdoanchu;

import android.content.Context;
import android.content.SharedPreferences;

public class HighScoreManager {
    SharedPreferences sharedPreferences;

    public HighScoreManager(Context context) {
        sharedPreferences = context.getSharedPreferences("GamePrefs", Context.MODE_PRIVATE);
    }
}
