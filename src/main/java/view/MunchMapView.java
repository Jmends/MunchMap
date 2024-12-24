package view;

import javax.swing.*;
import java.awt.*;
public class MunchMapView extends JFrame{
    private final JTextField addressField;
    private final JComboBox<Integer> radiusField;
    private final JButton restaurantButton;
    private final JTextArea resultLabel;

    public MunchMapView() {
        //set up the frame
        setTitle("Munch Map");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setVisible(true);

        //create components
        addressField = new JTextField();
        radiusField = new JComboBox<>(new Integer[]{5, 10, 15, 25});
        restaurantButton = new JButton("Enter");
        resultLabel = new JTextArea(5,20);

        resultLabel.setEditable(false);
        resultLabel.setLineWrap(true);
        resultLabel.setWrapStyleWord(true);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        //adjust component size
        addressField.setPreferredSize(new Dimension(200, 25));
        radiusField.setPreferredSize(new Dimension(100, 25));
        restaurantButton.setPreferredSize(new Dimension(100, 30));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Set up layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // Add components to the frame
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Address: "), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        add(addressField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Radius: "), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        add(radiusField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(restaurantButton, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across 2 columns
        gbc.fill = GridBagConstraints.BOTH;
        add(resultLabel, gbc);

        // Add padding around the frame
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }
    public String getAddress() {
        return addressField.getText();
    }

    public int getRadius() {
        Integer selectedValue = (Integer) radiusField.getSelectedItem();
        if (selectedValue != null) {
            return selectedValue;
        } else {
            return 0;
        }
    }

    public void setRestaurant(String restaurantData) {
        resultLabel.setText(restaurantData);
    }

    public JButton getRestaurantButton() {
        return restaurantButton;
    }
}
