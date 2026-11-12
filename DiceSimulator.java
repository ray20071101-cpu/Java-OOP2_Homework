
import javax.swing.*;        
import java.awt.*;           
import java.awt.event.*;     
import java.util.Random;    

public class DiceSimulator extends JFrame implements ActionListener {

    JLabel numberLabel;
    JLabel statsLabel;
    JButton rollButton;

    int count = 0;
    int total = 0;
    Random random = new Random();

    public DiceSimulator() {

        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        setLayout(new BorderLayout(10, 10));

        
        statsLabel = new JLabel(
            "已擲 0 次，總和 0，平均 0.00",
            SwingConstants.CENTER
        );
        statsLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
        add(statsLabel, BorderLayout.NORTH);

        // 中央：顯示骰子點數
        numberLabel = new JLabel("-", SwingConstants.CENTER);
        numberLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        numberLabel.setForeground(Color.BLACK);
        add(numberLabel, BorderLayout.CENTER);

        // 下方：擲骰子按鈕
        rollButton = new JButton("擲骰子");
        rollButton.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
        rollButton.setPreferredSize(new Dimension(100, 60));
        rollButton.addActionListener(this);
        add(rollButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int dice = random.nextInt(6)+1;
        count++;
        total+=dice;
        
        double average = (double) total / count;
 
        numberLabel.setText(String.valueOf(dice));

        if (dice == 6) {
            numberLabel.setForeground(Color.GREEN);
        } else if (dice == 1) {
            numberLabel.setForeground(Color.RED);
        } else {
            numberLabel.setForeground(Color.BLACK);
        }

        statsLabel.setText(
            String.format("已擲 %d 次，總和 %d，平均 %.2f",
                          count, total, average)
        );
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceSimulator());
    }
}
