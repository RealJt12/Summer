package com.realjt.summer.summer.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于生成验证码
 * 
 * @author RealJt
 */
public class ValidateCodeServlet extends HttpServlet
{
	private static final long serialVersionUID = -2986582893576357359L;

	// 验证码由哪些字符组成
	private static final char[] CODE_SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890"
			.toCharArray();

	public static final String VALIDATE_CODE = "VALIDATE_CODE";

	// 设置验证图片的宽度, 高度, 验证码的个数
	private int width = 150;
	private int height = 40;

	// 验证码字符个数
	private int codeCount = 4;
	// 验证码字体的高度
	private int fontHeight = 4;

	// 验证码中的单个字符基线. 即：验证码中的单个字符位于验证码图形左上角的 (codeX, codeY) 位置处
	private int codeX = 0;
	private int codeY = 0;

	// 初始化验证码图形属性
	public void init()
	{
		fontHeight = height - 2;
		codeX = width / (codeCount + 2);
		codeY = height - 4;
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 定义一个类型为BufferedImage.TYPE_INT_BGR类型的图像缓存
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

		// 在bufferedImage中创建一个Graphics2D图像
		Graphics2D graphics = bufferedImage.createGraphics();

		// 设置一个颜色, 使Graphics2D对象的后续图形使用这个颜色
		graphics.setColor(Color.WHITE);

		// 填充一个指定的矩形: x - 要填充矩形的 x 坐标; y - 要填充矩形的 y 坐标; width - 要填充矩形的宽度; height
		// - 要填充矩形的高度
		graphics.fillRect(0, 0, width, height);

		// 创建一个 Font 对象: name - 字体名称; style - Font 的样式常量; size - Font的点大小
		Font font = new Font("", Font.BOLD, fontHeight);
		// 使 Graphics2D 对象的后续图形使用此字体
		graphics.setFont(font);

		// graphics.setColor(Color.BLACK);

		// 绘制指定矩形的边框, 绘制出的矩形将比构件宽一个也高一个像素
		// graphics.drawRect(0, 0, width - 1, height - 1);

		// 随机产生 15 条干扰线, 使图像中的认证码不易被其它程序探测到
		SecureRandom secureRandom = new SecureRandom();
		graphics.setColor(Color.GREEN);
		for (int i = 0; i < 60; i++)
		{
			int x = secureRandom.nextInt(width);
			int y = secureRandom.nextInt(height);
			int x1 = secureRandom.nextInt(20);
			int y1 = secureRandom.nextInt(20);

			graphics.drawLine(x, y, x + x1, y + y1);
		}

		// 用随机产生的颜色将验证码绘制到图像中
		graphics.setColor(Color.BLUE);
		// 创建 randomCode 对象, 用于保存随机产生的验证码, 以便用户登录后进行验证
		StringBuffer randomCode = new StringBuffer();
		for (int i = 0; i < codeCount; i++)
		{
			// 得到随机产生的验证码数字
			String strRand = String.valueOf(CODE_SOURCE[secureRandom.nextInt(61)]);

			// 把正在产生的随机字符放入到StringBuffer中
			randomCode.append(strRand);

			int random = secureRandom.nextInt(3);

			graphics.setColor(
					new Color(secureRandom.nextInt(255), secureRandom.nextInt(255), secureRandom.nextInt(255)));
			if (random % 2 == 1)
			{
				graphics.drawString(strRand, (i + 1) * codeX - random * 3, codeY + random);
			} else
			{
				graphics.drawString(strRand, (i + 1) * codeX + random * 3, codeY - random);
			}
		}

		// 再把存放有所有随机字符的StringBuffer对应的字符串放入到HttpSession中
		request.getSession().setAttribute(VALIDATE_CODE, randomCode.toString());

		// 禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 将图像输出到输出流中
		ServletOutputStream servletOutputStream = response.getOutputStream();
		ImageIO.write(bufferedImage, "jpeg", servletOutputStream);
		servletOutputStream.close();
	}

}
