package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

public class HinhCauHoi {
    public String tenNam, dapAn, hinhAnh;
    public HinhCauHoi() {

    }

    public HinhCauHoi(String tenNam, String dapAn, String hinhAnh) {
        this.tenNam = tenNam;
        this.dapAn = dapAn;
        this.hinhAnh = hinhAnh;
    }
    public String getTenNam() {
        return tenNam;
    }

    public String getDapAn() {
        return dapAn;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }
}
