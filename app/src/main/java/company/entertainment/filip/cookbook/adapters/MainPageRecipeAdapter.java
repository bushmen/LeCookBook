package company.entertainment.filip.cookbook.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import company.entertainment.filip.cookbook.R;
import company.entertainment.filip.cookbook.mainpage.viewmodels.RecipeHighlightViewModel;
import company.entertainment.filip.cookbook.viewholders.RecipeHighlightViewHolder;

public class MainPageRecipeAdapter extends RecyclerView.Adapter<RecipeHighlightViewHolder> {
    private List<RecipeHighlightViewModel> data;

    public MainPageRecipeAdapter(List<RecipeHighlightViewModel> data) {
        this.data = data;
    }

    @Override
    public RecipeHighlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_highlight_item_layout, parent, false);
        return new RecipeHighlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeHighlightViewHolder holder, int position) {
        RecipeHighlightViewModel model = data.get(position);
        holder.titleTextView.setText(model.title);
        holder.difficultyBarView.setRating(model.difficulty);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
