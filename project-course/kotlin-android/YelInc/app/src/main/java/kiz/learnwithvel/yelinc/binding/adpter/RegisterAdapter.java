package kiz.learnwithvel.yelinc.binding.adpter;

import android.view.View;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;

public class RegisterAdapter {

    @BindingAdapter({"kiz:showLoading"})
    public static void setLoading(ProgressBar view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

}
