package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DapAnAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> arr;
    public DapAnAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arr = new ArrayList<>(objects);
    }
}
