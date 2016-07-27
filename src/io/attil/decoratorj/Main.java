package io.attil.decoratorj;

import java.io.File;

import ij.ImagePlus;
import ij.io.Opener;

public class Main {

	public static void main(String[] args) {
		Object image = new Object();
		BaseImage baseImage = new BaseImage(image);
		ImageFlipper imageFlipper = new ImageFlipper(baseImage);
		BlurFilter blurFilter = new BlurFilter(imageFlipper);

		Object blurredFilteredImage = blurFilter.getInternalImage();
		
		File file = new File("lena.gif");
		final ImagePlus imp = new Opener().openImage( file.getAbsolutePath() );
		imp.show();
	}
}
