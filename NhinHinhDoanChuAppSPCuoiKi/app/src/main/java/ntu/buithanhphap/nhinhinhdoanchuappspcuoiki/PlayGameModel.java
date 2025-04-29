package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import java.util.ArrayList;

public class PlayGameModel {
    PlayGameActivity p;
    ArrayList<HinhCauHoi> arr;
    int cauSo = 0;
    public PlayGameModel(PlayGameActivity p) {
        this.p = p;
    }
    private void khoiTaoDaTa() {
        arr = new ArrayList<>();

    }
}
