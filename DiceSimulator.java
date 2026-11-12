
import javax.swing.*;        // GUI 視窗與元件
import java.awt.*;           // 字型、顏色、版面配置
import java.awt.event.*;     // 按鈕事件
import java.util.Random;     // 隨機數

public class DiceSimulator extends JFrame implements ActionListener {

    JLabel numberLabel;
    JLabel statsLabel;
    JButton rollButton;

    int count = 0;
    int total = 0;
    // 建立隨機數產生器
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

        // 計算平均數
        double average = (double) total / count;

        // 更新中央點數
        numberLabel.setText(String.valueOf(dice));

        // 根據骰子點數改變顏色
        if (dice == 6) {
            numberLabel.setForeground(Color.GREEN);
        } else if (dice == 1) {
            numberLabel.setForeground(Color.RED);
        } else {
            numberLabel.setForeground(Color.BLACK);
        }

        // 更新上方統計資訊
        statsLabel.setText(
            String.format("已擲 %d 次，總和 %d，平均 %.2f",
                          count, total, average)
        );
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceSimulator());
    }
}
