package ntu.buithanhphap.simpleexplicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Hàm đáp ứng sự kiện nhấn nút "Sang màn hình khác"
    // Xử lý chuyển màn hình
    public void ChuyenManHinh(View v) {
        // Tạo một đối tượng Intent để chuyển sang SubActivityOne
        Intent iManHinhKhac = new Intent(this, SubActivityOne.class);
        // Thực hiện chuyển màn hình
        startActivity(iManHinhKhac);
    }
}
