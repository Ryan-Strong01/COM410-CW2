package forms;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

/**
 * Main menu for RankMatch.
 *
 * Menu options map to the assignment levels:
 *   New Game          - L1-L4 (player setup, 1-4 players, 2-4 matches) and L7 ("Computer" player)
 *   High Scores       - L5-L6 (separate top-5 tables for 2, 3 and 4 matches)
 *   How to Play       - L9 presentation extra
 *   Exit
 *
 * The menu only handles navigation. Each button runs a Runnable that the
 * rest of the application supplies, so game logic stays out of the UI class.
 */
public class MainMenu extends JFrame {

    private static final int MENU_W = 520;
    private static final int MENU_H = 600;
    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 52;
    private static final int BUTTON_GAP = 14;

    private static final Color FELT_LIGHT = new Color(32, 112, 74);
    private static final Color FELT_DARK = new Color(10, 48, 32);
    private static final Color GOLD = new Color(232, 190, 92);
    private static final Color TEXT_LIGHT = new Color(235, 240, 235);
    private static final Color FOOTER_TEXT = new Color(220, 230, 222, 130);

    private Runnable onNewGame = () -> comingSoon("New Game");
    private Runnable onHighScores = () -> comingSoon("High Scores");

    public MainMenu() {
        super("RankMatch");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmExit();
            }
        });

        FeltPanel root = new FeltPanel();
        root.setLayout(new BorderLayout());
        root.setBorder(BorderFactory.createEmptyBorder(40, 70, 30, 70));

        // ---- Header: suits, title, tagline ----
        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel suits = centredLabel("♠  ♥  ♦  ♣", new Font(Font.SERIF, Font.PLAIN, 22), GOLD);
        JLabel title = centredLabel("RankMatch", new Font(Font.SERIF, Font.BOLD, 54), GOLD);
        JLabel tagline = centredLabel("Match the rank. Win the round.",
                new Font(Font.SANS_SERIF, Font.PLAIN, 15), TEXT_LIGHT);

        header.add(suits);
        header.add(Box.createVerticalStrut(4));
        header.add(title);
        header.add(Box.createVerticalStrut(4));
        header.add(tagline);
        root.add(header, BorderLayout.NORTH);

        // ---- Buttons ----
        JPanel buttons = new JPanel(new GridLayout(0, 1, 0, BUTTON_GAP));
        buttons.setOpaque(false);

        MenuButton newGame = new MenuButton("New Game", true);
        MenuButton highScores = new MenuButton("High Scores", false);
        MenuButton howToPlay = new MenuButton("How to Play", false);
        MenuButton exit = new MenuButton("Exit", false);

        newGame.addActionListener(e -> onNewGame.run());
        highScores.addActionListener(e -> onHighScores.run());
        howToPlay.addActionListener(e -> showHowToPlay());
        exit.addActionListener(e -> confirmExit());

        buttons.add(newGame);
        buttons.add(highScores);
        buttons.add(howToPlay);
        buttons.add(exit);
        // Wrapper keeps the buttons at their preferred height, centred in the space
        JPanel buttonArea = new JPanel(new GridBagLayout());
        buttonArea.setOpaque(false);
        buttonArea.add(buttons);
        root.add(buttonArea, BorderLayout.CENTER);

        // ---- Footer ----
        root.add(centredLabel("COM410 Programming in Practice",
                        new Font(Font.SANS_SERIF, Font.PLAIN, 11), FOOTER_TEXT),
                BorderLayout.SOUTH);

        setContentPane(root);
        setSize(MENU_W, MENU_H);
        setResizable(false);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(newGame);   // Enter starts a new game
    }

    // ---------- Hooks for the rest of the application ----------

    public void setOnNewGame(Runnable action) {
        this.onNewGame = Objects.requireNonNull(action, "New game action must not be null");
    }

    public void setOnHighScores(Runnable action) {
        this.onHighScores = Objects.requireNonNull(action, "High scores action must not be null");
    }


    // ---------- Built-in actions ----------

    private void showHowToPlay() {
        String rules = """
                <html><body style='width: 330px; font-family: sans-serif;'>
                <h2 style='margin-top: 0;'>How to Play</h2>
                <ol>
                  <li>Choose 1 to 4 players. Each player takes a full turn with a freshly shuffled deck.</li>
                  <li>Each player enters their name, picks a <b>target rank</b> (e.g. K),
                      picks how many <b>matches</b> to find (2, 3 or 4), and <b>guesses</b>
                      how many cards will be dealt before that many matches turn up.</li>
                  <li>Cards are dealt one at a time until enough cards of the target rank appear.</li>
                  <li><b>Score</b> = (guess &minus; cards dealt) &divide; matches, to one decimal place.</li>
                  <li>The highest score wins and goes into the high score table for that number of matches.</li>
                </ol>
                <p><b>Tip:</b> enter the name <i>Computer</i> to let the computer choose and play automatically.</p>
                <p><i>Example:</i> target K, 2 matches, guess 16. The second King is card 7,
                   so the score is (16 &minus; 7) &divide; 2 = <b>4.5</b>.</p>
                </body></html>
                """;
        JOptionPane.showMessageDialog(this, rules, "How to Play", JOptionPane.INFORMATION_MESSAGE);
    }

    private void confirmExit() {
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit RankMatch?",
                "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }

    private void comingSoon(String feature) {
        JOptionPane.showMessageDialog(this, feature + " is not connected yet.",
                "RankMatch", JOptionPane.INFORMATION_MESSAGE);
    }

    private static JLabel centredLabel(String text, Font font, Color colour) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(colour);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    // ---------- Custom components ----------

    /** Background panel: green felt with a soft spotlight and a gold border. */
    private static class FeltPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int w = getWidth(), h = getHeight();

            g2.setPaint(new RadialGradientPaint(new Point(w / 2, h / 4), Math.max(w, h) * 0.8f,
                    new float[]{0f, 1f}, new Color[]{FELT_LIGHT, FELT_DARK}));
            g2.fillRect(0, 0, w, h);

            g2.setColor(new Color(GOLD.getRed(), GOLD.getGreen(), GOLD.getBlue(), 140));
            g2.setStroke(new BasicStroke(2f));
            g2.draw(new RoundRectangle2D.Double(10, 10, w - 21, h - 21, 20, 20));
            g2.dispose();
        }
    }

    /** Rounded, flat button with a hover effect. The primary button is filled gold. */
    private static class MenuButton extends JButton {
        private final boolean primary;
        private boolean hover = false;

        MenuButton(String text, boolean primary) {
            super(text);
            this.primary = primary;
            setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
            setFocusPainted(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setOpaque(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

            addMouseListener(new MouseAdapter() {
                @Override public void mouseEntered(MouseEvent e) { hover = true; repaint(); }
                @Override public void mouseExited(MouseEvent e) { hover = false; repaint(); }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int w = getWidth(), h = getHeight();
            RoundRectangle2D shape = new RoundRectangle2D.Double(1, 1, w - 3, h - 3, h - 3, h - 3);

            boolean enabled = isEnabled();
            boolean lit = enabled && (hover || getModel().isPressed() || isFocusOwner());
            Color text;

            if (primary) {
                Color fill = !enabled ? GOLD.darker().darker() : lit ? GOLD.brighter() : GOLD;
                g2.setColor(fill);
                g2.fill(shape);
                text = FELT_DARK;
            } else {
                g2.setColor(lit ? new Color(255, 255, 255, 40) : new Color(0, 0, 0, 60));
                g2.fill(shape);
                g2.setColor(enabled ? GOLD : new Color(GOLD.getRed(), GOLD.getGreen(), GOLD.getBlue(), 80));
                g2.setStroke(new BasicStroke(lit ? 2f : 1.4f));
                g2.draw(shape);
                text = enabled ? TEXT_LIGHT : new Color(235, 240, 235, 90);
            }

            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            g2.setColor(text);
            g2.drawString(getText(), (w - fm.stringWidth(getText())) / 2,
                    (h - fm.getHeight()) / 2 + fm.getAscent());
            g2.dispose();
        }
    }
}
