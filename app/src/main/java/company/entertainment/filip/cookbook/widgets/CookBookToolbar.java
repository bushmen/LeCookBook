package company.entertainment.filip.cookbook.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import company.entertainment.filip.cookbook.R;

public class CookBookToolbar extends Toolbar {
    private ImageView hamburgerMenuImageView;
    private TextView toolbarTitleTextView;

    public CookBookToolbar(Context context) {
        super(context);
        init();
    }

    public CookBookToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CookBookToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.toolbar_layout, this, true);

        hamburgerMenuImageView = findViewById(R.id.hamburger_menu);
        toolbarTitleTextView = findViewById(R.id.toolbar_title);
    }

    public void hamburgerMenuEnabled(boolean enabled) {
        hamburgerMenuImageView.setVisibility(enabled ? VISIBLE : GONE);
    }

    public void setTitle(String title) {
        toolbarTitleTextView.setText(title);
    }
}
