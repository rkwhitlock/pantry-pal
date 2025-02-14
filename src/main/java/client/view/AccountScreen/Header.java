package client.view.AccountScreen;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class Header extends HBox {

  Header(String title) {
    this.setPrefSize(500, 60); // Size of the header
    this.setStyle("-fx-background-color: #F0F8FF;");

    Text titleText = new Text(title); // Text of the Header
    titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
    this.getChildren().add(titleText);
    this.setAlignment(Pos.CENTER); // Align the text to the Center
  }
}
