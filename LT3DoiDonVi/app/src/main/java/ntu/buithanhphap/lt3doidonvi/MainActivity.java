package ntu.buithanhphap.lt3doidonvi;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtSo1;
    Spinner spinner, spinner2;
    Button btnChuyenDonVi;
    TextView tvKetQua;
    String[] units = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSo1 = findViewById(R.id.edtSo1);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        btnChuyenDonVi = findViewById(R.id.btnChuyenDonVi);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Tạo Adapter cho Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);


        btnChuyenDonVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChuyenDonVi();
            }
        });
    }
    public void ChuyenDonVi() {
        // Lấy giá trị nhập vào
        String inputText = edtSo1.getText().toString();
        int inputValue = Integer.parseInt(inputText);
        String fromUnit = spinner.getSelectedItem().toString();
        String toUnit = spinner2.getSelectedItem().toString();
        int result = DoiGiaTri(inputValue, fromUnit, toUnit);
        tvKetQua.setText(inputValue + " " + fromUnit + " = " + result + " " + toUnit);
    }

    private int DoiGiaTri(int value, String fromUnit, String toUnit) {
        // Chuyển tất cả về đơn vị cơ bản là mét (m)
        int GiaTriMet;
        switch (fromUnit) {
            case "km": GiaTriMet = value * 1000; break;
            case "hm": GiaTriMet = value * 100; break;
            case "dam": GiaTriMet = value * 10; break;
            case "dm": GiaTriMet = value / 10; break;
            case "cm": GiaTriMet = value / 100; break;
            case "mm": GiaTriMet = value / 1000; break;
            default: GiaTriMet = value; // "m"
        }

        // Chuyển từ mét (m) sang đơn vị mong muốn
        int result;
        switch (toUnit) {
            case "km": result = GiaTriMet / 1000; break;
            case "hm": result = GiaTriMet / 100; break;
            case "dam": result = GiaTriMet / 10; break;
            case "dm": result = GiaTriMet * 10; break;
            case "cm": result = GiaTriMet * 100; break;
            case "mm": result = GiaTriMet * 1000; break;
            default: result = GiaTriMet; // "m"
        }
        return result;
    }
}