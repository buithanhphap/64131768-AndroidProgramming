package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "NhinhinhDoanChu.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_QUESTIONS = "questions";
    public static final String TABLE_USERS = "users";

    public static final String CREATE_TABLE_QUESTIONS = "CREATE TABLE " + TABLE_QUESTIONS + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "dapAn TEXT NOT NULL, " +
            "hinhAnh TEXT NOT NULL);";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + " (" +
            "userId TEXT PRIMARY KEY, " +
            "tien INTEGER NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUESTIONS);
        db.execSQL(CREATE_TABLE_USERS);

        // Thêm dữ liệu mẫu
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('yeuot', 'https://freetuts.net/upload/product_series/images/2022/11/16/2598/nhin-hinh-doan-chu-60.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('baocao', 'https://freetuts.net/upload/product_series/images/2022/11/16/2598/nhin-hinh-doan-chu-2.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('cadao', 'https://i.ytimg.com/vi/rHtDfzSPZfc/maxresdefault.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('mitom', 'https://i.ytimg.com/vi/p3RQvawhPvA/sddefault.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('phuyen', 'https://cdn2.tuoitre.vn/thumb_w/480/471584752817336320/2023/4/20/phu-yen-1-16819671427591853833321.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('taomeo', 'https://i.ytimg.com/vi/7UeuqlU4gbE/maxresdefault.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('caheo', 'https://i.ytimg.com/vi/gZqv6D38bc0/maxresdefault.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('nhama', 'https://i.ytimg.com/vi/TgPkpguoi4g/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLBkoMVkfEh5SeAJKp3EzXuVkPrezA');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('halong', 'https://i.ytimg.com/vi/xRxrUtzBiv8/maxresdefault.jpg');");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (dapAn, hinhAnh) VALUES ('nauan', 'https://i.ytimg.com/vi/r_U4PxrY7bw/sddefault.jpg');");
        db.execSQL("INSERT INTO " + TABLE_USERS + " (userId, tien) VALUES ('user1', 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
}