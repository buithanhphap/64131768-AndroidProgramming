package ntu.buithanhphap.dataexchangeintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo ActivityResultLauncher
    private ActivityResultLauncher<Intent> startActivityForResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo ActivityResultLauncher với ActivityResultContracts.StartActivityForResult
        startActivityForResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    // Xử lý kết quả trả về tại đây
                    if (result.getResultCode() == RESULT_OK) {
                        // Ví dụ: Xử lý dữ liệu trả về từ NhapLieuActivity
                        Intent data = result.getData();
                        if (data != null) {
                            String hotenNhanDuoc = data.getStringExtra("HT");
                            int namsinhNhanDuoc = data.getIntExtra("NS", 2020);

                            // Hiển thị dữ liệu lên TextView
                            TextView tvHT = findViewById(R.id.textView4);
                            TextView tvNS = findViewById(R.id.textView6);
                            tvHT.setText(hotenNhanDuoc);
                            tvNS.setText(String.valueOf(namsinhNhanDuoc));
                        }
                    } else {
                        Toast.makeText(this, "Trả về thất bại", Toast.LENGTH_LONG).show();
                    }
                });
    }

    // Hàm đáp ứng sự kiện OnClick lên nút "Mở màn hình nhập liệu"
    public void NhapLieu(View v) {
        // Tạo mới một Intent
        Intent iNhap = new Intent(this, NhapLieuActivity.class);
        // Mở màn hình nhập liệu và đợi kết quả trả về
        startActivityForResultLauncher.launch(iNhap);
    }
}
