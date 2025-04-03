package vn.buithanhphap.a64131768_thigiuakytest;

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

public class Cau1Activity extends AppCompatActivity {
    TextView tvKetQua;

    EditText edtsoa, edtsob;
    Button btnTinhTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);
        edtsoa = findViewById(R.id.edtSoa);
        edtsob = findViewById(R.id.edtSob);
        btnTinhTong = findViewById(R.id.btnTinhTong);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strSo1 = edtsoa.getText().toString();
                String strSo2 = edtsob.getText().toString();
                double soA = Double.parseDouble(strSo1);
                double soB = Double.parseDouble(strSo2);
                double tong = soA + soB;
                String strKQ = String.valueOf(tong);
                tvKetQua.setText(strKQ);
            }
        });
    }
}