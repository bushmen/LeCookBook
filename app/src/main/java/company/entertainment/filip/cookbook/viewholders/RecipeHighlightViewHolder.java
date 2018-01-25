package company.entertainment.filip.cookbook.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import company.entertainment.filip.cookbook.R;
import company.entertainment.filip.cookbook.widgets.RatingBarView;

public class RecipeHighlightViewHolder extends RecyclerView.ViewHolder {
    public RatingBarView difficultyBarView;
    public TextView titleTextView;

    public RecipeHighlightViewHolder(View itemView) {
        super(itemView);
        difficultyBarView = itemView.findViewById(R.id.difficulty_bar_view);
        titleTextView = itemView.findViewById(R.id.recipe_title);
    }
}
