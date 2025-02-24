package ntu.buithanhphap.dataexchangeintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NhapLieuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_lieu);
    }

    // Hàm khi nhấn nút Nhập
    public void Nhap(View v) {
        // Lấy dữ liệu từ EditText
        EditText edHT = findViewById(R.id.edtHoTen);
        EditText edNS = findViewById(R.id.edtNamSinh);

        // Lấy giá trị nhập vào
        String hoten = edHT.getText().toString();
        int namsinh = Integer.parseInt(edNS.getText().toString());

        // Tạo Intent gửi dữ liệu về Activity trước
        Intent iKQnhapLieu = new Intent();
        iKQnhapLieu.putExtra("HT", hoten);  // "HT" là key để lấy dữ liệu
        iKQnhapLieu.putExtra("NS", namsinh); // "NS" là key để lấy dữ liệu

        // Gửi kết quả về Activity đã gọi (MainActivity) với kết quả OK
        setResult(RESULT_OK, iKQnhapLieu);
        finish(); // Đóng màn hình nhập liệu
    }

    // Hàm khi nhấn nút Hủy
    public void Huy(View v) {
        // Không trả kết quả về, chỉ đóng Activity nhập liệu
        setResult(RESULT_CANCELED); // Trả về kết quả hủy bỏ
        finish(); // Đóng màn hình nhập liệu
    }
}
