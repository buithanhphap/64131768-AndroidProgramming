package ntu.buithanhphap.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtWeight, edtHeight;
    TextView tvResult, tvPhanLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWeight = findViewById(R.id.edtSo1);
        edtHeight = findViewById(R.id.edtSo2);
        tvResult = findViewById(R.id.tvKetQua);
        tvPhanLoai = findViewById(R.id.tvPhanLoai);
    }

    // Hàm xử lý khi nhấn nút
    public void TinhBMI(View v) {
        String weightStr = edtWeight.getText().toString();
        String heightStr = edtHeight.getText().toString();

        // Chuyển đổi và tính toán BMI
        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr) / 100; // Chuyển cm → m

        // Tính BMI
        float bmi = weight / (height * height);
        String phanloai;

        // Phân loại BMI theo chuẩn IDI & WPRO (Châu Á)
        if (bmi < 18.5) {
            phanloai = "Cân nặng thấp (gầy)";
        } else if (bmi < 23) {
            phanloai = "Bình thường";
        } else if (bmi == 23) {
            phanloai = "Thừa cân";
        } else if (bmi < 24.9) {
            phanloai = "Tiền béo phì";
        } else if (bmi < 29.9) {
            phanloai = "Béo phì độ I";
        } else {
            phanloai = "Béo phì độ II";
        }

        // Hiển thị kết quả
        tvResult.setText(String.format("BMI: %.1f", bmi));
        tvPhanLoai.setText(phanloai);
    }
}
