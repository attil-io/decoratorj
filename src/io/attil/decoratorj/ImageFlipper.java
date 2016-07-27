package io.attil.decoratorj;

public class ImageFlipper extends ImageDecorator {

	public ImageFlipper(Image image) {
		super(image);
	}

	@Override
	public Object getInternalImage() {
		System.out.println("flipping image");
		return null;
	}

}
