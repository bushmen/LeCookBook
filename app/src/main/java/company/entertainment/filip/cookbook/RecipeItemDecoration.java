package company.entertainment.filip.cookbook;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Divider that appears only between two items (it won't show for the last item).
 */
public class RecipeItemDecoration extends RecyclerView.ItemDecoration {

    private final Drawable divider;

    /**
     * Constructs a custom {@link android.support.v7.widget.RecyclerView.ItemDecoration} that sets bottom
     * dividers for each item in the list except for the last one.
     *
     * @param context
     *     Context of the callee.
     * @param dividerResId
     *     Drawable resource that will be used as "dividers" for each row.
     */
    public RecipeItemDecoration(Context context, @DrawableRes int dividerResId) {
        divider = ContextCompat.getDrawable(context, dividerResId);
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() + parent.getPaddingRight();

        // Skip last child because we don't want to add a bottom divider for the last item
        for (int i = 0; i < parent.getChildCount() - 1; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)child.getLayoutParams();

            // Draw bottom border
            int bdTop = child.getBottom() + params.bottomMargin;
            int bdBottom = bdTop + divider.getIntrinsicHeight();
            divider.setBounds(left, bdTop, right, bdBottom);
            divider.draw(canvas);
        }
    }
}
