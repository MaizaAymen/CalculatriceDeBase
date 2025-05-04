import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatriceDeBase extends JFrame {
    private JTextField aField, bField, resultField; // Champs mta3 A, B w résultat

    public CalculatriceDeBase() {
        setTitle("Calculatrice de Base"); // Titre mta3 l'app
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Bech nfermou l'app ki n9elbouha
        setLayout(new GridLayout(5, 1, 10, 10)); // Tawchira mta3 les composants

        // Input mta3 A
        JPanel aPanel = new JPanel(new FlowLayout()); // Groupe mta3 A
        aPanel.add(new JLabel("A: ")); // Label mta3 A
        aField = new JTextField(10); // Zone d'écriture mta3 A
        aPanel.add(aField);
        add(aPanel);

        // Input mta3 B
        JPanel bPanel = new JPanel(new FlowLayout()); // Groupe mta3 B
        bPanel.add(new JLabel("B: ")); // Label mta3 B
        bField = new JTextField(10); // Zone d'écriture mta3 B
        bPanel.add(bField);
        add(bPanel);

        // Boutons mta3 les opérations
        JButton addButton = new JButton("Addition"); // Bouton +
        JButton subButton1 = new JButton("Soustraction"); // Bouton - 1
        JButton subButton2 = new JButton("Soustraction"); // Bouton - 2 (kifkif)

        // Groupe mta3 les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(subButton1);
        buttonPanel.add(subButton2);
        add(buttonPanel);

        // Affichage mta3 résultat
        resultField = new JTextField("Résultat : "); // Zone résultat
        resultField.setEditable(false); // Maaneha man3amlech niktbou fih
        resultField.setHorizontalAlignment(JTextField.CENTER); // Texte au milieu
        add(resultField);

        // Action mta3 les boutons
        ActionListener operationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(aField.getText()); // Nakhdou valeur A
                    double b = Double.parseDouble(bField.getText()); // Nakhdou valeur B
                    double result = 0;

                    if (e.getActionCommand().equals("Addition")) { // Ki ndharbou 3la +
                        result = a + b; // Na3mlou jam3
                    } else { // Ki ndharbou 3la -
                        result = a - b; // Na3mlou tarh
                    }

                    resultField.setText("Résultat : " + result); // Nharjou résultat
                } catch (NumberFormatException ex) { // Ken fama mochkla
                    resultField.setText("Erreur: Entrez des nombres valides"); // Nharjou erreur
                }
            }
        };

        // Nzidou les actions lkol
        addButton.addActionListener(operationListener);
        subButton1.addActionListener(operationListener);
        subButton2.addActionListener(operationListener);

        setSize(350, 250); // Taille mta3 la fenêtre
        setLocationRelativeTo(null); // Au milieu d'écran
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatriceDeBase().setVisible(true); // Nharjou l'interface
        });
    }
}