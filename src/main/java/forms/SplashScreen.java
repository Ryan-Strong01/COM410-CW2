package forms;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

/**
 * Splash screen for the RankMatch card game.
 *
 * Shows the game title, a fan of playing cards and a loading bar, then
 * closes itself and runs {@code onFinished} (e.g. opening the main menu).
 * Clicking anywhere on the splash skips straight to the end.
 */
public class SplashScreen extends JFrame {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 400;
    private static final int TIMER_DELAY_MS = 40;
    private static final int FINISH_DELAY_MS = 450;
    private static final int MAX_PROGRESS = 100;
    private static final int STATUS_INTERVAL = 20;

    private static final int CARD_WIDTH = 78;
    private static final int CARD_HEIGHT = 110;

    // Palette: card-table green with gold accents
    private static final Color FELT_LIGHT = new Color(32, 112, 74);
    private static final Color FELT_DARK = new Color(10, 48, 32);
    private static final Color GOLD = new Color(232, 190, 92);
    private static final Color CARD_RED = new Color(196, 40, 52);
    private static final Color CARD_BLACK = new Color(28, 28, 32);

    private static final String[] STATUS_MESSAGES = {
            "Shuffling the deck...",
            "Dealing cards...",
            "Ranking the players...",
            "Setting the table...",
            "Ready to play!"
    };

    private final Runnable onFinished;
    private final Timer timer;
    private int progress;
    private boolean finished;
    private boolean finishScheduled;

