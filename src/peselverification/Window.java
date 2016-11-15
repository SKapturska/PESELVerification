package peselverification;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame{
    
    JLabel lPesel;
    JTextField tfPesel;
    JButton verify;
    
    Window() {
        setTitle("PESEL Verification");
        setSize(320, 200);
        setLocation(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        lPesel = new JLabel("Podaj nr PESEL: ");
        lPesel.setLocation(20, 20);
        lPesel.setSize(100, 25);
        add(lPesel);
        
        tfPesel = new JTextField();
        tfPesel.setLocation(130, 20);
        tfPesel.setSize(140,25);
        add(tfPesel);
        
        verify = new JButton("Weryfikuj");
        verify.setLocation(20, 70);
        verify.setSize(90,25);
        add(verify);
        
    }
    
}
