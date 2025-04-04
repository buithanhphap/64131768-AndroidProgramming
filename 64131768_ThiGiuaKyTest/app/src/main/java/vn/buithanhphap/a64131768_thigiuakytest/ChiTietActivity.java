package vn.buithanhphap.a64131768_thigiuakytest;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChiTietActivity extends AppCompatActivity {
    ImageView imgXe;
    TextView txtTenXe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        imgXe = findViewById(R.id.imgageXe);
        txtTenXe = findViewById(R.id.tvTenxe);

        // Nhận tên xe được gửi từ Activity trước
        String tenXe = getIntent().getStringExtra("tenXe");
        txtTenXe.setText(tenXe);
        // Hiển thị hình theo tên xe
        switch (tenXe) {
            case "TOYOTA":
                imgXe.setImageResource(R.drawable.honda); break;
            case "BWM":
                imgXe.setImageResource(R.drawable.bwm); break;
            case "Honda":
                imgXe.setImageResource(R.drawable.honda); break;
            case "Mercedes":
                imgXe.setImageResource(R.drawable.mec); break;
            case "KIA":
                imgXe.setImageResource(R.drawable.kia); break;
            default:
                imgXe.setImageResource(R.drawable.bong1); // ảnh mặc định
        }
    }
}