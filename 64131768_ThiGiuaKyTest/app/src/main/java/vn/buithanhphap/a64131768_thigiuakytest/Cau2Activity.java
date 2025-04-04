package vn.buithanhphap.a64131768_thigiuakytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Cau2Activity extends AppCompatActivity {
    ListView listViewOto;
    ArrayList<String> dsOto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);
        listViewOto = findViewById(R.id.listViewOto);
        dsOto = new ArrayList<String>();
        dsOto.add("TOYOTA");
        dsOto.add("BWM");
        dsOto.add("Honda");
        dsOto.add("Mercedes");
        dsOto.add("KIA");
        ArrayAdapter<String> adapterOto;
        adapterOto = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsOto);
        listViewOto.setAdapter(adapterOto);
        //B4. Gắn bộ lắng nghe và xử lý sự kiện
        listViewOto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //code trực tiếp xử lý ở đây
                //chú ý: biến position đã chứa vị trí của item được click
                String giaTriDuocChon = dsOto.get(position);
                //làm gì đó với giá trị này thì tùy
                //đơn giản, ta Toast lên
                //Toast.makeText(Cau2Activity.this, giaTriDuocChon, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Cau2Activity.this, ChiTietActivity.class);
                intent.putExtra("tenXe", giaTriDuocChon);
                startActivity(intent);
            }
        });
    }
}