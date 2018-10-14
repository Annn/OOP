package op1;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JButton btnSolve;
    private JPanel pnlMain;
    private JLabel lblCoefficientA, lblCoefficientB, lblCoefficientC;
    private JTextField txtCoefficientA, txtCoefficientB, txtCoefficientC;
    private JLabel lblResult;

    public MainForm() {
        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resMsg;
                Boolean validCoefs = true;

                double a = 0, b = 0, c = 0;
                try {
                    a = Double.parseDouble(txtCoefficientA.getText());
                    b = Double.parseDouble(txtCoefficientB.getText());
                    c = Double.parseDouble(txtCoefficientC.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,
                            "Check if the provided coefficients are valid");
                    validCoefs = false;
                }
                if (validCoefs) {
                    SquareEquationSolver ses = new SquareEquationSolver(a, b, c);
                    try {
                        resMsg = "Roots found: " + ses.solve();
                    }
                    catch(Exception ex) {
                        resMsg = ex.getMessage();
                    }
                    lblResult.setText(resMsg);
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("PO: zadanie 1");
        frame.setContentPane(new MainForm().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height / 5, width = screenSize.width / 4;
        frame.setPreferredSize(new Dimension(width, height));
        //frame.setLocationRelativeTo(null);

        frame.pack();
        frame.setVisible(true);

    }

}
