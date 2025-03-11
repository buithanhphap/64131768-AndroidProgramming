package ntu.buithanhphap.lvngonngulaptrinh;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        //B2.
        ArrayAdapter<String> adapterNNLT;
        adapterNNLT = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsNgonNguLT);
        //B3. Gắn adapter
        listViewNNLT.setAdapter(adapterNNLT);
        //B4. Gắn bộ lắng nghe và xử lý sự kiện
    }
}