package cn.muzin.thread;

import cn.muzin.context.SnakeContext;
import cn.muzin.entity.Food;
import cn.muzin.entity.Snake;
import cn.muzin.entity.SnakeBody;
import cn.muzin.entity.SnakeMap;
import cn.muzin.gui.SnakeFrame;

import java.util.List;

import java.awt.*;

/**
 * 贪吃蛇 绘制 线程
 */
public class SnakeDrawThread implements Runnable {

    private Graphics graphics = null;

    private Snake snake = null;

    // 每秒 帧数
    private int fps = 30;

    public SnakeDrawThread(){
    }

    public SnakeDrawThread(Graphics g){
        this.graphics = g;
    }

    public SnakeDrawThread(Snake snake){
        this.snake = snake;
    }

    public SnakeDrawThread(Snake snake, Graphics g){
        this.snake = snake;
        this.graphics = g;
    }

    @Override
    public void run() {

        System.out.println("贪吃蛇绘制线程启动...");

        while(true){

            // 如果 有 snake 对象 和 graphics
            SnakeContext snakeContext = SnakeContext.getInstance();

            try {
                Thread.sleep((long) Math.floor(1000 / fps));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(getGraphics() != null) {
                SnakeFrame snakeFrame = (SnakeFrame) snakeContext.getContext("snakeFrame");
                snakeFrame.paint(getGraphics());
            }


            if(snake != null
                    && graphics != null){

                Color defaultColor = new Color(120, 120,120);

                // 绘制食物
                Food food = (Food) SnakeContext.getInstance().getContext("food");
                if(food != null){
                    graphics.setColor(new Color(255, 120,120));
                    graphics.fillRect(food.getX() * food.getWidth(),
                            food.getY() * food.getHeight() + 22,
                            food.getWidth(),
                            food.getHeight());
                }

                List<SnakeBody> snakeBodys = snake.getBodys();
                for(int i = 0; i < snakeBodys.size(); i++){
                    SnakeBody snakeItem = snakeBodys.get(i);

                    int snakeHeight = snakeItem.getHeight();
                    int snakeWidth = snakeItem.getWidth();
                    int snakeX = snakeItem.getX();
                    int snakeY = snakeItem.getY();

                    if(i != 0){
                        graphics.setColor(new Color(120, 120,120));
                    }else{
                        graphics.setColor(new Color(90, 90,90));
                    }

                    // 绘制矩形
//                    graphics.fillRect(snakeX, snakeY + 35, snakeWidth, snakeHeight);
                    graphics.fillRect(snakeX * snakeWidth,
                            snakeY * snakeHeight + 22,
                            snakeWidth,
                            snakeHeight);

                }



                // 绘制fps
                graphics.setColor(defaultColor);
                        graphics.drawString( "fps :  " + fps, SnakeMap.WIDTH - 60, 35);


                // 绘制 蛇身长度
                graphics.setColor(defaultColor);
                graphics.drawString( "长度: " + snakeBodys.size(), SnakeMap.WIDTH - 60, 35 + 20);

            }

//            System.out.println("[Draw Thread] refresh speed:" + fps);



        }

    }

    public Graphics getGraphics() {
        return graphics;
    }

    public SnakeDrawThread setGraphics(Graphics graphics) {
        this.graphics = graphics;
        return this;
    }

    public Snake getSnake() {
        return snake;
    }

    public SnakeDrawThread setSnake(Snake snake) {
        this.snake = snake;
        return this;
    }

    public int getFps() {
        return fps;
    }

    public SnakeDrawThread setFps(int fps) {
        this.fps = fps;
        return this;
    }


}
