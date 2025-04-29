package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import java.util.ArrayList;

public class PlayGameModel {
    PlayGameActivity p;
    ArrayList<HinhCauHoi> arr;
    int cauSo = 0;
    public PlayGameModel(PlayGameActivity p) {
        this.p = p;
        khoiTaoDaTa();
    }
    private void khoiTaoDaTa() {
        arr = new ArrayList<>();
        arr.add(new HinhCauHoi("Màn 1","baocao","https://freetuts.net/upload/product_series/images/2022/11/16/2598/nhin-hinh-doan-chu-2.jpg"));
    }
    public HinhCauHoi LayHinhCauHoi(){
        cauSo++;
        if(cauSo>= arr.size()){
            cauSo= arr.size()-1;
        }
        return arr.get(cauSo);
    }
}
