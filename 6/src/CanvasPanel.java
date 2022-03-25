import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class CanvasPanel {
    private Fork forkPane;
    private JPanel mainPanel;
    private JSpinner tinesSpinner;
    private JButton colorButton;
    private JButton scaleUpButton;
    private JButton scaleDownButton;
    private JScrollPane forkScrollPane;
    private int lastMouseX;
    private int lastMouseY;

    public CanvasPanel() {
        colorButton.setBackground(forkPane.getColor());
        forkPane.setAutoscrolls(true);
        tinesSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                int newTinesCount = (int)tinesSpinner.getValue();
                forkPane.setTinesCount(newTinesCount);
            }
        });
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Color newColor = JColorChooser.showDialog(
                        mainPanel,
                        "Choose Background Color",
                        Color.GRAY);
                forkPane.setColor(newColor);
                colorButton.setBackground(newColor);
            }
        });
        scaleDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                forkPane.scaleDown();
                mainPanel.repaint();
                forkScrollPane.updateUI();
            }
        });
        scaleUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                forkPane.scaleUp();
                mainPanel.repaint();
                forkScrollPane.updateUI();
            }
        });
        forkPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, forkPane);
                if (viewPort != null) {
                    int deltaX = lastMouseX - e.getX();
                    int deltaY = lastMouseY - e.getY();

                    Rectangle view = viewPort.getViewRect();
                    view.x += deltaX;
                    view.y += deltaY;

                    forkPane.scrollRectToVisible(view);
                }
            }
        });
        forkPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastMouseX = e.getX();
                lastMouseY = e.getY();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dinner");
        frame.setContentPane(new CanvasPanel().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        tinesSpinner = new JSpinner(new SpinnerNumberModel(4,
                1,
                8,
                1));
    }
}
