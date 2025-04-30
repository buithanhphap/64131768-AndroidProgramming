package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Context;
import android.content.SharedPreferences;

public class NguoiChoi {
    private String nameData ="appData";
    public int tien;
    public void saveTT (Context ct) {
        SharedPreferences setting = ct.getSharedPreferences(nameData,0);
        SharedPreferences.Editor editor = setting.edit();
        editor.putInt("tien", tien);
        editor.apply();
    }
    public void getTT(Context ct){
        SharedPreferences setting = ct.getSharedPreferences(nameData,0);
        tien = setting.getInt("tien",20);
    }

}
