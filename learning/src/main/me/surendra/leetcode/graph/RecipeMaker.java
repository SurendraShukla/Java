package me.surendra.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/">Find All Possible Recipes from Given Supplies</a>
 */
public class RecipeMaker {

    final Set<String> suppliesSet = new HashSet<>();
    final Map<String, List<String>> recipesAndItsIngredientsGraph = new HashMap<>();
    final Set<String> seenRecipeInCurrentPath = new HashSet<>();
    final Map<String, Boolean> cache = new HashMap<>();

    /**
        Time Complexity - O(n + m + k)
                                n is the number of recipes
                                m the number elements in supplies
                                k is the number of elements in ingredients
        Space Complexity - O(n + m + k)
     */
    public List<String> findAllRecipes(final String[] recipes,
                                       final List<List<String>> ingredients,
                                       final String[] supplies
    ) {
        for (String supply: supplies) {
            suppliesSet.add(supply);
        }
        for (int i = 0; i < recipes.length; i++) {
            recipesAndItsIngredientsGraph.put(recipes[i], ingredients.get(i));
        }

        final List<String> returnList = new ArrayList<>();
        for (String recipe: recipes) {
            if (recipeCanBeMadeUsingDFS(recipe)) {
                returnList.add(recipe);
            }
        }
        return returnList;
    }


    private boolean recipeCanBeMadeUsingDFS(final String recipe) {
        if (cache.containsKey(recipe)) {
            return cache.get(recipe);
        }

        for (String ingredient: recipesAndItsIngredientsGraph.get(recipe)) {
            if (!suppliesSet.contains(ingredient)) {
                if (seenRecipeInCurrentPath.contains(ingredient) ||
                    !recipesAndItsIngredientsGraph.containsKey(ingredient)
                ) {
                    cache.put(recipe, false);
                    return false;
                }
                seenRecipeInCurrentPath.add(ingredient);
                if (!recipeCanBeMadeUsingDFS(ingredient)) {
                    cache.put(recipe, false);
                    return false;
                }
                seenRecipeInCurrentPath.remove(ingredient);
            }
        }
        cache.put(recipe, true);
        return true;
    }

    /**
     Time Complexity - O(V + E)
     V is number of vertices and
     E is number of edges in the graph adj

     Outer for loop will be executed V number of times and the
     Inner for loop will be executed E number of times.
     k is the number of elements in ingredients
     Space Complexity - O(V) queue and maps need to store all the vertices of the graph
     */
    public List<String> findAllRecipesUsingTopologySort(final String[] recipes,
                                                        final List<List<String>> ingredients,
                                                        final String[] supplies
    ) {
        final Map<String, ArrayList<String>> adj = new HashMap();
        final Map<String, Integer> indegree = new HashMap();
        final Map<String, Integer> recipesAvl = new HashMap();
        final ArrayList<String> res = new ArrayList();

        final int n = recipes.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                final String elem = ingredients.get(i).get(j);
                if (!adj.containsKey(elem)) {
                    adj.put(elem, new ArrayList<>());
                }

                adj.get(elem).add(recipes[i]);
                indegree.put(recipes[i],  indegree.getOrDefault(recipes[i], 0) + 1);
                recipesAvl.put(recipes[i], 1);
            }
        }
        final Queue<String> q = new LinkedList();
        for (String s: supplies) q.add(s);

        while (!q.isEmpty()) {
            final String u = q.peek();
            q.remove();
            if (recipesAvl.containsKey(u)) {
                res.add(u);
            }
            for (String v: adj.getOrDefault(u, new ArrayList<>())) {
                indegree.put(v, indegree.get(v) - 1);
                if (indegree.get(v) == 0) {
                    q.add(v);
                }
            }
        }
        return res;
    }

}
