package cn.muzin.gui;

import cn.muzin.context.SnakeContext;
import cn.muzin.entity.Snake;
import cn.muzin.thread.SnakeDrawThread;

import javax.swing.*;
import java.awt.*;

public class SnakeFrame extends JFrame {



    public void paint(Graphics g){
        super.paint(g);

        System.out.println("refresh draw");

        Graphics2D g2d = (Graphics2D) g.create();

        // 将 图形对象 设置到贪吃蛇绘制线程中
        SnakeDrawThread snakeDrawThread = (SnakeDrawThread)SnakeContext.getInstance().getContext("snakeDrawThread");
        Snake snake = (Snake)SnakeContext.getInstance().getContext("snake");
        snakeDrawThread.setGraphics(g2d);
        snakeDrawThread.setSnake(snake);


    }




}
