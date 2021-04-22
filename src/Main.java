import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program wyświetlający trójkąt Pascala w oknie.
 * @version 0.1 2021-04-17
 * @author Marcin Wilk
 */

public class Main {
    public static void main(String[] args) {

        // Pobranie wielkosci trojkata od uzytkownika

        int wielkosc = -1;

        System.out.print("Podaj wielkość trójkąta: ");

        try (Scanner in = new Scanner(System.in)) {
            wielkosc = in.nextInt();

            if (wielkosc < 0) {
                System.out.println("Nie mozesz wpisac liczby mniejszej niz 0!");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Nie wpisales liczby!");
            System.exit(0);
        }

        int wielkosc2 = wielkosc;

        // Utworzenie i uruchomienie okna z trojkatem

        EventQueue.invokeLater(() -> {
            var frame = new MainFrame(wielkosc2);
            frame.setTitle("Trójkąt Pascala");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class MainFrame extends JFrame {
    public MainFrame(int wielkosc) {
        add(new MainComponent(wielkosc));
        pack();
    }
}

class MainComponent extends JComponent {
    private final int wielkosc;

    public MainComponent(int wielkosc) {
        this.wielkosc = wielkosc;
    }

    @Override
    protected void paintComponent(Graphics g) {
        var tp = new TrojkatPascala(wielkosc);

        int max_width = g.getFontMetrics().stringWidth(tp.getWiersz(wielkosc));

        for (int i=0; i<=wielkosc; i++) {
            int offset = (max_width - g.getFontMetrics().stringWidth(tp.getWiersz(i))) / 2;

            g.drawString(tp.getWiersz(i), 50 + offset, 50 + g.getFontMetrics().getHeight() * i);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        var tp = new TrojkatPascala(wielkosc);

        int width = getGraphics().getFontMetrics().stringWidth(tp.getWiersz(wielkosc)) + 100;
        int height = getGraphics().getFontMetrics().getHeight() * (wielkosc + 1) + 100;

        return new Dimension(width, height);
    }
}
