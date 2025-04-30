package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    PlayGameModel models;
    HinhCauHoi hinhCauHoi;
    ArrayList<String> ArrDapAn;
    GridView gdvDapAn;
    ArrayList<String> ArrNhapDapAn;
    GridView gdvNhapDapAn;
     private String dapAn="CADAO";
     int index = 0;
    ArrayList<Integer> ViTriBanDau;
    ImageView imgHinhCauHoi;
    TextView tvTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //Tim dieu khien
        gdvDapAn = findViewById(R.id.gdvDapAn);
        gdvNhapDapAn = findViewById(R.id.gdvNhapDapAn);
        imgHinhCauHoi = findViewById(R.id.imgHinhCauHoi);
        tvTien = findViewById(R.id.tvTien);
        OnClick();
        // Khởi tạo dữ liệu
        models = new PlayGameModel(this);
        ArrDapAn = new ArrayList<>();
        ArrNhapDapAn = new ArrayList<>();
        ViTriBanDau = new ArrayList<>();
        HienHinhCauHoi();
    }
    private void HienDungODapAn() {
        index =0;
        ArrDapAn.clear();
        ArrNhapDapAn.clear();
        ViTriBanDau.clear();
        Random random = new Random();

        // Khởi tạo arrDapAn với các ô trống
        for (int i = 0; i < dapAn.length(); i++) {
            ArrDapAn.add("");
            ViTriBanDau.add(-1);
        }

        // Thêm các ký tự của dapAn (chữ hoa) vào arrNhapDapAn
        for (int i = 0; i < dapAn.length(); i++) {
            ArrNhapDapAn.add(String.valueOf(dapAn.charAt(i)).toUpperCase());
        }

        // Thêm các ký tự ngẫu nhiên từ A đến Z để đủ 10 ký tự
        while (ArrNhapDapAn.size() < 10) {
            char randomChar = (char) ('A' + random.nextInt(26));
            ArrNhapDapAn.add(String.valueOf(randomChar));
        }
        // Xáo trộn các ký tự trong ArrNhapDapAn
        Collections.shuffle(ArrNhapDapAn);
    }
    private void OnClick() {
        gdvNhapDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String c = (String) parent.getItemAtPosition(position);
                if( c.length() != 0 && index<ArrDapAn.size()){
                    if(ArrDapAn.get(index).length()!=0) {
                        return;
                    }
                    ArrNhapDapAn.set(position,"");
                    ArrDapAn.set(index,c);
                    ViTriBanDau.set(index, position);
                    index++;
                    // Cập nhật lại adapter
                    gdvDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrDapAn));
                    gdvNhapDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrNhapDapAn));
                    if (index == ArrDapAn.size()) {
                        KiemTraDapAn();
                    }
                }
            }
        });
        gdvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String c = (String) parent.getItemAtPosition(position);
                if( c.length() != 0){
                    // Xóa ký tự tại vị trí được chọn
                    ArrDapAn.set(position, "");
                    // Trả ký tự về đúng vị trí ban đầu trong ArrNhapDapAn
                    int vitribd = ViTriBanDau.get(position);
                    if (vitribd != -1) {
                        ArrNhapDapAn.set(vitribd, c);
                    }
                    // Tìm vị trí trống đầu tiên từ trái sang phải để đặt lại index
                    index = 0;
                    for (int i = 0; i < ArrDapAn.size(); i++) {
                        if (ArrDapAn.get(i).length() == 0) {
                            index = i;
                            break;
                        }
                    }
                    // Đặt lại vị trí gốc của ô này
                    ViTriBanDau.set(position, -1);
                    // Cập nhật lại adapter
                    gdvDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrDapAn));
                    gdvNhapDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrNhapDapAn));
                }
            }
        });
    }
    private void KiemTraDapAn(){
        String c = "";
        for(String c1:ArrDapAn){
            c += c1;
        }
        c = c.toUpperCase();
        if(c.equals(dapAn.toUpperCase())){
            Toast.makeText(this, "Bạn đã trả lời đúng",Toast.LENGTH_SHORT).show();
            models.layThongTin();
            models.nguoiChoi.tien = models.nguoiChoi.tien + 15;
            models.luuThongTin();
            models.NextCauHoi();
            HienHinhCauHoi();
        } else {
            Toast.makeText(this, "Câu trả lời của bạn đã sai", Toast.LENGTH_SHORT).show();
        }
    }
    private void HienHinhCauHoi(){
        hinhCauHoi = models.LayHinhCauHoi();
        dapAn = hinhCauHoi.dapAn;
        HienDungODapAn();
        // Set số cột bằng đúng số lượng phần tử => nằm ngang
        gdvDapAn.setNumColumns(ArrDapAn.size());
        // Gán adapter
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, ArrDapAn));
        // Set số cột bằng đúng số lượng phần tử => nằm ngang
        gdvNhapDapAn.setNumColumns(ArrNhapDapAn.size()/2);
        // Gán adapter
        gdvNhapDapAn.setAdapter(new DapAnAdapter(this, 0, ArrNhapDapAn));
        Glide.with(this)
                .load(hinhCauHoi.hinhAnh)
                .into(imgHinhCauHoi);
        models.layThongTin();
        tvTien.setText(models.nguoiChoi.tien+"");
    }
}