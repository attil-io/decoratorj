package io.attil.decoratorj;

import java.io.File;
import net.imglib2.img.Img;
import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.NumericType;

public class Main {

	public static void main(String[] args) {
		Object image = new Object();
		BaseImage baseImage = new BaseImage(image);
		ImageFlipper imageFlipper = new ImageFlipper(baseImage);
		BlurFilter blurFilter = new BlurFilter(imageFlipper);

		Object blurredFilteredImage = blurFilter.getInternalImage();
		
		File file = new File("lena.gif");
	}
}
