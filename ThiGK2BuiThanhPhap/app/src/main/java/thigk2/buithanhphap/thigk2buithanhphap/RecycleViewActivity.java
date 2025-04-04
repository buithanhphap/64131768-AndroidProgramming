package thigk2.buithanhphap.thigk2buithanhphap;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //3
        recyclerViewDatas = getDataForRecyclerView();
        //4
        recyclerViewLandscape = findViewById(R.id.recylerLand);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandscape.setLayoutManager(layoutLinear);
        //6
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewDatas);
        //7
        recyclerViewLandscape.setAdapter(landScapeAdapter);
    }
    ArrayList<LandScape> getDataForRecyclerView() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("datnuoc","95 ngày thành lập đảng");
        dsDuLieu.add(landScape1);
        dsDuLieu.add( new LandScape("datnuoc1", "Quốc te phụ nữ"));
        dsDuLieu.add( new LandScape("datnuoc2", "Rước đèn ông sao"));
        return dsDuLieu;
    }
}