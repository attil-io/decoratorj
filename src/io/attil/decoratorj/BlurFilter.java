package io.attil.decoratorj;

import marvin.image.MarvinImage;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class BlurFilter extends ImageDecorator {

	private MarvinImagePlugin imagePlugin;
	
	public BlurFilter(Image image) {
		super(image);
		imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.blur.gaussianBlur.jar");
	}

	@Override
	public MarvinImage getInternalImage() {
		MarvinImage image = getParent().getInternalImage();
		imagePlugin.process(image, image);
		image.update();
		return image;
	}


}
