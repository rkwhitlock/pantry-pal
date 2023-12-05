package client.view.MainMenu;

import client.View;
import client.model.RecipeImage;
import client.view.RecipeScreen.DetailedRecipeView;
import client.view.RecipeScreen.RecipeScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

public class Recipe extends HBox {

  private Button recipeName;
  private String recipe;
  private String imageURL;

  public Recipe(View view) {
    this.setPrefSize(500, 20); // sets size of task
    this.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;");

    recipeName = new Button(); // create task name text field
    recipeName.setPrefSize(380, 20); // set size of text field
    recipeName.setStyle(
      "-fx-background-color: #DAE5EA; -fx-border-width: 0; -fx-font-weight: bold; -fx-underline: true;"
    ); // set background color of textfield
    recipeName.setPadding(new Insets(10, 0, 0, 0)); // adds some padding to the text field
    this.getChildren().add(recipeName); // add textlabel to task
    //recipeName.setTextAlignment(TextAlignment.LEFT);
    this.setAlignment(Pos.BOTTOM_LEFT);
    recipeName.setOnAction(e -> {
      DetailedRecipeView detailedRecipeView =
        ((RecipeScreen) view.getRoot("recipe")).getDetailedRecipeView();
      detailedRecipeView.setText(recipe);
      detailedRecipeView.SI(imageURL);

      view.recipeScreen.getFooter().switchToViewing();
      view.recipeScreen.setRecipe(this);
      view.setRoot("recipe");
    });
  }

  public Button getRecipeName() {
    return this.recipeName;
  }

  public void setRecipe(String recipe) {
    this.recipe = recipe;
  }

  public String getImageURL() {
    return this.imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getRecipe() {
    return this.recipe;
  }
}
