package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CauHoiDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "HinhCauHoi";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TEN_NAM = "tenNam";
    private static final String COLUMN_DAP_AN = "dapAn";
    private static final String COLUMN_HINH_ANH = "hinhAnh";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEN_NAM + " TEXT, " +
                COLUMN_DAP_AN + " TEXT, " +
                COLUMN_HINH_ANH + " TEXT)";
        db.execSQL(CREATE_TABLE);

        // Thêm dữ liệu mặc định
        insertDefaultData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void insertDefaultData(SQLiteDatabase db) {
        // Dữ liệu
        String[][] defaultData = {
                {"Màn 1", "yeuot", "https://freetuts.net/upload/product_series/images/2022/11/16/2598/nhin-hinh-doan-chu-60.jpg"},
                {"Màn 2", "baocao", "https://freetuts.net/upload/product_series/images/2022/11/16/2598/nhin-hinh-doan-chu-2.jpg"},
                {"Màn 3", "cadao", "https://i.ytimg.com/vi/rHtDfzSPZfc/maxresdefault.jpg"},
                {"Màn 4", "mitom", "https://i.ytimg.com/vi/p3RQvawhPvA/sddefault.jpg"},
                {"Màn 5", "phuyen", "https://cdn2.tuoitre.vn/thumb_w/480/471584752817336320/2023/4/20/phu-yen-1-16819671427591853833321.jpg"},
                {"Màn 6", "taomeo", "https://i.ytimg.com/vi/7UeuqlU4gbE/maxresdefault.jpg"},
                {"Màn 7", "caheo", "https://i.ytimg.com/vi/gZqv6D38bc0/maxresdefault.jpg"},
                {"Màn 8", "nhama", "https://i.ytimg.com/vi/TgPkpguoi4g/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLBkoMVkfEh5SeAJKp3EzXuVkPrezA"},
                {"Màn 9", "halong", "https://i.ytimg.com/vi/xRxrUtzBiv8/maxresdefault.jpg"},
                {"Màn 10", "nauan", "https://i.ytimg.com/vi/r_U4PxrY7bw/sddefault.jpg"}
        };

        for (String[] data : defaultData) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_TEN_NAM, data[0]);
            values.put(COLUMN_DAP_AN, data[1]);
            values.put(COLUMN_HINH_ANH, data[2]);
            db.insert(TABLE_NAME, null, values);
        }
    }

    public ArrayList<HinhCauHoi> getAllCauHoi() {
        ArrayList<HinhCauHoi> cauHoiList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        android.database.Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                HinhCauHoi cauHoi = new HinhCauHoi(
                        cursor.getString(1), // tenNam
                        cursor.getString(2), // dapAn
                        cursor.getString(3)  // hinhAnh
                );
                cauHoiList.add(cauHoi);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return cauHoiList;
    }
}