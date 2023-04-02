/* 
 * $Id$
 *
 * ### Copyright (C) 2007 Michael Fuchs ###
 * ### All Rights Reserved.             ###
 *
 * Author: Michael Fuchs
 * E-Mail: michael.fuchs@unico-group.com
 * URL:    http://www.michael-a-fuchs.de
 */
package org.dbdoclet.xiphias;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.dbdoclet.Sfv;
import org.dbdoclet.service.FileServices;

public class ImageServices {

	public static double A4_WIDTH = 210.0;
	public static double A4_HEIGHT = 297.0;
	public static double INCH = 25.4;
	public static int DPI = 72;

	public static int getWidth(File imageFile) {

		if (imageFile == null) {
			throw new IllegalArgumentException("The argument imageFile must not be null!");
		}

		ImageIcon image = new ImageIcon(imageFile.getAbsolutePath());
		return image.getIconWidth();
	}

	public static int getHeight(File imageFile) {

		if (imageFile == null) {
			throw new IllegalArgumentException("The argument imageFile must not be null!");
		}

		ImageIcon image = new ImageIcon(imageFile.getAbsolutePath());
		return image.getIconHeight();
	}

	public static File giftopng(File gifFile) throws IOException {

		if (gifFile == null) {
			throw new IllegalArgumentException("The argument gifFile must not be null!");
		}

		String pngPath = FileServices.getFileBase(gifFile) + ".png";
		File pngFile = new File(pngPath);

		return giftopng(gifFile, pngFile);
	}

	public static File giftopng(File gifFile, File pngFile) throws IOException {

		if (gifFile == null) {
			throw new IllegalArgumentException("The argument gifFile must not be null!");
		}

		if (pngFile == null) {
			throw new IllegalArgumentException("The argument pngFile must not be null!");
		}

		BufferedImage image = ImageIO.read(gifFile);
		ImageIO.write(image, "png", pngFile);

		return pngFile;
	}

	public static String toBase64(File inFile) throws IOException {

		if (inFile == null) {
			throw new IllegalArgumentException("The argument inFile  must not be null!");
		}

		if (inFile.exists() == false) {
			throw new IllegalArgumentException("The argument inFile must exist!");
		}

		byte[] enc = Base64.getEncoder().encode(FileServices.readToByteArray(inFile));

		return new String(enc, "UTF-8");
	}

	public static String toXml(File inFile) throws IOException {

		String xml = toBase64(inFile);

		xml = "<?xml version='1.0' encoding='UTF-8'?>" + Sfv.LSEP + "<image file=\"" + inFile.getCanonicalPath() + "\">"
				+ xml + "</image>" + Sfv.LSEP;

		return xml;
	}

	public static boolean scale(File imageFile, int maxWidth) throws IOException {

		if (imageFile == null) {
			throw new IllegalArgumentException("The argument imageFile must not be null!");
		}

		if (maxWidth < 1) {
			throw new IllegalArgumentException("The argument maxWidth must not be less than 1!");
		}

		String format = FileServices.getExtension(imageFile.getName());

		BufferedImage image = ImageIO.read(imageFile);
		int width = image.getWidth();
		int height = image.getHeight();

		if (width > maxWidth) {

			float factor = (float) maxWidth / (float) width;

			height *= factor;
			width = maxWidth;

			Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

			BufferedImage scaledBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics graphics = scaledBufferedImage.getGraphics();
			graphics.drawImage(scaledImage, 0, 0, null);

			ImageIO.write(scaledBufferedImage, format, imageFile);

			return true;
		}

		return false;
	}

	public static ImageIcon getScaledIcon(ImageIcon icon, int width, int height) {

		if (height < 1 && width < 1) {
			throw new IllegalArgumentException("Both arguments height and width must not be smaller than 1!");
		}

		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();

		if (iconHeight < 1 && iconWidth < 1) {
			return icon;
		}

		if (width < 1) {
			width = (height * iconWidth) / iconHeight;
			if (width < 1) {
				width = 1;
			}
		}

		if (height < 1) {
			height = (width * iconHeight) / iconWidth;
			if (height < 1) {
				height = 1;
			}
		}

		Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon.setImage(image);
		return icon;
	}

	public static BufferedImage toBufferedImage(Image image) {

		if (image == null) {
			throw new IllegalArgumentException("The argument image must not be null!");
		}

		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();

		// Determine if the image has transparent pixels; for this method's
		// implementation, see e661 Determining If an Image Has Transparent
		// Pixels
		boolean hasAlpha = hasAlpha(image);

		// Create a buffered image with a format that's compatible with the
		// screen
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		// Determine the type of transparency of the new buffered image
		int transparency = Transparency.OPAQUE;
		if (hasAlpha) {
			transparency = Transparency.BITMASK;
		}

		// Create the buffered image
		GraphicsDevice gs = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gs.getDefaultConfiguration();
		bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);

		if (bimage == null) {

			// Create a buffered image using the default color model
			int type = BufferedImage.TYPE_INT_RGB;
			if (hasAlpha) {
				type = BufferedImage.TYPE_INT_ARGB;
			}

			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		}

		// Copy image to buffered image
		Graphics g = bimage.createGraphics();

		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}

	/**
	 * This method returns true if the specified image has transparent pixels
	 */
	public static boolean hasAlpha(Image image) {

		// If buffered image, the color model is readily available

		if (image instanceof BufferedImage) {

			BufferedImage bimage = (BufferedImage) image;
			return bimage.getColorModel().hasAlpha();
		}

		// Use a pixel grabber to retrieve the image's color model;
		// grabbing a single pixel is usually sufficient

		PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
		try {
			pg.grabPixels();
		} catch (InterruptedException oops) {
			oops.printStackTrace();
		}

		// Get the image's color model
		ColorModel cm = pg.getColorModel();
		return cm.hasAlpha();
	}
}
