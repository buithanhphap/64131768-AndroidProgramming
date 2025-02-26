package ntu.buithanhphap.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtWeight, edtHeight;
    TextView tvResult, tvClassification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các View từ XML
        edtWeight = findViewById(R.id.edtSo1); // Trọng lượng (kg)
        edtHeight = findViewById(R.id.edtSo2); // Chiều cao (cm)
        tvResult = findViewById(R.id.tvKetQua); // Kết quả BMI
        tvClassification = findViewById(R.id.tvPhanLoai); // Phân loại BMI
    }

    // Hàm xử lý khi nhấn nút
    public void TinhBMI(View v) {
        String weightStr = edtWeight.getText().toString().trim();
        String heightStr = edtHeight.getText().toString().trim();

        // Kiểm tra nhập liệu
        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            tvResult.setText("Vui lòng nhập đủ thông tin!");
            return;
        }

        // Chuyển đổi và tính toán BMI
        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // Chuyển cm → m

        // Tính BMI
        float bmi = weight / (height * height);
        String classification;

        // Phân loại BMI theo chuẩn IDI & WPRO (Châu Á)
        if (bmi < 18.5) {
            classification = "Cân nặng thấp (gầy)";
        } else if (bmi < 23) {
            classification = "Bình thường";
        } else if (bmi == 23) {
            classification = "Thừa cân";
        } else if (bmi < 24.9) {
            classification = "Tiền béo phì";
        } else if (bmi < 29.9) {
            classification = "Béo phì độ I";
        } else {
            classification = "Béo phì độ II";
        }

        // Hiển thị kết quả
        tvResult.setText(String.format("BMI: %.1f", bmi));
        tvClassification.setText(classification);
    }
}
