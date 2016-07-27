package io.attil.decoratorj;

public class BaseImage implements Image {
	private Object imageObject;
	
	public BaseImage(Object imageObject) {
		this.imageObject = imageObject;
	}
	
	@Override
	public Object getInternalImage() {
		return imageObject;
	}

	public Image getParent() {
		return this;
	}
}
