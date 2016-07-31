package io.attil.decoratorj;

import marvin.image.MarvinImage;

public class BaseImage implements Image {
	private MarvinImage imageObject;
	
	public BaseImage(MarvinImage imageObject) {
		this.imageObject = imageObject;
	}
	
	@Override
	public MarvinImage getInternalImage() {
		return imageObject.clone();
	}

	@Override
	public Image getParent() {
		return this;
	}
}
