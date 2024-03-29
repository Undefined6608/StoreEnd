package com.store.storeend.util;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Component
public class VerifyCode {
    private final int width = 200;    //生成验证码图片的宽度
    private final int height = 40;    //生成验证码图片的高度
    private final String[] fontNames = {"宋体","楷体","隶书","微软雅黑"};
    private Color bgColor; //定义验证码图片的背景色
    private final Random random = new Random();
    private String text;    //记录随机字符串

    /**
     * 获取随机一个颜色
     * @return 颜色
     */
    private Color randomColor(){
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red,green,blue);
    }

    /**
     * 获取随机一个字体
     * @return 字体
     */
    private Font randomFont(){
        String name = fontNames[random.nextInt(fontNames.length)];
        int style = random.nextInt(4);
        int size =random.nextInt(5)+24;
        return new Font(name,style,size);
    }

    /**
     * 获取随机一个字符
     * @return 字符
     */
    private char randomChar(){
        String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return codes.charAt(random.nextInt(codes.length()));
    }

    /**
     * 创建一个空白的BufferedImage对象
     * @return 图片对象
     */
    private BufferedImage createImage(){
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        bgColor = new Color(random.nextInt(100,255), random.nextInt(100,255), random.nextInt(100, 255),random.nextInt(150,255));
        g2.setColor(bgColor);
        g2.fillRect(0,0,width,height);
        return image;
    }

    /**
     * 绘制干扰线
     */
    private void drawLine(BufferedImage image){
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        int num = 5;
        for (int i = 0 ;i < num ; i++){
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2.setColor(randomColor());
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 绘制验证码
     * @return 验证码图片
     */
    public BufferedImage getImage(){
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < 6 ; i++){
            String s = randomChar() + "";
            sb.append(s);
            g2.setColor(randomColor());
            g2.setFont(randomFont());
            float x =  i * width * 1.0f / 6;
            g2.drawString(s,x,height - 15);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    public String getText(){
        return text;
    }

    /**
     * 用流传输方法
     * @return 图片流
     */
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image,"PNG",out);
    }
}
