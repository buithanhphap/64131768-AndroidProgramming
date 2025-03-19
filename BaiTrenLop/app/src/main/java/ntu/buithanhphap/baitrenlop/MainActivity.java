package ntu.buithanhphap.baitrenlop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn0 , btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnKiemTra;
    TextView tvSoA, tvSoB, tvPhepToan, tvKetQua;
    int a, b, ketQuaDung;
    String phepToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        tvSoA = findViewById(R.id.tvSoA);
        tvSoB = findViewById(R.id.tvSoB);
        tvPhepToan = findViewById(R.id.tvPhepToan);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnKiemTra = findViewById(R.id.btnKiemTra);

        PhepToanNgauNhien();
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKetQua.setText("9");
            }
        });
        // Kiểm tra kết quả
        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int dapAnNguoiDung = Integer.parseInt(tvKetQua.getText().toString());
                    if (dapAnNguoiDung == ketQuaDung) {
                        Toast.makeText(MainActivity.this, "Đúng!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Sai!", Toast.LENGTH_SHORT).show();
                    }
                // Tạo phép toán mới sau khi kiểm tra
                PhepToanNgauNhien();
            }
        });
    }
    void PhepToanNgauNhien() {
        a = (int) (Math.random() * 5) + 1;
        b = (int) (Math.random() * 5) + 1;
        String[] phepToanArr = {"+", "-", "*", "/"};
        phepToan = phepToanArr[(int) (Math.random() * phepToanArr.length)];

        // Tính kết quả đúng
        switch (phepToan) {
            case "+":
                ketQuaDung = a + b;
                break;
            case "-":
                ketQuaDung = a - b;
                break;
            case "*":
                ketQuaDung = a * b;
                break;
            case "/":
                ketQuaDung = a / b;
                break;
        }
        tvSoA.setText(String.valueOf(a));
        tvSoB.setText(String.valueOf(b));
        tvPhepToan.setText(phepToan);
        tvKetQua.setText("");
    }
}