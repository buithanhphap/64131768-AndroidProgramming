package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    PlayGameModel models;
    HinhCauHoi hinhCauHoi;
    ArrayList<String> ArrDapAn;
    private RecyclerView rvDapAn, rvNhapDapAn;
    ArrayList<String> ArrNhapDapAn;
    private String dapAn = "CADAO";
    int index = 0;
    ArrayList<Integer> ViTriBanDau;
    ImageView imgHinhCauHoi, imgHomeIcon;
    TextView tvTien, tvManSo;
    private ActivityResultLauncher<Intent> quaManActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        // Tìm điều khiển
        rvDapAn = findViewById(R.id.rvDapAn);
        rvNhapDapAn = findViewById(R.id.rvNhapDapAn);
        imgHinhCauHoi = findViewById(R.id.imgHinhCauHoi);
        tvTien = findViewById(R.id.tvTien);
        imgHomeIcon = findViewById(R.id.imgHomeIcon);
        tvManSo = findViewById(R.id.tvManSo);

        // Sự kiện click cho imgHomeIcon
        imgHomeIcon.setOnClickListener(v -> {
            Intent intent = new Intent(PlayGameActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        // Khởi tạo launcher để nhận kết quả từ QuaManMainActivity
        quaManActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        models.NextCauHoi();
                        HienHinhCauHoi();
                    }
                });

        // Khởi tạo dữ liệu
        models = new PlayGameModel(this);
        ArrDapAn = new ArrayList<>();
        ArrNhapDapAn = new ArrayList<>();
        ViTriBanDau = new ArrayList<>();
        HienHinhCauHoi();
    }

    private void HienDungODapAn() {
        index = 0;
        ArrDapAn.clear();
        ArrNhapDapAn.clear();
        ViTriBanDau.clear();
        Random random = new Random();

        // Khởi tạo ArrDapAn với các ô trống
        for (int i = 0; i < dapAn.length(); i++) {
            ArrDapAn.add("");
            ViTriBanDau.add(-1);
        }

        // Thêm các ký tự của dapAn (chữ hoa) vào ArrNhapDapAn
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

    private void HienHinhCauHoi() {
        hinhCauHoi = models.LayHinhCauHoi();
        if (hinhCauHoi == null) {
            Toast.makeText(this, "Hết câu hỏi!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        dapAn = hinhCauHoi.dapAn;
        HienDungODapAn();

        // Thiết lập RecyclerView
        rvDapAn.setLayoutManager(new GridLayoutManager(this, ArrDapAn.size()));
        rvDapAn.setAdapter(new DapAnRecyclerAdapter(this, ArrDapAn, true));

        rvNhapDapAn.setLayoutManager(new GridLayoutManager(this, ArrNhapDapAn.size() / 2));
        rvNhapDapAn.setAdapter(new DapAnRecyclerAdapter(this, ArrNhapDapAn, false));

        // Tải hình ảnh câu hỏi
        Glide.with(this)
                .load(hinhCauHoi.hinhAnh)
                .into(imgHinhCauHoi);

        tvManSo.setText("Màn " + (models.getCauSo() + 1));
        models.layThongTin();
        tvTien.setText(models.nguoiChoi.tien + "");
    }

    private void KiemTraDapAn() {
        String c = "";
        for (String c1 : ArrDapAn) {
            c += c1;
        }
        c = c.toUpperCase();
        if (c.equals(dapAn.toUpperCase())) {
            CustomToast.makeText(
                    this,
                    "Bạn đã trả lời đúng",
                    Toast.LENGTH_SHORT,
                    CustomToast.SUCCESS,
                    true
            ).show();
            models.layThongTin();
            models.nguoiChoi.tien = models.nguoiChoi.tien + 15;
            models.luuThongTin();
            if (models.getCauSo() + 1 >= models.arr.size()) {
                Intent intent = new Intent(PlayGameActivity.this, KetThucGameMainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(PlayGameActivity.this, QuaManMainActivity.class);
                quaManActivityLauncher.launch(intent);
            }
        } else {
            CustomToast.makeText(
                    this,
                    "Câu trả lời của bạn đã sai",
                    Toast.LENGTH_SHORT,
                    CustomToast.ERROR,
                    true
            ).show();
        }
    }

    // Thêm getter để truy cập rvDapAn và rvNhapDapAn
    public RecyclerView getRvDapAn() {
        return rvDapAn;
    }

    public RecyclerView getRvNhapDapAn() {
        return rvNhapDapAn;
    }

    // Thêm phương thức công khai để gọi KiemTraDapAn
    public void checkAnswer() {
        KiemTraDapAn();
    }
    // Thêm getter cho các biến
    public ArrayList<String> getArrDapAn() {
        return ArrDapAn;
    }

    public ArrayList<String> getArrNhapDapAn() {
        return ArrNhapDapAn;
    }

    public ArrayList<Integer> getViTriBanDau() {
        return ViTriBanDau;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public void GoiY(View view) {
        models.layThongTin();
        if (models.nguoiChoi.tien < 10) {
            CustomToast.makeText(
                    this,
                    "Bạn không đủ tiền! Cần 10 đồng xu để nhận gợi ý.",
                    Toast.LENGTH_SHORT,
                    CustomToast.WARNING,
                    true
            ).show();
            return;
        }

        boolean allFilled = true;
        for (String s : getArrDapAn()) {
            if (s.isEmpty()) {
                allFilled = false;
                break;
            }
        }
        if (allFilled) {
            CustomToast.makeText(
                    this,
                    "Bạn đã điền hết đáp án.",
                    Toast.LENGTH_SHORT,
                    CustomToast.WARNING,
                    true
            ).show();
            return;
        }

        int pos;
        Random random = new Random();
        if (getIndex() == 0) {
            do {
                pos = random.nextInt(getArrDapAn().size());
            } while (!getArrDapAn().get(pos).isEmpty());
        } else {
            pos = -1;
            for (int i = 0; i < getArrDapAn().size(); i++) {
                if (getArrDapAn().get(i).isEmpty()) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                CustomToast.makeText(
                        this,
                        "Không tìm thấy ô trống!",
                        Toast.LENGTH_SHORT,
                        CustomToast.WARNING,
                        true
                ).show();
                return;
            }
        }

        String correctChar = String.valueOf(dapAn.charAt(pos)).toUpperCase();
        int charPos = -1;
        for (int i = 0; i < getArrNhapDapAn().size(); i++) {
            if (getArrNhapDapAn().get(i).equals(correctChar)) {
                charPos = i;
                break;
            }
        }
        if (charPos == -1) {
            CustomToast.makeText(
                    this,
                    "Không tìm thấy ký tự trong danh sách!",
                    Toast.LENGTH_SHORT,
                    CustomToast.WARNING,
                    true
            ).show();
            return;
        }

        getArrNhapDapAn().set(charPos, "");
        getArrDapAn().set(pos, correctChar);
        getViTriBanDau().set(pos, charPos);

        if (pos > 0) {
            setIndex(0);
        } else {
            setIndex(pos + 1);
        }
        if (getIndex() >= getArrDapAn().size()) {
            setIndex(getArrDapAn().size());
        }

        rvDapAn.getAdapter().notifyDataSetChanged();
        rvNhapDapAn.getAdapter().notifyDataSetChanged();

        models.nguoiChoi.tien -= 10;
        models.luuThongTin();
        tvTien.setText(String.valueOf(models.nguoiChoi.tien));

        CustomToast.makeText(
                this,
                "Đã gợi ý ký tự: " + correctChar,
                Toast.LENGTH_SHORT,
                CustomToast.SUCCESS,
                true
        ).show();

        // Kiểm tra đáp án sau khi gợi ý
        if (isAllFilled()) {
            checkAnswer();
        }
    }

    public boolean isAllFilled() {
        for (String s : getArrDapAn()) {
            if (s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void CauTiepTheo(View view) {
        models.layThongTin();
        if (models.nguoiChoi.tien < 10) {
            CustomToast.makeText(
                    this,
                    "Bạn không đủ tiền! Cần 10 đồng xu để chuyển câu hỏi khác.",
                    Toast.LENGTH_SHORT,
                    CustomToast.WARNING,
                    true
            ).show();
            return;
        }

        if (models.getCauSo() == models.arr.size() - 1) {
            CustomToast.makeText(
                    this,
                    "Đã hết câu hỏi.",
                    Toast.LENGTH_SHORT,
                    CustomToast.WARNING,
                    true
            ).show();
            return;
        }

        models.nguoiChoi.tien -= 10;
        models.luuThongTin();
        tvTien.setText(String.valueOf(models.nguoiChoi.tien));

        models.NextCauHoi();
        HienHinhCauHoi();

        CustomToast.makeText(
                this,
                "Đã chuyển sang câu hỏi tiếp theo. Trừ 10 đồng xu.",
                Toast.LENGTH_SHORT,
                CustomToast.SUCCESS,
                true
        ).show();
    }
}