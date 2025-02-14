package client.controller;

import client.View;
import client.model.Model;
import client.model.RecipeImage;
import client.view.MainMenu.Recipe;
import java.io.BufferedReader;
import java.io.FileReader;
import server.MyServer;

public class ViewController {

  private View view;

  public ViewController(View view) {
    this.view = view;
  }

  public String viewStart() {
    try {
      FileReader fr = new FileReader("automaticLogin.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      if (line.equals("false")) {
        br.close();
        return "accountScreen";
      } else if (line.equals("true")) {
        view.setUsername(br.readLine());
        String query = view.getUsername();
        Model model = new Model();
        String response = "";
        if (MyServer.isServerRunning()) {
          response = model.performRequest("GET", null, null, query);
        } else {
          view.setRoot("serverDown");
          br.close();
          return "serverDown";
        }
        if (response != null) {
          String[] recipes = response.split("~");
          for (String recipeContent : recipes) {
            Recipe recipe = new Recipe(view);
            recipe.setRecipe(
              recipeContent.substring(0, recipeContent.indexOf("|"))
            );
            recipe.setTime();

            //String recipeName = recipeContent.replaceAll("(?m)^[ \t]*\r?\n", "");
            String recipeName = recipeContent.substring(
              0,
              recipeContent.indexOf('\n')
            );
            String mealType = recipeContent.substring(
              recipeContent.indexOf("|") + 1
            );

            recipe.getRecipeName().setText(recipeName);
            RecipeImage recipeImage = new RecipeImage();
            try {
              recipeImage.NewImage(recipeName);
            } catch (Exception e1) {}
            recipe.setImageURL(recipeImage.getURL());

            recipe.setMealTypeTag(mealType);
            view.mainMenu.getRecipeList().getChildren().add(0, recipe);
            new RecipeScreenController(
              view,
              view.recipeScreen,
              view.mainMenu,
              model,
              recipe
            );
          }
        }
      }
      br.close();
      return "main";
    } catch (Exception e) {}
    return "";
  }
}
