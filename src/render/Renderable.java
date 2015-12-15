package render;

import java.awt.Graphics2D;

public interface Renderable {

	public void draw(Graphics2D g);

	public boolean isVisible();

	public int getZ();

}
