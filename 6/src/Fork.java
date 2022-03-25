import javax.swing.*;
import java.awt.*;

public class Fork extends JPanel {
    private Color color;
    private int tinesCount;
    private double scalingX;
    private double scalingY;

    public Fork() {
        this.color = Color.GRAY;
        this.tinesCount = 4;
        setPreferredSize(new Dimension(700, 1000));
        this.scalingX = 1;
        this.scalingY = 1;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    public Color getColor() {
        return color;
    }

    public void setTinesCount(int tinesCount) {
        this.tinesCount = tinesCount;
        repaint();
    }

    public void scaleUp() {
        this.scalingX += 0.1;
        this.scalingY += 0.1;
        setPreferredSize(new Dimension((int)(700*scalingX), (int)(1000*scalingY)));
        repaint();
    }
    public void scaleDown() {
        this.scalingX -= 0.1;
        this.scalingY -= 0.1;
        setPreferredSize(new Dimension((int)(700*scalingX), (int)(1000*scalingY)));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.scale(scalingX, scalingY);
        super.paintComponent(g);
        g.setColor(color);
        g.drawOval(300, 800, 75, 75);
        g.fillOval(300, 800, 75, 75);

        g.fillPolygon(new int[]{300, 330, 345, 375}, new int[]{800+(75/2), 398, 398, 800+(75/2)}, 4);
        g.fillArc((345+330)/2-(75/2), 400-100, 75, 100, 0, -180);

        int pos = 300;
        int width = 75 / (tinesCount*2 - 1);
        int ost = 75 % (tinesCount*2 - 1);
        int add = ost % tinesCount;
        for (int i = 0; i < tinesCount; ++i) {
            int tineWidth = width + ost / tinesCount + (i < add ? 1 : 0);
            g.fillRect(pos, 330-75, tineWidth, 100);
            pos += width + tineWidth;
        }
    }
}
