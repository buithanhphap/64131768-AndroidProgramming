package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    ArrayList<String> ArrDapAn;
    GridView gdvDapAn;
    ArrayList<String> ArrNhapDapAn;
    GridView gdvNhapDapAn;
     private String dapAn="CADAO";
     int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //Tim dieu khien
        gdvDapAn = findViewById(R.id.gdvDapAn);
        gdvNhapDapAn = findViewById(R.id.gdvNhapDapAn);
        OnClick();
        // Khởi tạo dữ liệu
        ArrDapAn = new ArrayList<>();
        ArrNhapDapAn = new ArrayList<>();
        HienDungODapAn();
        // Set số cột bằng đúng số lượng phần tử => nằm ngang
        gdvDapAn.setNumColumns(ArrDapAn.size());
        // Gán adapter
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, ArrDapAn));
        // Set số cột bằng đúng số lượng phần tử => nằm ngang
        gdvNhapDapAn.setNumColumns(ArrNhapDapAn.size()/2);
        // Gán adapter
        gdvNhapDapAn.setAdapter(new DapAnAdapter(this, 0, ArrNhapDapAn));
    }
    private void HienDungODapAn() {
        ArrDapAn.clear();
        ArrNhapDapAn.clear();
        Random random = new Random();

        // Khởi tạo arrDapAn với các ô trống
        for (int i = 0; i < dapAn.length(); i++) {
            ArrDapAn.add("");
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
                    ArrNhapDapAn.set(position,"");
                    ArrDapAn.set(index,c);
                    index++;
                    // Cập nhật lại adapter
                    gdvDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrDapAn));
                    gdvNhapDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrNhapDapAn));
                }
            }
        });
    }
}