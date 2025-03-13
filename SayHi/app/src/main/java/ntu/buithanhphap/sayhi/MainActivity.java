package ntu.buithanhphap.sayhi;

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

    Button btnSayHi;
    TextView tvKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSayHi = findViewById(R.id.btnSayHi);
        tvKQ = findViewById(R.id.tvKQ);
        btnSayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               tvKQ.setText("Xin Chào");
            }
        });
    }
}