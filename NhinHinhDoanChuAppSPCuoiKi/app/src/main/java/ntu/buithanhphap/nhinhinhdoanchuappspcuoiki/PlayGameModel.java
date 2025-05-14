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
        arr.add(new HinhCauHoi("Màn 4", "mitom", "https://i.ytimg.com/vi/p3RQvawhPvA/sddefault.jpg"));
        arr.add(new HinhCauHoi("Màn 5", "phuyen", "https://cdn2.tuoitre.vn/thumb_w/480/471584752817336320/2023/4/20/phu-yen-1-16819671427591853833321.jpg"));
        arr.add(new HinhCauHoi("Màn 6", "taomeo", "https://i.ytimg.com/vi/7UeuqlU4gbE/maxresdefault.jpg"));
        arr.add(new HinhCauHoi("Màn 7", "caheo", "https://i.ytimg.com/vi/gZqv6D38bc0/maxresdefault.jpg"));
        arr.add(new HinhCauHoi("Màn 8", "nhama", "https://i.ytimg.com/vi/TgPkpguoi4g/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLBkoMVkfEh5SeAJKp3EzXuVkPrezA"));
        arr.add(new HinhCauHoi("Màn 9", "halong", "https://i.ytimg.com/vi/xRxrUtzBiv8/maxresdefault.jpg"));
        arr.add(new HinhCauHoi("Màn 10", "nauan", "https://i.ytimg.com/vi/r_U4PxrY7bw/sddefault.jpg"));
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
