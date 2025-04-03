package vn.buithanhphap.a64131768_thigiuakytest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cau3Activity extends AppCompatActivity {
    Button btnLienHe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);
        btnLienHe = findViewById(R.id.btnLienHe);
        btnLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Cau3Activity.this, "Đã liên hệ thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}