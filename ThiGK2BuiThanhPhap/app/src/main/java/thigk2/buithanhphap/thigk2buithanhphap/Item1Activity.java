package thigk2.buithanhphap.thigk2buithanhphap;

import android.os.Bundle;
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
    }
}