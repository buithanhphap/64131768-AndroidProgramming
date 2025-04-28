package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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
        HienDungODapAn();
        ArrNhapDapAn = new ArrayList<>();
        ArrNhapDapAn.add("A");
        ArrNhapDapAn.add("B");
        ArrNhapDapAn.add("C");
        ArrNhapDapAn.add("D");
        ArrNhapDapAn.add("E");
        ArrNhapDapAn.add("A");
        ArrNhapDapAn.add("O");
        ArrNhapDapAn.add("O");
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
        for(int i=0;i<dapAn.length();i++) {
            ArrDapAn.add("");
        }
    }
}