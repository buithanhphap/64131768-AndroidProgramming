package ntu.buithanhphap.lt8_gamenhinhinhdoanchu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView ivImage;
    TextInputEditText edtTraLoi;
    TextView tvDiem, tvDiemCaoNhat;
    Button btnKiemTra, btnTiepTheo;

    String[] images = {"daoaothaca", "cauchi"};
    int[] imageRes = {R.drawable.daoaothaca, R.drawable.cauchi};
    String correctAnswer;
    int score = 0;
    HighScoreManager highScoreManager;
    Random random = new Random();
    int currentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}