package company.entertainment.filip.cookbook.mainpage;

import java.util.ArrayList;
import java.util.List;

import company.entertainment.filip.cookbook.mainpage.viewmodels.RecipeHighlightViewModel;

public class MainLocalPresenter implements MainPresenter{
    private MainView mainView;

    public MainLocalPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void loadBooks() {
        //TODO load books from server/database locally stored
        mainView.viewLoaded(getRecipes());
    }

    private List<RecipeHighlightViewModel> getRecipes() {
        List<RecipeHighlightViewModel> recipes = new ArrayList<>();
        recipes.add(getMockRecipe("Roasted duck with potatoes"));
        recipes.add(getMockRecipe("Pierogis"));
        recipes.add(getMockRecipe("Teryiaki Salmon"));
        recipes.add(getMockRecipe("Vegetarian Spring Rolls"));
        recipes.add(getMockRecipe("Donuts"));
        recipes.add(getMockRecipe("Shrimp Korma Roti"));
        return recipes;
    }

    private RecipeHighlightViewModel getMockRecipe(String title) {
        RecipeHighlightViewModel recipeHighlightViewModel = new RecipeHighlightViewModel();
        recipeHighlightViewModel.title = title;
        recipeHighlightViewModel.timeToPrepare = (int)(90 * Math.random());
        recipeHighlightViewModel.difficulty = (int)(4 * Math.random());
        recipeHighlightViewModel.rating = (int)(4 * Math.random()) + 1;
        recipeHighlightViewModel.isGlutenFree = Math.random() < 0.5f;
        recipeHighlightViewModel.isVegetarian = Math.random() < 0.5f;
        recipeHighlightViewModel.servesPeople = (int)(6 * Math.random()) + 1;
        return recipeHighlightViewModel;
    }
}
