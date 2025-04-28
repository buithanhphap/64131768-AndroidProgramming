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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //Tim dieu khien
        gdvDapAn = findViewById(R.id.gdvDapAn);
        // Khởi tạo dữ liệu
        ArrDapAn = new ArrayList<>();
        ArrDapAn.add("D");
        ArrDapAn.add("D");
        ArrDapAn.add("D");
        ArrDapAn.add("D");
        ArrDapAn.add("D");
        // Set số cột bằng đúng số lượng phần tử => nằm ngang
        gdvDapAn.setNumColumns(ArrDapAn.size());
        // Gán adapter
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, ArrDapAn));
    }
}