import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PolynomialCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PolynomialModel model = new PolynomialModel();
            PolynomialView view = new PolynomialView();
            PolynomialController controller = new PolynomialController(model, view);
        });
    }
}