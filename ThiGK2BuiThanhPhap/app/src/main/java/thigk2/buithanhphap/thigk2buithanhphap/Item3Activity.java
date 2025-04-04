package thigk2.buithanhphap.thigk2buithanhphap;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Item3Activity extends AppCompatActivity {
    TextView tvTenBaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);
        tvTenBaiHat = findViewById(R.id.tvTenBaiHat);

        // Nhận dữ liệu từ Intent
        String tenBaiHat = getIntent().getStringExtra("tenBaiHat");
        // Hiển thị lên TextView
        tvTenBaiHat.setText("Tên bài hát: " + tenBaiHat);
    }
}