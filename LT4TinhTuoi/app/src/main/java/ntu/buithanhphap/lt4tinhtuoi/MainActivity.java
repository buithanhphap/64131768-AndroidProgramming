package ntu.buithanhphap.lt4tinhtuoi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText edtSo1;
    Button btnTinhTuoi;
    TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSo1 = findViewById(R.id.edtSo1);
        btnTinhTuoi = findViewById(R.id.btnTinhTuoi);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnTinhTuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinhTuoi();
            }
        });
    }
    public void TinhTuoi() {
        // Lấy năm hiện tại
        int NamHT = Calendar.getInstance().get(Calendar.YEAR);

        // Lấy dữ liệu từ EditText
        String NamSinh = edtSo1.getText().toString();

        if (NamSinh.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập năm sinh!", Toast.LENGTH_SHORT).show();
            return;
        }

        int birthYear = Integer.parseInt(NamSinh);

        // Kiểm tra năm sinh hợp lệ
        if (birthYear > NamHT) {
            Toast.makeText(this, "Năm sinh không hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tính tuổi
        int age = NamHT - birthYear;

        // Hiển thị kết quả
        tvKetQua.setText("Tuổi của bạn: " + age + " tuổi");
    }
}