package company.entertainment.filip.cookbook.mainpage;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import company.entertainment.filip.cookbook.BaseActivity;
import company.entertainment.filip.cookbook.R;
import company.entertainment.filip.cookbook.adapters.MainPageRecipeAdapter;
import company.entertainment.filip.cookbook.mainpage.viewmodels.RecipeHighlightViewModel;

public class MainActivity extends BaseActivity implements MainView {
    private MainPresenter presenter;
    private RecyclerView recipesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        recipesRecyclerView = (RecyclerView)findViewById(R.id.recipes_recycler_view);

        toolbar.setTitle(getResources().getString(R.string.main_activity_title));
        presenter = new MainLocalPresenter(this);
        presenter.loadBooks();
    }

    @Override
    public void viewLoaded(List<RecipeHighlightViewModel> recipes) {
        recipesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recipesRecyclerView.setAdapter(new MainPageRecipeAdapter(recipes));
    }
}
