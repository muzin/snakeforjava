package cn.muzin;

import cn.muzin.context.SnakeContext;
import cn.muzin.entity.Food;
import cn.muzin.entity.Snake;
import cn.muzin.entity.SnakeMap;
import cn.muzin.gui.SnakeFrame;
import cn.muzin.gui.event.SnakeKeyEvent;
import cn.muzin.thread.SnakeDrawThread;
import cn.muzin.thread.SnakeRunThread;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // write your code here

        initSnake();

        initFood();

        initSnakeFrame();

        runThread();

    }


    public static void initSnakeFrame(){
        SnakeFrame snakeFrame = new SnakeFrame();

        SnakeContext.getInstance().setContext("snakeFrame", snakeFrame);

        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenDimension.getWidth();
        int screenHeight = (int) screenDimension.getHeight();
        int windowWidth = SnakeMap.WIDTH;
        int windowHeight = SnakeMap.HEIGHT + 22 + 25;
        int windowPositionX = (int) Math.floor((screenWidth - windowWidth) / 2);
        int windowPositionY = (int) Math.floor((screenHeight - windowHeight) / 2);

        snakeFrame.setTitle("贪食蛇");
        snakeFrame.setBounds(windowPositionX, windowPositionY, windowWidth, windowHeight);

        // 设置窗口关闭按钮的默认操作(点击关闭时退出进程)
        snakeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 把窗口位置设置到屏幕的中心
        snakeFrame.setLocationRelativeTo(null);

        snakeFrame.addKeyListener(new SnakeKeyEvent());

        snakeFrame.setVisible(true);

    }

    /**
     * TODO 初始化 蛇
     */
    public static void initSnake(){

        Snake snake = new Snake();

        SnakeContext.getInstance().setContext("snake", snake);

    }


    /**
     * TODO 初始化 食物
     */
    public static void initFood(){

        Food food = new Food(Snake.snakeWidth, Snake.snakeHeight);
        food.random();

        SnakeContext.getInstance().setContext("food", food);

    }


    /**
     * 启动线程
     */
    public static void runThread(){


        // snake frame 绘制时 启动 贪吃蛇绘制线程
        SnakeDrawThread snakeDrawThread = new SnakeDrawThread();
        Thread snakeDrawMainThread = new Thread(snakeDrawThread);
        snakeDrawMainThread.start();

        SnakeRunThread snakeRunThread = new SnakeRunThread();
        Thread snakeRunMainThread = new Thread(snakeRunThread);
        snakeRunMainThread.start();


        SnakeContext.getInstance().setContext("snakeDrawThread", snakeDrawThread);
        SnakeContext.getInstance().setContext("snakeRunThread", snakeRunThread);



    }

}
