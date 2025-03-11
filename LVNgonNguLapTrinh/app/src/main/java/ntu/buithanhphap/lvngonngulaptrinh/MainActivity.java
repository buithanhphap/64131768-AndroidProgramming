package ntu.buithanhphap.lvngonngulaptrinh;

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

public class MainActivity extends AppCompatActivity {

    ListView listViewNNLT;
    ArrayList<String> dsNgonNguLT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewNNLT = findViewById(R.id.listviewNNLT);
        //B1. Chuẩn bị dữ liệu hard-code
        dsNgonNguLT = new ArrayList<String>();
        dsNgonNguLT.add("Python");
        dsNgonNguLT.add("Php");
        dsNgonNguLT.add("C++");
        dsNgonNguLT.add("C#");
        dsNgonNguLT.add("Java");
        //B2.
        ArrayAdapter<String> adapterNNLT;
        adapterNNLT = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsNgonNguLT);
        //B3. Gắn adapter
        listViewNNLT.setAdapter(adapterNNLT);
        //B4. Gắn bộ lắng nghe và xử lý sự kiện
        listViewNNLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //code trực tiếp xử lý ở đây
                //chú ý: biến position đã chứa vị trí của item được click
                String giaTriDuocChon = dsNgonNguLT.get(position);
                //làm gì đó với giá trị này thì tùy
                //đơn giản, ta Toast lên
                Toast.makeText(MainActivity.this, giaTriDuocChon, Toast.LENGTH_SHORT).show();
            }
        });
    }
}