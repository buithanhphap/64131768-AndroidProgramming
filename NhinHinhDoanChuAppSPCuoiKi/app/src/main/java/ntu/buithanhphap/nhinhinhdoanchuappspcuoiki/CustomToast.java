package ntu.buithanhphap.nhinhinhdoanchuappspcuoiki;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ntu.buithanhphap.nhinhinhdoanchuappspcuoiki.R;

public class CustomToast extends Toast {

    public static int SUCCESS = 1;
    public static int WARNING = 2;
    public static int ERROR = 3;
    public static int CONFUSING = 4;

    private static long SHORT = 4000;
    private static long LONG = 7000;

    public CustomToast(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, String message, int duration, int type, boolean androidicon) {
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        View layout = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        TextView l1 = (TextView) layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = (LinearLayout) layout.findViewById(R.id.toast_type);
        ImageView img = (ImageView) layout.findViewById(R.id.toast_icon);
        ImageView img1 = (ImageView) layout.findViewById(R.id.imageView4);
        l1.setText(message);
        if (androidicon == true)
            img1.setVisibility(View.VISIBLE);
        else if (androidicon == false)
            img1.setVisibility(View.GONE);
        if (type == 1) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
            img.setImageResource(R.drawable.ic_check_black_24dp);
        } else if (type == 2) {
            linearLayout.setBackgroundResource(R.drawable.warning_shape);
            img.setImageResource(R.drawable.ic_pan_tool_black_24dp);
        } else if (type == 3) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
            img.setImageResource(R.drawable.ic_clear_black_24dp);
        } else if (type == 4) {
            linearLayout.setBackgroundResource(R.drawable.confusing_shape);
            img.setImageResource(R.drawable.ic_refresh_black_24dp);
        }
        toast.setView(layout);
        // Đặt vị trí Toast: cách đáy 100px (có thể điều chỉnh)
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 250);
        return toast;
    }

    public static Toast makeText(Context context, String message, int duration, int type, int ImageResource) {
        Toast toast = new Toast(context);
        View layout = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        TextView l1 = (TextView) layout.findViewById(R.id.toast_text);
        LinearLayout linearLayout = (LinearLayout) layout.findViewById(R.id.toast_type);
        ImageView img = (ImageView) layout.findViewById(R.id.toast_icon);
        l1.setText(message);
        if (type == 1) {
            linearLayout.setBackgroundResource(R.drawable.success_shape);
            img.setImageResource(ImageResource);
        } else if (type == 2) {
            linearLayout.setBackgroundResource(R.drawable.warning_shape);
            img.setImageResource(ImageResource);
        } else if (type == 3) {
            linearLayout.setBackgroundResource(R.drawable.error_shape);
            img.setImageResource(ImageResource);
        } else if (type == 4) {
            linearLayout.setBackgroundResource(R.drawable.confusing_shape);
            img.setImageResource(ImageResource);
        }
        toast.setView(layout);
        // Đặt vị trí Toast: cách đáy 100px (có thể điều chỉnh)
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 250);
        return toast;
    }

}
