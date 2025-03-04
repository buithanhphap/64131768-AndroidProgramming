package ntu.buithanhphap.lt5_addsubmuldiv_activiyaslistner;

import android.app.Activity;
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

// Cách Activity as Listener
public class MainActivity extends Activity implements View.OnClickListener {

    EditText edtSo1, edtSo2;
    TextView tvKetQua;
    Button btnCong, btnTru, btnNhan, btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b3. gan bo lang nghe cho nut
        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        tvKetQua = findViewById(R.id.tvKetQua);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        // Gán bộ lắng nghe (this) cho các nút
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        // Lấy số từ EditText
        String strA = edtSo1.getText().toString();
        String strB = edtSo2.getText().toString();

        // Kiểm tra nếu EditText rỗng
        if (strA.isEmpty() || strB.isEmpty()) {
            tvKetQua.setText("Vui lòng nhập số a và b!");
            return;
        }

        // Chuyển đổi sang số
        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double result = 0;

        // Xử lý phép toán
        if (v.getId() == R.id.btnCong) {
            result = a + b;
        } else if (v.getId() == R.id.btnTru) {
            result = a - b;
        } else if (v.getId() == R.id.btnNhan) {
            result = a * b;
        } else if (v.getId() == R.id.btnChia) {
            if (b == 0) {
                tvKetQua.setText("Lỗi: Không thể chia cho 0!");
                return;
            }
            result = a / b;
        }

        // Hiển thị kết quả
        tvKetQua.setText("Kết quả: " + result);
    }
}