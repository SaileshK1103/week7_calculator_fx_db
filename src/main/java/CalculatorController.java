
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML private TextField number1Field;
    @FXML private TextField number2Field;
    @FXML private Label resultLabel;

    @FXML
    private void onCalculateClick() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());

            double sum = num1 + num2;
            double product = num1 * num2;
            double diff = num1 -num2;
            double div = (num2 != 0) ? num1 / num2 : 0;

            resultLabel.setText(String.format("Sum: %.2f, Prod: %.2f, Diff: %.2f, Div: %.2f",
            sum, product, diff, div));


            // Save to DB
            ResultService.saveResult(num1, num2, sum, product,  diff, div);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }
}