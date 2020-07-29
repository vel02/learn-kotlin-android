package kiz.learnwithvel.yelinc.binding.adpter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import de.hdodenhof.circleimageview.CircleImageView;
import kiz.learnwithvel.yelinc.R;

public class AppAdapter {

    @BindingAdapter({"kiz:showLoading"})
    public static void setLoading(ProgressBar view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter({"kiz:src"})
    public static void setImage(CircleImageView view, Uri source) {
        final Context context = view.getContext();

        Glide.with(context)
                .load(source)
                .thumbnail(Glide.with(context)
                        .load(Uri.parse(context.getString(R.string.user_default_profile))))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }

}
