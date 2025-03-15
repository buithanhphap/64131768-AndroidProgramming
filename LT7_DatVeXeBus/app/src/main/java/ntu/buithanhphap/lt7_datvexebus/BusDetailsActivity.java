package ntu.buithanhphap.lt7_datvexebus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BusDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_details);
        TextView tvBusName = findViewById(R.id.tvBusName);
        Button btnBookTicket = findViewById(R.id.btnBookTicket);

        // Nhận dữ liệu từ MainActivity
        String tenChuyen = getIntent().getStringExtra("ten_chuyen");
        tvBusName.setText(tenChuyen);

        // Nút đặt vé
        btnBookTicket.setOnClickListener(v -> {
            Intent bookIntent = new Intent(BusDetailsActivity.this, BookingActivity.class);
            bookIntent.putExtra("ten_chuyen", tenChuyen);
            startActivity(bookIntent);
        });
    }
}