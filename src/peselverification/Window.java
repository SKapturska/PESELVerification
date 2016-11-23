package peselverification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {

    JLabel lPesel, result;
    JTextField tfPesel;
    JButton verify;
    LuhnAlgorithm la = new LuhnAlgorithm();

    Window() {                      
        setTitle("PESEL Verification");
        setSize(370, 150);
        setLocation(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        lPesel = new JLabel("Podaj nr PESEL: ");
        lPesel.setLocation(20, 20);
        lPesel.setSize(100, 25);
        add(lPesel);

        tfPesel = new JTextField();
        tfPesel.setLocation(150, 20);
        tfPesel.setSize(140, 25);
        add(tfPesel);

        verify = new JButton("Weryfikuj");
        verify.setLocation(20, 70);
        verify.setSize(90, 25);
        verify.addActionListener(this);
        add(verify);

        result = new JLabel("");
        result.setLocation(120, 70);
        result.setSize(200, 25);
        add(result);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String pesel = tfPesel.getText().trim();
        if (pesel.matches("^[0-9]{11}$")) {     
            if (la.verify(pesel) == true) {
                result.setText("PESEL jest poprawny");
                la.writeToFile(pesel);
            } else {
                result.setText("PESEL jest nie poprawny");
            }
        }else{
            result.setText("Numer moze zawierac tylko 11 cyfr");
        }
    }

}
