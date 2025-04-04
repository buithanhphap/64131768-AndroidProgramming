package thigk2.buithanhphap.thigk2buithanhphap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {
    ListView listViewBaiHat;
    ArrayList<String> dsBaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        listViewBaiHat = findViewById(R.id.ListViewBaiHat);
        dsBaiHat = new ArrayList<String>();
        dsBaiHat.add("Tiến về Sài Gòn");
        dsBaiHat.add("Giải phóng Miền nam");
        dsBaiHat.add("Dất nước trọn nềm vui");
        dsBaiHat.add("Bài ca thống nhất");
        dsBaiHat.add("Mùa xuân trên thành phố HCM");
        dsBaiHat.add("...");
        ArrayAdapter<String> adapterBaiHat;
        adapterBaiHat = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsBaiHat);
        listViewBaiHat.setAdapter(adapterBaiHat);
        listViewBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String giaTriDuocChon = dsBaiHat.get(position);
                Intent intent = new Intent(ItemActivity.this, Item3Activity.class);
                intent.putExtra("tenBaiHat", giaTriDuocChon);
                startActivity(intent);
            }
        });
    }
}