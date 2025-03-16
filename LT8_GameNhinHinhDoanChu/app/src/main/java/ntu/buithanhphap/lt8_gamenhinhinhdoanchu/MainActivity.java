package ntu.buithanhphap.lt8_gamenhinhinhdoanchu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    ImageView ivImage;
    TextInputEditText edtTraLoi;
    TextView tvDiem, tvDiemCaoNhat;
    Button btnKiemTra, btnTiepTheo;

    String[] images = {"daoaothaca", "cauchi", "trongvang", "tinhnghich", "anboobui"};
    int[] imageRes = {R.drawable.daoaothaca, R.drawable.cauchi, R.drawable.trongvang, R.drawable.tinhnghich, R.drawable.anboobui};
    String correctAnswer;
    int score = 0;
    HighScoreManager highScoreManager;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tìm điều khiển
        ivImage = findViewById(R.id.ivImage);
        edtTraLoi = findViewById(R.id.edtTraLoi);
        tvDiem = findViewById(R.id.tvDiem);
        tvDiemCaoNhat = findViewById(R.id.tvDiemCaoNhat);
        btnKiemTra = findViewById(R.id.btnKiemTra);
        btnTiepTheo = findViewById(R.id.btnTiepTheo);

        highScoreManager = new HighScoreManager(this);
        tvDiemCaoNhat.setText("Điểm cao nhất: " + highScoreManager.getHighScore());

        loadNewImage();

        //Nút bấm
        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KiemTraTraLoi();
            }
        });

        btnTiepTheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewImage();
            }
        });
    }

    private void loadNewImage() {
        if (currentIndex < images.length) {
            ivImage.setImageResource(imageRes[currentIndex]);
            correctAnswer = images[currentIndex];
            edtTraLoi.setText("");
        } else {
            // Hết ảnh => Kết thúc trò chơi
            ivImage.setVisibility(View.GONE);
            edtTraLoi.setVisibility(View.GONE);
            btnKiemTra.setVisibility(View.GONE);
            btnTiepTheo.setVisibility(View.GONE);

            Toast.makeText(this, "Trò chơi kết thúc! Tổng điểm: " + score, Toast.LENGTH_LONG).show();
        }
    }

    private void KiemTraTraLoi() {
        String answer = edtTraLoi.getText().toString().trim().toLowerCase();
        if (answer.equals(correctAnswer)) {
            score += 10;
            tvDiem.setText("Điểm: " + score);
            if (score > highScoreManager.getHighScore()) {
                highScoreManager.saveHighScore(score);
                tvDiemCaoNhat.setText("Điểm cao nhất: " + score);
            }
            Toast.makeText(this, "Chính xác!", Toast.LENGTH_SHORT).show();
            currentIndex++; // Chuyển sang ảnh tiếp theo
        } else {
            Toast.makeText(this, "Sai rồi, thử lại!", Toast.LENGTH_SHORT).show();
        }
    }
}
