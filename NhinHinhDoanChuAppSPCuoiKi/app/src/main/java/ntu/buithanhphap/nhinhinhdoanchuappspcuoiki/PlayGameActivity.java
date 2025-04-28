package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    ArrayList<String> ArrDapAn;
    GridView gdvDapAn;
    ArrayList<String> ArrNhapDapAn;
    GridView gdvNhapDapAn;
     private String dapAn="cadao";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //Tim dieu khien
        gdvDapAn = findViewById(R.id.gdvDapAn);
        gdvNhapDapAn = findViewById(R.id.gdvNhapDapAn);
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
        Random random = new Random();
        for(int i=0;i<dapAn.length();i++) {
            ArrDapAn.add("");
            String c = "" + (char)(random.nextInt(26)+65);
            ArrNhapDapAn.add(c);
            String c1 = "" + (char)(random.nextInt(26)+65);
            ArrNhapDapAn.add(c1);
        }
    }
}