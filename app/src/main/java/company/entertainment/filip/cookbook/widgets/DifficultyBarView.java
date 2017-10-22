package company.entertainment.filip.cookbook.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import company.entertainment.filip.cookbook.R;

public class DifficultyBarView extends LinearLayout {
    private int difficulty;

    public DifficultyBarView(Context context) {
        super(context);
        init();
    }

    public DifficultyBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DifficultyBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        for (int i = 0; i < 5; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.difficulty_rate, this, false);
            final int position = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setDifficulty(position);
                }
            });
            addView(view);
        }
    }

    public void setDifficulty(int position) {
        for (int j = 0; j <= position; j++) {
            View childAt = DifficultyBarView.this.getChildAt(j);
            childAt.findViewById(R.id.difficulty_rate_off).setVisibility(GONE);
            childAt.findViewById(R.id.difficulty_rate_on).setVisibility(VISIBLE);
        }
        for (int j = position + 1; j < 5; j++) {
            View childAt = DifficultyBarView.this.getChildAt(j);
            childAt.findViewById(R.id.difficulty_rate_off).setVisibility(VISIBLE);
            childAt.findViewById(R.id.difficulty_rate_on).setVisibility(GONE);
        }
        difficulty = position;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
