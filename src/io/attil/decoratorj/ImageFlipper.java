package io.attil.decoratorj;

import marvin.image.MarvinImage;

public class ImageFlipper extends ImageDecorator {

	public ImageFlipper(Image image) {
		super(image);
	}

	@Override
	public MarvinImage getInternalImage() {
		MarvinImage image = getParent().getInternalImage();
		System.out.println("flipping image");
		return image;
	}

}
