package ntu.buithanhphap.lt7_datvexebus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> dsChuyenDi;
    BusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewBuses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // B1: Chuẩn bị dữ liệu chuyến đi
        dsChuyenDi = new ArrayList<>();
        dsChuyenDi.add("Hà Nội - Đà Nẵng");
        dsChuyenDi.add("Hà Nội - Sài Gòn");
        dsChuyenDi.add("Đà Nẵng - Nha Trang");
        dsChuyenDi.add("Sài Gòn - Cần Thơ");

        // B2: Gắn Adapter cho RecyclerView
        adapter = new BusAdapter(dsChuyenDi, new BusAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String tenChuyen) {
                // Hiển thị Toast khi chọn chuyến xe
                Toast.makeText(MainActivity.this, "Bạn chọn: " + tenChuyen, Toast.LENGTH_SHORT).show();

                // Chuyển qua màn hình Chi tiết chuyến đi
                Intent intent = new Intent(MainActivity.this, BusDetailsActivity.class);
                intent.putExtra("ten_chuyen", tenChuyen);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
