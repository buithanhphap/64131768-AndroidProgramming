package ntu.buithanhphap.lt2dientichhcn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1, edtSo2;
    TextView tvKetQua;
    Button btnTinhDienTich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnTinhDienTich = findViewById(R.id.button);
        // Xử lý sự kiện khi nhấn nút tính diện tích
        btnTinhDienTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhDienTich();
            }
        });
    }
    // Hàm tính diện tích hình chữ nhật
    public void TinhDienTich() {
        String strChieuDai = edtSo1.getText().toString();
        String strChieuRong = edtSo2.getText().toString();

        try {
            double chieuDai = Double.parseDouble(strChieuDai);
            double chieuRong = Double.parseDouble(strChieuRong);

            // Tính diện tích hình chữ nhật
            double dienTich = chieuDai * chieuRong;

            // Hiển thị kết quả
            tvKetQua.setText("Diện tích HCN: " + dienTich + " cm²");
        } catch (NumberFormatException e) {
            tvKetQua.setText("Vui lòng nhập số hợp lệ!");
        }

    }
}