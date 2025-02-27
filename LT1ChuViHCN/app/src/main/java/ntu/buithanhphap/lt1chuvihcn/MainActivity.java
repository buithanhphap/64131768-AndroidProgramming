package ntu.buithanhphap.lt1chuvihcn;

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
    Button btnChuVi;
    TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ view
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        btnChuVi = findViewById(R.id.btnChuVi);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Xử lý sự kiện khi nhấn nút TÍNH CHU VI
        btnChuVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhChuVi();
            }
        });
    }
    public void tinhChuVi() {
        // Lấy dữ liệu từ EditText
        String strChieuDai = edtSo1.getText().toString();
        String strChieuRong = edtSo2.getText().toString();

        if (strChieuDai.isEmpty() || strChieuRong.isEmpty()) {
            tvKetQua.setText("Vui lòng nhập đầy đủ chiều dài và chiều rộng!");
            return;
        }

        // Chuyển đổi sang số
        double chieuDai = Double.parseDouble(strChieuDai);
        double chieuRong = Double.parseDouble(strChieuRong);

        // Tính chu vi
        double chuVi = 2 * (chieuDai + chieuRong);

        // Hiển thị kết quả
        tvKetQua.setText("Chu vi hình chữ nhật: " + chuVi + " cm");
    }
}