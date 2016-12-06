package com.huashan.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片处理工具
 * @author chenzhenwei
 *
 */
public class ImageUtil {
	private Image img;
	private int width;
	private int height;
	
	private File destPath;

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\chenzhenwei\\Desktop\\file\\379_P_1410415347128.jpg");
		System.out.println(file.getName());
//		System.out.println("开始：" + new Date().getTime());
//		ImageUtil imgCom = new ImageUtil("C:\\Users\\chenzhenwei\\Desktop\\file\\379_P_1410415347128.jpg", "C:\\Users\\chenzhenwei\\Desktop\\file\\379_P_1410415347128_th.jpg");
//		imgCom.resizeByWidth(200);
//		System.out.println("结束：" + new Date().getTime());
	}
	
	/**
	 * 检查文件如果是图片文件则返回true，反之返回false
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static boolean checkFileIsImage(File file) throws IOException {
		if (file.isDirectory()) return false;
		BufferedImage bi = ImageIO.read(file);
		return bi != null;
	}

	public static boolean checkFileIsImage(String filePath) throws IOException {
		return checkFileIsImage(new File(filePath));
	}

	/**
	 * 构造函数
	 */
	public ImageUtil(String srcPath, String destPath) throws IOException {
		init(srcPath, new File(destPath));
	}
	
	public ImageUtil(String srcPath, File destPath) throws IOException {
		init(srcPath, destPath);
	}
	
	private void init(String srcPath, File destPath) throws IOException {
		File file = new File(srcPath);// 读入文件
		img = ImageIO.read(file); // 构造Image对象
		width = img.getWidth(null); // 得到源图宽
		height = img.getHeight(null); // 得到源图长
		this.destPath = destPath;
	}

	/**
	 * 按照宽度还是高度进行压缩
	 * 
	 * @param w
	 *            int 最大宽度
	 * @param h
	 *            int 最大高度
	 */
	public void resizeFix(int w, int h) throws IOException {
		if (width / height > w / h) {
			resizeByWidth(w);
		} else {
			resizeByHeight(h);
		}
	}

	/**
	 * 以宽度为基准，等比例放缩图片
	 * 
	 * @param w
	 *            int 新宽度
	 */
	public void resizeByWidth(int w) throws IOException {
		int h = (int) (height * w / width);
		resize(w, h);
	}

	/**
	 * 以高度为基准，等比例缩放图片
	 * 
	 * @param h
	 *            int 新高度
	 */
	public void resizeByHeight(int h) throws IOException {
		int w = (int) (width * h / height);
		resize(w, h);
	}

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w
	 *            int 新宽度
	 * @param h
	 *            int 新高度
	 */
	public void resize(int w, int h) throws IOException {
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
		File destFile = destPath;
		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
		// 可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG编码
		out.close();
	}
}
