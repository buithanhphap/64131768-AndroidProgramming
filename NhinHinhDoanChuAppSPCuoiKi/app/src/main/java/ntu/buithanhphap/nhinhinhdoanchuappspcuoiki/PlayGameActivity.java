package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    PlayGameModel models;
    HinhCauHoi hinhCauHoi;
    ArrayList<String> ArrDapAn;
    GridView gdvDapAn;
    ArrayList<String> ArrNhapDapAn;
    GridView gdvNhapDapAn;
     private String dapAn="CADAO";
     int index = 0;
    ArrayList<Integer> ViTriBanDau;
    ImageView imgHinhCauHoi, imghomeIcon;
    TextView tvTien, tvMan;
    // Launcher để nhận kết quả từ QuaManMainActivity
    private ActivityResultLauncher<Intent> quaManActivityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        //Tim dieu khien
        gdvDapAn = findViewById(R.id.gdvDapAn);
        gdvNhapDapAn = findViewById(R.id.gdvNhapDapAn);
        imgHinhCauHoi = findViewById(R.id.imgHinhCauHoi);
        tvTien = findViewById(R.id.tvTien);
        tvMan = findViewById(R.id.tvManSo);
        imghomeIcon = findViewById(R.id.imgHomeIcon);
        imghomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayGameActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // Khởi tạo launcher để nhận kết quả từ QuaManMainActivity
        quaManActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            // Khi người chơi nhấn "TIẾP TỤC", chuyển sang câu hỏi tiếp theo
                            models.NextCauHoi();
                            HienHinhCauHoi();
                        }
                    }
                });
        OnClick();
        // Khởi tạo dữ liệu
        models = new PlayGameModel(this);
        ArrDapAn = new ArrayList<>();
        ArrNhapDapAn = new ArrayList<>();
        ViTriBanDau = new ArrayList<>();
        HienHinhCauHoi();
    }
    private void HienDungODapAn() {
        index =0;
        ArrDapAn.clear();
        ArrNhapDapAn.clear();
        ViTriBanDau.clear();
        Random random = new Random();

        // Khởi tạo arrDapAn với các ô trống
        for (int i = 0; i < dapAn.length(); i++) {
            ArrDapAn.add("");
            ViTriBanDau.add(-1);
        }

        // Thêm các ký tự của dapAn (chữ hoa) vào arrNhapDapAn
        for (int i = 0; i < dapAn.length(); i++) {
            ArrNhapDapAn.add(String.valueOf(dapAn.charAt(i)).toUpperCase());
        }

        // Thêm các ký tự ngẫu nhiên từ A đến Z để đủ 10 ký tự
        while (ArrNhapDapAn.size() < 10) {
            char randomChar = (char) ('A' + random.nextInt(26));
            ArrNhapDapAn.add(String.valueOf(randomChar));
        }
        // Xáo trộn các ký tự trong ArrNhapDapAn
        Collections.shuffle(ArrNhapDapAn);
    }
    private void OnClick() {
        gdvNhapDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String c = (String) parent.getItemAtPosition(position);
                if (c.length() != 0 && index < ArrDapAn.size()) {
                    // Tìm ô trống tiếp theo nếu ô hiện tại đã được điền
                    if (ArrDapAn.get(index).length() != 0) {
                        for (int i = 0; i < ArrDapAn.size(); i++) {
                            if (ArrDapAn.get(i).isEmpty()) {
                                index = i;
                                break;
                            }
                        }
                        if (ArrDapAn.get(index).length() != 0) {
                            return; // Không còn ô trống để nhập
                        }
                    }
                    ArrNhapDapAn.set(position, "");
                    ArrDapAn.set(index, c);
                    ViTriBanDau.set(index, position);
                    index++;
                    // Cập nhật lại adapter
                    gdvDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrDapAn));
                    gdvNhapDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrNhapDapAn));
                    if (index == ArrDapAn.size()) {
                        KiemTraDapAn();
                    }
                }
            }
        });
        gdvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String c = (String) parent.getItemAtPosition(position);
                if(c.length() != 0){
                    // Xóa ký tự tại vị trí được chọn
                    ArrDapAn.set(position, "");
                    // Trả ký tự về đúng vị trí ban đầu trong ArrNhapDapAn
                    int vitribd = ViTriBanDau.get(position);
                    if (vitribd != -1) {
                        ArrNhapDapAn.set(vitribd, c);
                    }
                    // Tìm vị trí trống đầu tiên từ trái sang phải để đặt lại index
                    index = 0;
                    for (int i = 0; i < ArrDapAn.size(); i++) {
                        if (ArrDapAn.get(i).length() == 0) {
                            index = i;
                            break;
                        }
                    }
                    // Đặt lại vị trí gốc của ô này
                    ViTriBanDau.set(position, -1);
                    // Cập nhật lại adapter
                    gdvDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrDapAn));
                    gdvNhapDapAn.setAdapter(new DapAnAdapter(PlayGameActivity.this, 0, ArrNhapDapAn));
                }
            }
        });
    }
    private void KiemTraDapAn(){
        String c = "";
        for(String c1:ArrDapAn){
            c += c1;
        }
        c = c.toUpperCase();
        if(c.equals(dapAn.toUpperCase())){
            Toast.makeText(this, "Bạn đã trả lời đúng",Toast.LENGTH_SHORT).show();
            models.layThongTin();
            models.nguoiChoi.tien = models.nguoiChoi.tien + 15;
            models.luuThongTin();
            // Chuyển sang QuaManMainActivity nếu còn câu hỏi, hoặc KetThucGameMainActivity nếu hết
            if (models.cauSo + 1 >= models.arr.size()) {
                Intent intent = new Intent(PlayGameActivity.this, KetThucGameMainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(PlayGameActivity.this, QuaManMainActivity.class);
                quaManActivityLauncher.launch(intent);
            }
        } else {
            Toast.makeText(this, "Câu trả lời của bạn đã sai", Toast.LENGTH_SHORT).show();
        }
    }
    private void HienHinhCauHoi(){
        hinhCauHoi = models.LayHinhCauHoi();
        dapAn = hinhCauHoi.dapAn;
        HienDungODapAn();
        // Set số cột bằng đúng số lượng phần tử => nằm ngang
        gdvDapAn.setNumColumns(ArrDapAn.size());
        // Gán adapter
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, ArrDapAn));
        // Set số cột bằng đúng số lượng phần tử => nằm ngang
        gdvNhapDapAn.setNumColumns(ArrNhapDapAn.size()/2);
        // Gán adapter
        gdvNhapDapAn.setAdapter(new DapAnAdapter(this, 0, ArrNhapDapAn));
        Glide.with(this)
                .load(hinhCauHoi.hinhAnh)
                .into(imgHinhCauHoi);
        models.layThongTin();
        tvTien.setText(models.nguoiChoi.tien+"");
    }

    public void GoiY(View view) {

        // Kiểm tra số tiền
        models.layThongTin();
        if (models.nguoiChoi.tien < 10) {
            Toast.makeText(this, "Bạn không đủ tiền! Cần 10 đồng xu để nhận gợi ý.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra xem đã điền hết đáp án chưa
        boolean allFilled = true;
        for (String s : ArrDapAn) {
            if (s.isEmpty()) {
                allFilled = false;
                break;
            }
        }
        if (allFilled) {
            Toast.makeText(this, "Bạn đã điền hết đáp án!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Nếu chưa điền gì (index == 0), chọn ngẫu nhiên một vị trí
        int pos;
        Random random = new Random();
        if (index == 0) {
            pos = random.nextInt(ArrDapAn.size()); // Chọn ngẫu nhiên một vị trí
            while (!ArrDapAn.get(pos).isEmpty()) { // Đảm bảo vị trí này trống
                pos = random.nextInt(ArrDapAn.size());
            }
        } else {
            // Tìm ô trống tiếp theo
            pos = -1;
            for (int i = 0; i < ArrDapAn.size(); i++) {
                if (ArrDapAn.get(i).isEmpty()) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                Toast.makeText(this, "Không tìm thấy ô trống!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Lấy ký tự đúng tại vị trí pos từ dapAn
        String correctChar = String.valueOf(dapAn.charAt(pos)).toUpperCase();

        // Tìm ký tự này trong ArrNhapDapAn
        int charPos = -1;
        for (int i = 0; i < ArrNhapDapAn.size(); i++) {
            if (ArrNhapDapAn.get(i).equals(correctChar)) {
                charPos = i;
                break;
            }
        }

        if (charPos == -1) {
            Toast.makeText(this, "Không tìm thấy ký tự gợi ý trong danh sách!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Điền ký tự gợi ý vào ArrDapAn và xóa khỏi ArrNhapDapAn
        ArrNhapDapAn.set(charPos, "");
        ArrDapAn.set(pos, correctChar);
        ViTriBanDau.set(pos, charPos); // Lưu vị trí gốc để có thể hoàn tác
        index = pos + 1; // Cập nhật index để chỉ đến ô trống tiếp theo
        if (index >= ArrDapAn.size()) {
            index = ArrDapAn.size(); // Đảm bảo index không vượt quá kích thước
        }

        // Cập nhật adapter
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, ArrDapAn));
        gdvNhapDapAn.setAdapter(new DapAnAdapter(this, 0, ArrNhapDapAn));

        // Kiểm tra nếu đã điền hết đáp án
        if (index == ArrDapAn.size()) {
            KiemTraDapAn();
        }

        // Trừ tiền và cập nhật giao diện
        models.layThongTin();
        models.nguoiChoi.tien -= 10;
        models.luuThongTin();
        tvTien.setText(String.valueOf(models.nguoiChoi.tien));
        Toast.makeText(this, "Đã gợi ý ký tự: " + correctChar, Toast.LENGTH_SHORT).show();
    }
    public void CauTiepTheo(View view) {
        // Kiểm tra số tiền
        models.layThongTin();
        if (models.nguoiChoi.tien < 10) {
            Toast.makeText(this, "Bạn không đủ tiền! Cần 10 đồng xu để chuyển câu hỏi khác.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kiểm tra xem có còn câu hỏi tiếp theo không
        if (models.cauSo + 1 >= models.arr.size()) {
            Toast.makeText(this, "Bạn đã hoàn thành tất cả câu hỏi!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PlayGameActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // Trừ tiền và lưu
        models.nguoiChoi.tien -= 10;
        models.luuThongTin();
        tvTien.setText(String.valueOf(models.nguoiChoi.tien));

        // Chuyển sang câu hỏi tiếp theo
        models.NextCauHoi();
        HienHinhCauHoi();
        Toast.makeText(this, "Đã chuyển sang câu hỏi tiếp theo. Trừ 10 đồng xu.", Toast.LENGTH_SHORT).show();
    }
}