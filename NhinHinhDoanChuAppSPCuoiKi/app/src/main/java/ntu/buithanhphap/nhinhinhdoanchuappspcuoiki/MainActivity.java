package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
        // Xử lý Bật tiếng
        battieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSoundOn && mediaPlayer != null) {
                    isSoundOn = true;
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                    }
                    Toast.makeText(MainActivity.this, "Bật tiếng thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Xử lý Tắt tiếng
        tattieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSoundOn && mediaPlayer != null) {
                    isSoundOn = false;
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }
                    Toast.makeText(MainActivity.this, "Tắt tiếng thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý hiện Thông tin
        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin ứng dụng");
                builder.setMessage("Tên game: Nhìn Hình Đoán Chữ\n" +
                        "Phiên bản: 1.0\n" +
                        "Email: support@nhinhinhdoanchu.com");
                builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
    
}