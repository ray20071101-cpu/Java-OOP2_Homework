
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverter extends JFrame implements ActionListener {

    JComboBox<String> typeCombo;
    JComboBox<String> fromCombo;
    JComboBox<String> toCombo;

    JTextField inputField;
    JTextField outputField;
    JButton convertButton;

    String[][] units = {
        {"公尺", "公分", "英吋", "英尺"},
        {"公斤", "公克", "磅", "盎司"},
        {"攝氏", "華氏", "克氏"}
    };

    double[][] factors = {
        {1.0, 0.01, 0.0254, 0.3048},
        {1.0, 0.001, 0.45359237, 0.028349523125}
    };

    public UnitConverter() {

        setTitle("單位換算器");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        String[] types = {"長度", "重量", "溫度"};
        typeCombo = new JComboBox<>(types);
        add(typeCombo, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(
            new GridLayout(2, 1, 0, 10)
        );


        JPanel row1 = new JPanel(new BorderLayout(10, 0));

        inputField = new JTextField();
        fromCombo = new JComboBox<>();

        row1.add(new JLabel("來源："), BorderLayout.WEST);
        row1.add(inputField, BorderLayout.CENTER);
        row1.add(fromCombo, BorderLayout.EAST);

        JPanel row2 = new JPanel(new BorderLayout(10, 0));

        outputField = new JTextField();
        outputField.setEditable(false);
        toCombo = new JComboBox<>();

        row2.add(new JLabel("結果："), BorderLayout.WEST);
        row2.add(outputField, BorderLayout.CENTER);
        row2.add(toCombo, BorderLayout.EAST);

        centerPanel.add(row1);
        centerPanel.add(row2);

        centerPanel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        add(centerPanel, BorderLayout.CENTER);


        convertButton = new JButton("換算");
        convertButton.setPreferredSize(new Dimension(100, 50));
        add(convertButton, BorderLayout.SOUTH);

        typeCombo.addActionListener(this);
        convertButton.addActionListener(this);

        updateUnits();

        setVisible(true);
    }

    public void updateUnits() {

        int type = typeCombo.getSelectedIndex();

        fromCombo.removeAllItems();
        toCombo.removeAllItems();

        for (String unit : units[type]) {
            fromCombo.addItem(unit);
            toCombo.addItem(unit);
        }

        fromCombo.setSelectedIndex(0);
        toCombo.setSelectedIndex(1);

        outputField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == typeCombo) {
            updateUnits();
        }

        if (e.getSource() == convertButton) {
            convert();
        }
    }

 
    public void convert() {

        try {

            double value = Double.parseDouble(
                inputField.getText().trim()
            );

            if (!Double.isFinite(value)) {
                throw new NumberFormatException();
            }

            int type = typeCombo.getSelectedIndex();
            int from = fromCombo.getSelectedIndex();
            int to = toCombo.getSelectedIndex();

            double result = 0;

            if (type == 2) {


                double celsius;

                if (from == 0) {
                    celsius = value;
                } else if (from == 1) {
                    celsius = (value - 32) * 5.0 / 9.0;
                } else {
                    celsius = value - 273.15;
                }


                if (to == 0) {
                    result = celsius;
                } else if (to == 1) {
                    result = celsius * 9.0 / 5.0 + 32;
                } else {
                    result = celsius + 273.15;
                }

            } else {

                double base = value * factors[type][from];
                result = base / factors[type][to];
            }

            outputField.setText(
                String.format("%.4f", result)
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "請輸入有效的數字！"
            );

            outputField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnitConverter());
    }
}

