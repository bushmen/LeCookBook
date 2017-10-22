package company.entertainment.filip.cookbook.mainpage;

import java.util.List;

import company.entertainment.filip.cookbook.mainpage.viewmodels.RecipeHighlightViewModel;

public interface MainView {
    void viewLoaded(List<RecipeHighlightViewModel> recipes);
}
