import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FractalComponent extends JComponent {
    ArrayList<Vector2D> vectors =new ArrayList();


    public FractalComponent() {
        vectors.add(new Vector2D(0, 500));
        vectors.add(new Vector2D(-120, 500));
        vectors.add(new Vector2D(120, 500));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                reproduce();

            }
        });
    }

    public void reproduce()
    {

        ArrayList<Vector2D> newVectors =new ArrayList();
        for(Vector2D parent : vectors )
        {
            double newMagnitude =  (parent.magnitude/3.0);
            double newDirection = parent.direction;
            Vector2D childA = new Vector2D(newDirection, newMagnitude);
            Vector2D childB = new Vector2D(newDirection+60, newMagnitude);
            Vector2D childC = new Vector2D(newDirection-60, newMagnitude);
            Vector2D childD = new Vector2D(newDirection, newMagnitude);
            newVectors.add(childA);
            newVectors.add(childB);
            newVectors.add(childC);
            newVectors.add(childD);


        }
        vectors = newVectors;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.translate(0,getHeight());


        double x1 = 50;
        double y1 = getHeight() /3 * 2;
        double x2;
        double y2;
        for (Vector2D v : vectors) {
            x2 = x1 + Math.cos(Math.toRadians(v.direction)) * v.magnitude;
            y2 = y1 + Math.sin(Math.toRadians(v.direction)) * v.magnitude;;
            graphics.drawLine((int) x1, (int) -y1, (int) x2, (int) -y2);
            x1 = x2;
            y1 = y2;
        }
    }

}
