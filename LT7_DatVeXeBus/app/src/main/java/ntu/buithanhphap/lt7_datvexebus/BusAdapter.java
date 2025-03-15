package ntu.buithanhphap.lt7_datvexebus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {
    private ArrayList<String> dsChuyenDi;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String tenChuyen);
    }

    public BusAdapter(ArrayList<String> dsChuyenDi, OnItemClickListener listener) {
        this.dsChuyenDi = dsChuyenDi;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tenChuyen = dsChuyenDi.get(position);
        holder.textView.setText(tenChuyen);
        holder.itemView.setOnClickListener(v -> listener.onItemClick(tenChuyen));
    }

    @Override
    public int getItemCount() {
        return dsChuyenDi.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
