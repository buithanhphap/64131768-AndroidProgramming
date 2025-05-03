package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KetThucGameMainActivity extends AppCompatActivity {
    Button btnChoiLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_thuc_game_main);
        btnChoiLai = findViewById(R.id.btnChoiLai);
        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KetThucGameMainActivity.this, PlayGameActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}