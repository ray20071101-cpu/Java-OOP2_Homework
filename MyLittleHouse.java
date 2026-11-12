
import javax.swing.*;
import java.awt.*;

public class MyLittleHouse extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, 500, 400);

        g.setColor(new Color(76, 175, 80));
        g.fillRect(0, 320, 500, 80);

        g.setColor(Color.YELLOW);
        g.fillOval(380, 33, 80, 80);

        int centerX = 420;
        int centerY = 73;

        g.setColor(Color.YELLOW);

        for (int i = 0; i < 8; i++) {
            double angle = i * Math.PI / 4;

            int x1 = centerX + (int)(50 * Math.cos(angle));
            int y1 = centerY + (int)(50 * Math.sin(angle));

            int x2 = centerX + (int)(70 * Math.cos(angle));
            int y2 = centerY + (int)(70 * Math.sin(angle));

            g.drawLine(x1, y1, x2, y2);
        }

        g.setColor(Color.WHITE);
        g.fillOval(60, 55, 80, 55);
        g.fillOval(105, 38, 85, 65);
        g.fillOval(150, 55, 70, 55);

        g.setColor(new Color(255, 228, 181));
        g.fillRect(150, 192, 200, 160);

        g.setColor(Color.BLACK);
        g.drawRect(150, 192, 200, 160);

        g.setColor(Color.RED);
        g.drawLine(130, 192, 250, 96);
        g.drawLine(250, 96, 370, 192);
        g.drawLine(130, 192, 370, 192);

        g.setColor(Color.WHITE);
        g.fillRect(170, 225, 50, 52);

        g.setColor(Color.BLACK);
        g.drawRect(170, 225, 50, 52);

        g.drawLine(195, 225, 195, 277);
        g.drawLine(170, 251, 220, 251);

        g.setColor(Color.WHITE);
        g.fillRect(280, 225, 50, 52);

        g.setColor(Color.BLACK);
        g.drawRect(280, 225, 50, 52);

        g.drawLine(305, 225, 305, 277);
        g.drawLine(280, 251, 330, 251);

        g.setColor(new Color(139, 69, 19));
        g.fillRoundRect(225, 267, 50, 85, 15, 15);

        g.setColor(Color.YELLOW);
        g.fillOval(262, 307, 8, 8);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
        g.drawString("A1143327 蘇柏瑞", 15, 385);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("My Little House");

            MyLittleHouse panel = new MyLittleHouse();

            panel.setPreferredSize(new Dimension(500, 400));

            frame.add(panel);
            frame.pack();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLocationRelativeTo(null);

            frame.setResizable(false);

            frame.setVisible(true);
        });
    }
}

