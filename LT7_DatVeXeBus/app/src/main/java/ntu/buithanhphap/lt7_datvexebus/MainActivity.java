package ntu.buithanhphap.lt7_datvexebus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> dsChuyenDi;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewBuses);

        // B1: Chuẩn bị dữ liệu chuyến đi
        dsChuyenDi = new ArrayList<>();
        dsChuyenDi.add("Hà Nội - Đà Nẵng");
        dsChuyenDi.add("Hà Nội - Sài Gòn");
        dsChuyenDi.add("Đà Nẵng - Nha Trang");
        dsChuyenDi.add("Sài Gòn - Cần Thơ");
        dsChuyenDi.add("Nha Trang - Sài Gòn");
        dsChuyenDi.add("Cam Ranh - Hà Nội");

        // B2: Gắn Adapter cho ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsChuyenDi);
        listView.setAdapter(adapter);

        // B3: Xử lý sự kiện khi bấm vào chuyến xe
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tenChuyen = dsChuyenDi.get(position);
                Toast.makeText(MainActivity.this, "Bạn chọn: " + tenChuyen, Toast.LENGTH_SHORT).show();

                // Chuyển qua màn hình Chi tiết chuyến đi
                Intent intent = new Intent(MainActivity.this, BusDetailsActivity.class);
                intent.putExtra("ten_chuyen", tenChuyen);
                startActivity(intent);
            }
        });
    }
}
