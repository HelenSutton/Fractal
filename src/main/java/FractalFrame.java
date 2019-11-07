import javax.swing.*;
import java.awt.*;

public class FractalFrame extends JFrame {
    FractalComponent component = new FractalComponent();
    public FractalFrame (){
        setTitle("Koch Curve");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100,700);


        setLayout(new BorderLayout());
        add(component, BorderLayout.CENTER);
        setVisible(true);

    }
}
