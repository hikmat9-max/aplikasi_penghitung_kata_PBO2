import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PenghitungKata extends JFrame {
    private JTextArea textArea;
    private JTextField hasilField;
    private JButton btnHitung, btnClear, btnExit;

    public PenghitungKata() {
        setTitle("Aplikasi Penghitung Kata");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));

        // Komponen
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        hasilField = new JTextField();
        hasilField.setEditable(false);

        btnHitung = new JButton("Hitung Kata");
        btnClear = new JButton("Hapus");
        btnExit = new JButton("Keluar");

        // Panel bawah untuk tombol
        JPanel panelBawah = new JPanel();
        panelBawah.setLayout(new GridLayout(1, 3, 5, 5));
        panelBawah.add(btnHitung);
        panelBawah.add(btnClear);
        panelBawah.add(btnExit);

        // Tambahkan komponen ke panel utama
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(hasilField, BorderLayout.SOUTH);

        // Tambahkan ke frame
        add(panel, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);

        // Event Handling
        btnHitung.addActionListener(e -> hitungKata());
        btnClear.addActionListener(e -> clearFields());
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void hitungKata() {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            hasilField.setText("0 Kata");
        } else {
            String[] words = text.split("\\s+");
            hasilField.setText(words.length + " Kata");
        }
    }

    private void clearFields() {
        textArea.setText("");
        hasilField.setText("");
        textArea.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PenghitungKata::new);
    }
}
