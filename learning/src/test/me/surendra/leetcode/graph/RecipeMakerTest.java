package me.surendra.leetcode.graph;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RecipeMakerTest {

    private List<String> callMethod(final String[] recipes, final List<List<String>> ingredients, final String[] supplies) {
        final RecipeMaker recipeMaker = new RecipeMaker();

        return recipeMaker.findAllRecipesUsingTopologySort(recipes, ingredients, supplies);
//        return recipeMaker.findAllRecipes(recipes, ingredients, supplies);
    }

    @Test
    public void recipeOnly() {
        final String[] recipes = {"bread"};
        final List<List<String>> ingredients = Arrays.asList(
            Arrays.asList("yeast", "flour")
        );
        final String[] supplies = {"yeast", "flour", "corn"};

        // execute
        final List<String> actualRecipeList = callMethod(recipes, ingredients, supplies);

        final List<String> expectedRecipeList = Arrays.asList("bread");
        assertThat(actualRecipeList, equalTo(expectedRecipeList));
    }


    @Test
    public void recipeContainsRecipe() {
        final String[] recipes = {"bread", "sandwich"};
        final List<List<String>> ingredients = Arrays.asList(
            Arrays.asList("yeast", "flour"),
            Arrays.asList("bread", "meat")
        );
        final String[] supplies = {"yeast", "flour", "meat"};

        // execute
        final List<String> actualRecipeList = callMethod(recipes, ingredients, supplies);

        final List<String> expectedRecipeList = Arrays.asList("bread", "sandwich");
        assertThat(actualRecipeList, equalTo(expectedRecipeList));
    }

    @Test
    public void recipeContainsRecipeWhichContainsRecipe() {
        final String[] recipes = {"bread",  "sandwich",  "burger"};
        final List<List<String>> ingredients = Arrays.asList(
            Arrays.asList("yeast", "flour"),
            Arrays.asList("bread", "meat"),
            Arrays.asList("sandwich",  "meat",  "bread")
        );
        final String[] supplies = {"yeast", "flour", "meat"};

        // execute
        final List<String> actualRecipeList = callMethod(recipes, ingredients, supplies);

        final List<String> expectedRecipeList = Arrays.asList("bread", "sandwich", "burger");
        assertThat(actualRecipeList, equalTo(expectedRecipeList));
    }

    @Test
    public void recipeContainsCycleRecipes() {
        final String[] recipes = {"ju",  "fzjnm",  "x",  "e",  "zpmcz",  "h",  "q"};
        final List<List<String>> ingredients = Arrays.asList(
            Arrays.asList("d") ,
            Arrays.asList("hveml",  "f",  "cpivl") ,
            Arrays.asList("cpivl",  "zpmcz",  "h",  "e",  "fzjnm",  "ju") ,
            Arrays.asList("cpivl",  "hveml",  "zpmcz",  "ju",  "h") ,
            Arrays.asList("h",  "fzjnm",  "e",  "q",  "x") ,
            Arrays.asList("d",  "hveml",  "cpivl",  "q",  "zpmcz",  "ju",  "e",  "x") ,
            Arrays.asList("f",  "hveml",  "cpivl")
        );
        final String[] supplies = {"f",  "hveml",  "cpivl",  "d"};

        // execute
        final List<String> actualRecipeList = callMethod(recipes, ingredients, supplies);

        final List<String> expectedRecipeList = Arrays.asList("ju", "fzjnm", "q");
        assertThat(actualRecipeList, equalTo(expectedRecipeList));
    }

}
