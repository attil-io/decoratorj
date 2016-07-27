package io.attil.decoratorj;

public class BlurFilter extends ImageDecorator {

	public BlurFilter(Image image) {
		super(image);
	}

	@Override
	public Object getInternalImage() {
		Object image = getParent().getInternalImage();
		System.out.println("blurring image");
		return image;
	}


}
