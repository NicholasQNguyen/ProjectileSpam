package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

/** Abstract class for the panels.
 *
 * @author Nicholas Nguyen
 *
 */
public abstract class AbstractPanel extends JPanel implements Runnable {
  private static final long serialVersionUID = 139014299663258784L;
  // Tile settings
  final int originalTileSize = 16;
  final int scale = 3;
  public final int tileSize = originalTileSize * scale;

  // Screen Settings
  public final int maxScreenColumns = 32;
  public final int maxScreenRows = 14;
  public final int screenWidth = tileSize * maxScreenColumns;
  public final int screenHeight = tileSize * maxScreenRows;

  // World Settings
  public final int maxWorldColumns = 32;
  public final int maxWorldRows = 17;
  public final int worldWidth = this.maxWorldColumns * this.tileSize;
  public final int worldHeight = this.maxWorldRows * this.tileSize;
  
  Thread thread;

  public AbstractPanel() {
  }

  // The game loop
  @Override
  public void run() {
    while (thread != null) {
      if (Clock.getInstance().update()) {
        update(Clock.getInstance().getDelta());
        repaint();
      }
    }
  }
  
  abstract void update(double delta);

  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
  }
}