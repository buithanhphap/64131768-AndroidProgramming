package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import java.util.ArrayList;

public class PlayGameModel {
    PlayGameActivity p;
    ArrayList<HinhCauHoi> arr;
    int cauSo;
    public NguoiChoi nguoiChoi;
    private DatabaseHelper dbHelper;

    public PlayGameModel(PlayGameActivity p) {
        this.p = p;
        nguoiChoi = new NguoiChoi();
        cauSo = nguoiChoi.getCauSo(p);
        dbHelper = new DatabaseHelper(p);
        khoiTaoDaTa();
    }

    private void khoiTaoDaTa() {
        arr = dbHelper.getAllCauHoi();
        if (arr.isEmpty()) {
            // Nếu không có dữ liệu, thêm mặc định (đã được xử lý trong DatabaseHelper)
        }
    }

    public HinhCauHoi LayHinhCauHoi() {
        if (cauSo >= arr.size()) {
            cauSo = arr.size() - 1;
        }
        return arr.get(cauSo);
    }

    public void NextCauHoi() {
        cauSo++;
        nguoiChoi.saveCauSo(p, cauSo);
    }

    public void layThongTin() {
        nguoiChoi.getTT(p);
    }

    public void luuThongTin() {
        nguoiChoi.saveTT(p);
    }

    public int getCauSo() {
        return cauSo;
    }
}