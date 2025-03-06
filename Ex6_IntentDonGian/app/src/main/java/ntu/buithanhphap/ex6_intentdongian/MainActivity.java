package ntu.buithanhphap.ex6_intentdongian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button nutMH2;
    Button nutMH3;
    void TimDieuKhien() {
        nutMH2 = findViewById(R.id.btnMH2);
        nutMH3 = findViewById(R.id.btnMH3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tìm điều khiển nút bấm
        TimDieuKhien();
        //
    }
}