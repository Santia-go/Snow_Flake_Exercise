import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class SimplePad {

    private final PadFrame frame;

    private final List<double[]> lines = new ArrayList<>();

    public SimplePad(int width, int height, String title) {
        frame = new PadFrame(title);
        frame.setBackground(Color.white);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        lines.add(new double[] { x1, y1, x2, y2 });
    }

    public void setVisible() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    private class PadFrame extends JFrame {
        PadFrame(String title) {
            super(title);
        }

        void drawLines(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (double[] line : lines) {
                g2d.draw(new Line2D.Double(line[0], line[1], line[2], line[3]));
            }
        }

        public void paint(Graphics g) {
            super.paint(g);
            drawLines(g);
        }
    }
}