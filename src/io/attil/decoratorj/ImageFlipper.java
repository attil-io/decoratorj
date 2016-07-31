package io.attil.decoratorj;

import marvin.image.MarvinImage;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class ImageFlipper extends ImageDecorator {

	private MarvinImagePlugin imagePlugin;
	
	public ImageFlipper(Image image) {
		super(image);
		imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.transform.flip.jar");
	}

	@Override
	public MarvinImage getInternalImage() {
		MarvinImage image = getParent().getInternalImage();
		imagePlugin.process(image, image);
		image.update();
		return image;
	}

}
