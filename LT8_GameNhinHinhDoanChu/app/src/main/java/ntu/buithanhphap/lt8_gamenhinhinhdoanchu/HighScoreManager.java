package ntu.buithanhphap.lt8_gamenhinhinhdoanchu;

import android.content.Context;
import android.content.SharedPreferences;

public class HighScoreManager {
    SharedPreferences sharedPreferences;

    public HighScoreManager(Context context) {
        sharedPreferences = context.getSharedPreferences("GamePrefs", Context.MODE_PRIVATE);
    }
    public void saveHighScore(int score) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("HighScore", score);
        editor.apply();
    }
    public int getHighScore() {
        return sharedPreferences.getInt("HighScore", 0);
    }
}