    public SplashScreen(Runnable onFinished) {
        this.onFinished = Objects.requireNonNull(onFinished, "Finish action must not be null");

        setUndecorated(true);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, WIDTH, HEIGHT, 28, 28));
        setAlwaysOnTop(true);
        SplashPanel panel = new SplashPanel();
        setContentPane(panel);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                finish();
            }
        });
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "skipSplash");
        panel.getActionMap().put("skipSplash", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                finish();
            }
        });

        // Advance the loading bar every 40 ms (about 4 seconds total)
        timer = new Timer(TIMER_DELAY_MS, e -> tick());
    }

    /** Shows the splash and starts the loading animation. */
    public void start() {
        setVisible(true);
        timer.start();
    }

    private void tick() {
        if (progress >= MAX_PROGRESS && !finishScheduled) {
            timer.stop();
            finishScheduled = true;
            Timer close = new Timer(FINISH_DELAY_MS, e -> finish());
            close.setRepeats(false);
            close.start();
        }
        progress = Math.min(MAX_PROGRESS, progress + 1);
        repaint();
    }

    private void finish() {
        if (finished) return;
        finished = true;
        timer.stop();
        dispose();
        onFinished.run();
    }

    private String statusMessage() {
        int messageIndex = Math.min(progress / STATUS_INTERVAL, STATUS_MESSAGES.length - 1);
        return STATUS_MESSAGES[messageIndex];
    }

    /** Custom-painted content: background, cards, title and progress bar. */
    private class SplashPanel extends JPanel {

        SplashPanel() {
            setOpaque(true);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            setRenderingHints(g2);

            paintBackground(g2);
            paintCards(g2);
            paintTitle(g2);
            paintProgress(g2);

            g2.dispose();
        }

        private void setRenderingHints(Graphics2D g2) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }

        private void paintBackground(Graphics2D g2) {
            // Radial "spotlight" on the felt
            RadialGradientPaint felt = new RadialGradientPaint(
                    new Point(WIDTH / 2, HEIGHT / 3), WIDTH * 0.75f,
                    new float[]{0f, 1f},
                    new Color[]{FELT_LIGHT, FELT_DARK});
            g2.setPaint(felt);
            g2.fillRect(0, 0, WIDTH, HEIGHT);

            // Thin gold inner border
            g2.setColor(new Color(GOLD.getRed(), GOLD.getGreen(), GOLD.getBlue(), 150));
            g2.setStroke(new BasicStroke(2f));
            g2.draw(new RoundRectangle2D.Double(10, 10, WIDTH - 21, HEIGHT - 21, 20, 20));
        }

        private void paintCards(Graphics2D g2) {
            int cx = WIDTH / 2;
            int baseY = 175;
            // A fan of three cards: rank, suit, colour, angle
            drawCard(g2, cx - 55, baseY, -18, "K", "♥", CARD_RED);
            drawCard(g2, cx + 55, baseY, 18, "Q", "♦", CARD_RED);
            drawCard(g2, cx, baseY - 12, 0, "A", "♠", CARD_BLACK);
        }

        private void drawCard(Graphics2D g2, int centreX, int centreY, double angleDeg,
                              String rank, String suit, Color ink) {
            AffineTransform old = g2.getTransform();
            g2.translate(centreX, centreY);
            g2.rotate(Math.toRadians(angleDeg));

            // Shadow
            g2.setColor(new Color(0, 0, 0, 70));
            g2.fill(cardShape(4, 5));

            // Card face
            g2.setColor(new Color(250, 248, 242));
            g2.fill(cardShape(0, 0));
            g2.setColor(new Color(200, 196, 186));
            g2.setStroke(new BasicStroke(1f));
            g2.draw(cardShape(0, 0));

            // Corner index
            g2.setColor(ink);
            g2.setFont(new Font(Font.SERIF, Font.BOLD, 16));
            g2.drawString(rank, -CARD_WIDTH / 2 + 7, -CARD_HEIGHT / 2 + 19);
            g2.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
            g2.drawString(suit, -CARD_WIDTH / 2 + 7, -CARD_HEIGHT / 2 + 34);

            // Big centre suit
            g2.setFont(new Font(Font.SERIF, Font.PLAIN, 44));
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(suit, -fm.stringWidth(suit) / 2, fm.getAscent() / 2 - 4);

            g2.setTransform(old);
        }

        private RoundRectangle2D cardShape(int xOffset, int yOffset) {
            return new RoundRectangle2D.Double(
                    -CARD_WIDTH / 2.0 + xOffset,
                    -CARD_HEIGHT / 2.0 + yOffset,
                    CARD_WIDTH, CARD_HEIGHT, 12, 12);
        }

        private void paintTitle(Graphics2D g2) {
            String title = "RankMatch";
            g2.setFont(new Font(Font.SERIF, Font.BOLD, 52));
            FontMetrics fm = g2.getFontMetrics();
            int x = (WIDTH - fm.stringWidth(title)) / 2;
            int y = 290;

            g2.setColor(new Color(0, 0, 0, 110));
            g2.drawString(title, x + 2, y + 3);
            g2.setColor(GOLD);
            g2.drawString(title, x, y);

            String tagline = "Match the rank. Win the round.";
            g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
            fm = g2.getFontMetrics();
            g2.setColor(new Color(235, 240, 235, 210));
            g2.drawString(tagline, (WIDTH - fm.stringWidth(tagline)) / 2, y + 26);
        }

        private void paintProgress(Graphics2D g2) {
            int barW = 360, barH = 8;
            int x = (WIDTH - barW) / 2;
            int y = HEIGHT - 46;

            // Track
            g2.setColor(new Color(0, 0, 0, 90));
            g2.fill(new RoundRectangle2D.Double(x, y, barW, barH, barH, barH));

            // Fill
            int fillW = barW * progress / 100;
            if (fillW > 0) {
                g2.setPaint(new GradientPaint(x, y, GOLD.darker(), x + barW, y, GOLD));
                g2.fill(new RoundRectangle2D.Double(x, y, fillW, barH, barH, barH));
            }

            // Status text and percentage
            g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
            g2.setColor(new Color(220, 230, 222));
            g2.drawString(statusMessage(), x, y - 8);
            String pct = progress + "%";
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(pct, x + barW - fm.stringWidth(pct), y - 8);

            // Version, bottom-right
            g2.setColor(new Color(220, 230, 222, 120));
            g2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
            String version = "v1.0";
            g2.drawString(version, WIDTH - g2.getFontMetrics().stringWidth(version) - 18, HEIGHT - 18);
        }
    }
}