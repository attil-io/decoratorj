package io.attil.decoratorj;

public class Main {

	public static void main(String[] args) {
		Object image = new Object();
		BaseImage baseImage = new BaseImage(image);
		ImageFlipper imageFlipper = new ImageFlipper(baseImage);
		BlurFilter blurFilter = new BlurFilter(imageFlipper);

		Object blurredFilteredImage = blurFilter.getInternalImage();
	}
}
