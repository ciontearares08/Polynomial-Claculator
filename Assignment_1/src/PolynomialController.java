
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PolynomialController implements ActionListener {
    private PolynomialModel model;
    private PolynomialView view;

    public PolynomialController(PolynomialModel model, PolynomialView view) {
        this.model = model;
        this.view = view;
        this.view.addAdditionListener(this);
        this.view.addSubtractionListener(this);
        this.view.addMultiplicationListener(this);
        this.view.addDivisionListener(this);
        this.view.addDerivativeListener(this);
        this.view.addIntegrationListener(this); // Add listener for integration
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input1 = view.getInput1();
        String input2 = view.getInput2();
        model.parseFirst(input1);
        model.parseSecond(input2);

        if (e.getSource() == view.addButton) {
            model.add(model.getSecondPolynomial());
        } else if (e.getSource() == view.subtractButton) {
            model.subtract(model.getSecondPolynomial());
        } else if (e.getSource() == view.multiplyButton) {
            model.multiply(model.getSecondPolynomial());
        } else if (e.getSource() == view.divideButton) {
            model.divide(model.getSecondPolynomial());
        } else if (e.getSource() == view.derivativeButton) {
            PolynomialModel derivative = model.derivative();
            view.setResult(derivative.toString());
        } else if (e.getSource() == view.integrationButton) { // Handle integration button
            PolynomialModel integral = model.integrate();
            view.setResult(integral.toString());
        }

        view.setResult(model.toString());
        view.setRemainder("");
    }
}
