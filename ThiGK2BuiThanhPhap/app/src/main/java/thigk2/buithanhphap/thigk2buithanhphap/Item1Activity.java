package thigk2.buithanhphap.thigk2buithanhphap;

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

public class Item1Activity extends AppCompatActivity {
    EditText edtNgay, edtThang, edtNam;
    Button btnKiemTra;
    TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item1);
        edtNgay = findViewById(R.id.edtNgay);
        edtThang = findViewById(R.id.edtThang);
        edtNam = findViewById(R.id.edtNam);
        btnKiemTra = findViewById(R.id.btnKiemTra);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNgay = edtNgay.getText().toString();
                String strThang = edtThang.getText().toString();
                String strNam = edtNam.getText().toString();
                int ngay = Integer.parseInt(strNgay);
                int thang = Integer.parseInt(strThang);
                int nam = Integer.parseInt(strNam);
                if (ngay == 30 && thang == 4 && nam == 1975) {
                    tvKetQua.setText("ĐÚNG");
                } else {
                    tvKetQua.setText("SAI");
                }
            }
        });
    }
}