package company.entertainment.filip.cookbook.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import company.entertainment.filip.cookbook.R;

public class RatingBarView extends LinearLayout {
    private int rating;
    private Drawable ratingDrawableOn;
    private Drawable ratingDrawableOff;
    private int maxRating;

    public RatingBarView(Context context) {
        super(context);
        init(context, null);
    }

    public RatingBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RatingBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        parseAttributes(context, attrs);
        for (int i = 0; i < maxRating; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.difficulty_rate, this, false);
            ImageView ratingOff = view.findViewById(R.id.difficulty_rate_off);
            ImageView ratingOn = view.findViewById(R.id.difficulty_rate_on);
            ratingOff.setImageDrawable(ratingDrawableOff);
            ratingOn.setImageDrawable(ratingDrawableOn);
            final int position = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(position);
                }
            });
            addView(view);
        }
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView);
            try {
                maxRating = typedArray.getInt(R.styleable.RatingBarView_maxRating, 5);
                ratingDrawableOn = typedArray.getDrawable(R.styleable.RatingBarView_ratingDrawableOn);
                ratingDrawableOff = typedArray.getDrawable(R.styleable.RatingBarView_ratingDrawableOff);
            } finally {
                typedArray.recycle();
            }
        }
    }

    public void setRating(int position) {
        for (int j = 0; j <= position; j++) {
            View childAt = RatingBarView.this.getChildAt(j);
            childAt.findViewById(R.id.difficulty_rate_off).setVisibility(GONE);
            childAt.findViewById(R.id.difficulty_rate_on).setVisibility(VISIBLE);
        }
        for (int j = position + 1; j < 5; j++) {
            View childAt = RatingBarView.this.getChildAt(j);
            childAt.findViewById(R.id.difficulty_rate_off).setVisibility(VISIBLE);
            childAt.findViewById(R.id.difficulty_rate_on).setVisibility(GONE);
        }
        rating = position;
    }

    public int getRating() {
        return rating;
    }
}
