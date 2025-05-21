package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DapAnRecyclerAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> arr;
    TextView tvDapAn;
    public DapAnRecyclerAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tra_loi, null);
        }
        tvDapAn = convertView.findViewById(R.id.tvDapAn);
        tvDapAn.setText(this.arr.get(position));
        return convertView;
    }
}
