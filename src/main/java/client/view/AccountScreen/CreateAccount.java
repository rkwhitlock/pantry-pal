package client.view.AccountScreen;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class CreateAccount extends VBox {

  private TextField username;
  private TextField password;
  private TextField confirmPassword;
  private Label errorPrompt;

  public CreateAccount(String prompt) {
    this.setSpacing(5); // sets spacing between tasks
    this.setPrefSize(500, 560);
    this.setStyle("-fx-background-color: #F0F8FF;");

    String textStyle = "-fx-background-color: #DAE5EA; -fx-border-width: 0;";

    errorPrompt = new Label(prompt);
    errorPrompt.setStyle(
      "-fx-border-width: 0; -fx-font-weight: bold; -fx-font-size: 18px"
    );

    username = new TextField();
    username.setPrefSize(380, 20);
    username.setStyle(textStyle);

    password = new TextField();
    password.setPrefSize(380, 20);
    password.setStyle(textStyle);

    confirmPassword = new TextField();
    confirmPassword.setPrefSize(380, 20);
    confirmPassword.setStyle(textStyle);

    this.getChildren()
      .addAll(
        errorPrompt,
        new Label("Username:"),
        username,
        new Label("Password:"),
        password,
        new Label("Confirm Password:"),
        confirmPassword
      );
  }

  public String getUsername() {
    return username.getText();
  }

  public String getPassword() {
    return password.getText();
  }

  public String getPasswordConfirmation() {
    return confirmPassword.getText();
  }

  public void clearCreateAccount() {
    username.clear();
    password.clear();
    confirmPassword.clear();
  }
}
