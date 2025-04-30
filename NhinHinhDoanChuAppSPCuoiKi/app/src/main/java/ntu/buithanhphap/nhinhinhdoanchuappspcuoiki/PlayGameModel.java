package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import java.util.ArrayList;

public class PlayGameModel {
    PlayGameActivity p;
    ArrayList<HinhCauHoi> arr;
    int cauSo = 0;
    public NguoiChoi nguoiChoi;

    public PlayGameModel(PlayGameActivity p) {
        this.p = p;
        nguoiChoi = new NguoiChoi();
        khoiTaoDaTa();
    }

    private void khoiTaoDaTa() {
        arr = new ArrayList<>();
        arr.add(new HinhCauHoi("Màn 1", "yeuot", "https://freetuts.net/upload/product_series/images/2022/11/16/2598/nhin-hinh-doan-chu-60.jpg"));
        arr.add(new HinhCauHoi("Màn 2", "baocao", "https://freetuts.net/upload/product_series/images/2022/11/16/2598/nhin-hinh-doan-chu-2.jpg"));
        arr.add(new HinhCauHoi("Màn 3", "cadao", "https://i.ytimg.com/vi/rHtDfzSPZfc/maxresdefault.jpg"));
    }

    public HinhCauHoi LayHinhCauHoi() {
        if (cauSo >= arr.size()) {
            cauSo = arr.size() - 1;
        }
        return arr.get(cauSo);
    }

    public void NextCauHoi() {
        cauSo++;
    }
    public void layThongTin(){
        nguoiChoi.getTT(p);
    }
    public void luuThongTin(){
        nguoiChoi.saveTT(p);
    }
}