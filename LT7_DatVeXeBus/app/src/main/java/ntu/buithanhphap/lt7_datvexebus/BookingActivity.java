package ntu.buithanhphap.lt7_datvexebus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BookingActivity extends AppCompatActivity {
    EditText edtName, edtPhoneNumber, edtTickets;
    Button btnDatVe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        TextView tvBusName = findViewById(R.id.tvBusName);
        edtName = findViewById(R.id.edtName);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtTickets = findViewById(R.id.edtTickets);
        btnDatVe = findViewById(R.id.btnDatVe);

        // Nhận dữ liệu từ BusDetailsActivity
        String tenChuyen = getIntent().getStringExtra("ten_chuyen");
        tvBusName.setText(tenChuyen);

        // Nút xác nhận đặt vé
        btnDatVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookingActivity.this, "Đặt vé thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}