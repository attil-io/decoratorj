package io.attil.decoratorj;

public abstract class ImageDecorator implements Image {

	private Image image;
	
	public ImageDecorator(Image image) {
		this.image = image;
	}
	
	public Image getParent() {
		return image;
	}
}
