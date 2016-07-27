package io.attil.decoratorj;

public class BlurFilter extends ImageDecorator {

	public BlurFilter(Image image) {
		super(image);
	}

	@Override
	public Object getInternalImage() {
		System.out.println("blurring image");
		return null;
	}


}
