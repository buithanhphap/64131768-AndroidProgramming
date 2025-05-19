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
    View btnChoi, btnLuatChoi, btnThoat;
    private boolean isSoundOn = true;
    private MediaPlayer mediaPlayer;
    View battieng, tattieng, thongtin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tìm điều khiển
        btnChoi = findViewById(R.id.btnChoi);
        btnLuatChoi = findViewById(R.id.btnLuatChoi);
        btnThoat = findViewById(R.id.btnThoat);
        battieng = findViewById(R.id.battieng);
        tattieng = findViewById(R.id.tattieng);
        thongtin = findViewById(R.id.thongtin);

        // Khởi tạo MediaPlayer với file âm thanh
        mediaPlayer = MediaPlayer.create(this, R.raw.nhac);
        mediaPlayer.setLooping(true); // Lặp lại âm thanh
        if (isSoundOn) mediaPlayer.start();
        // Bắt sự kiện nút "Chơi"
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayGameActivity.class);
                startActivity(intent);
            }
        });
        // Bắt sự kiện nút "Luật chơi"
        btnLuatChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });
        // Bắt sự kiện nút "Thoát"
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Thoát Activity
            }
        });
        // Xử lý nút Bật tiếng
        battieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSoundOn && mediaPlayer != null) {
                    isSoundOn = true;
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                    }
                    CustomToast.makeText(
                            MainActivity.this,
                            "Bật tiếng thành công!",
                            Toast.LENGTH_SHORT,
                            CustomToast.SUCCESS,
                            true // Hiển thị icon Android, đổi thành false nếu không muốn
                    ).show();
                }
            }
        });

        // Xử lý nút Tắt tiếng
        tattieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSoundOn && mediaPlayer != null) {
                    isSoundOn = false;
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }
                    CustomToast.makeText(
                            MainActivity.this,
                            "Tắt tiếng thành công!",
                            Toast.LENGTH_SHORT,
                            CustomToast.SUCCESS,
                            true
                    ).show();
                }
            }
        });

        // Xử lý nút Thông tin
        thongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông tin ứng dụng");
                builder.setMessage("App game: Nhìn Hình Đoán Chữ\n" +
                        "Giảng viên hướng dẫn: Mai Cường Thọ\n" +
                        "Sinh viên thực hiện: 1. Bùi Thanh Pháp\n" +
                        "                                     2. Dương Ngọc Lệnh\n" +
                        "Lớp: 64.TTMMT\n" +
                        "Email: phap.bt.64cntt@ntu.edu.vn\n" +
                        "             lenh.dn.64cntt@ntu.edu.vn");
                builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}