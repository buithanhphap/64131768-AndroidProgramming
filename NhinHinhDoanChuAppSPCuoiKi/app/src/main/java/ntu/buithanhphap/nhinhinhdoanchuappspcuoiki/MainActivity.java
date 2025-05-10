package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnChoi, btnLuatchoi, btnThoat;
    private boolean isSoundOn = true;
    private MediaPlayer mediaPlayer;
    View battieng, tattieng, thongtin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Tìm điều khiển
        btnChoi = findViewById(R.id.btnChoi);
        btnLuatchoi = findViewById(R.id.btnLuatChoi);
        btnThoat = findViewById(R.id.btnThoat);
        battieng = findViewById(R.id.battieng);
        tattieng = findViewById(R.id.tattieng);
        thongtin = findViewById(R.id.thongtin);
        // Khởi tạo MediaPlayer với file âm thanh
        mediaPlayer = MediaPlayer.create(this, R.raw.nhac);
        mediaPlayer.setLooping(true); // Lặp lại âm thanh
        if (isSoundOn) mediaPlayer.start();
        //Xử lý sự kiện nút chơi
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayGameActivity.class);
                startActivity(intent);
            }
        });
        //Xử lý sự kiện nút luật chơi
        btnLuatchoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });
        //Xử lý sự kiện nút thoát
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}