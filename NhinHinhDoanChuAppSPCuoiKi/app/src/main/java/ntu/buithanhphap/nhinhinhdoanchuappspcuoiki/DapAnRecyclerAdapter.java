package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DapAnRecyclerAdapter extends RecyclerView.Adapter<DapAnRecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> data;
    private boolean isDapAnGrid; // Phân biệt giữa rvDapAn và rvNhapDapAn
    private PlayGameActivity activity;

    public DapAnRecyclerAdapter(Context context, ArrayList<String> data, boolean isDapAnGrid) {
        this.context = context;
        this.data = data;
        this.isDapAnGrid = isDapAnGrid;
        this.activity = (PlayGameActivity) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tra_loi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String charStr = data.get(position);
        holder.tvChar.setText(charStr);
        holder.itemView.setOnClickListener(v -> {
            if (isDapAnGrid) {
                // Xử lý click cho rvDapAn (xóa ký tự)
                if (charStr.length() != 0) {
                    int vitribd = activity.getViTriBanDau().get(position);
                    if (vitribd != -1) {
                        activity.getArrNhapDapAn().set(vitribd, charStr);
                    }
                    activity.getArrDapAn().set(position, "");
                    activity.setIndex(0);
                    for (int i = 0; i < activity.getArrDapAn().size(); i++) {
                        if (activity.getArrDapAn().get(i).isEmpty()) {
                            activity.setIndex(i);
                            break;
                        }
                    }
                    activity.getViTriBanDau().set(position, -1);
                    notifyDataSetChanged();
                    activity.getRvNhapDapAn().getAdapter().notifyDataSetChanged();
                }
            } else {
                // Xử lý click cho rvNhapDapAn (điền ký tự)
                if (charStr.length() != 0 && activity.getIndex() < activity.getArrDapAn().size()) {
                    if (activity.getArrDapAn().get(activity.getIndex()).length() != 0) {
                        for (int i = 0; i < activity.getArrDapAn().size(); i++) {
                            if (activity.getArrDapAn().get(i).isEmpty()) {
                                activity.setIndex(i);
                                break;
                            }
                        }
                        if (activity.getArrDapAn().get(activity.getIndex()).length() != 0) return;
                    }
                    activity.getArrNhapDapAn().set(position, "");
                    activity.getArrDapAn().set(activity.getIndex(), charStr);
                    activity.getViTriBanDau().set(activity.getIndex(), position);
                    activity.setIndex(activity.getIndex() + 1);
                    notifyDataSetChanged();
                    activity.getRvDapAn().getAdapter().notifyDataSetChanged();
                    if (activity.isAllFilled()) {
                        activity.checkAnswer();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvChar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChar = itemView.findViewById(R.id.tvChar);
        }
    }
}