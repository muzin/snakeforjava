package cn.muzin.thread;

import cn.muzin.context.SnakeContext;
import cn.muzin.entity.Food;
import cn.muzin.entity.Snake;
import cn.muzin.entity.SnakeBody;
import cn.muzin.entity.SnakeMap;

import java.util.List;

/**
 * 贪吃蛇 运行 线程
 */
public class SnakeRunThread implements Runnable {

    // 贪吃蛇的运行速率
    private int speed = 300;

    @Override
    public void run() {
        System.out.println("贪吃蛇运行线程启动...");


        while(true){

            Snake snake = (Snake) SnakeContext.getInstance().getContext("snake");
            Food food = (Food) SnakeContext.getInstance().getContext("food");

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 蛇头 与 食物 重合
            if(snake.getHead().getX() == food.getX()
                    && snake.getHead().getY() == food.getY()){

                System.out.println("蛇头 与 食物 重合");
                // 蛇吃到食物后，食物随机一个位置
                food.random();
                // 蛇身增加
                snake.addBody();


            }

            if(snake.isBeachBound()) {

                System.out.println("即将越界");
                continue;

            }



            List<SnakeBody> snakeBodyList = snake.getBodys();

            // 除蛇头，将前一个的坐标值复制给前一个
            for(var i = snakeBodyList.size() - 1; i > 0; i--){

                SnakeBody currentSnakeBody = snakeBodyList.get(i);
                SnakeBody previousSnakeBody = snakeBodyList.get(i - 1);

                int previousX = previousSnakeBody.getX();
                int previousY = previousSnakeBody.getY();

                currentSnakeBody
                        .setX(previousX)
                        .setY(previousY);

            }

            SnakeBody snakeHead = snake.getHead();

            if(snake.currentDirection == Snake.Direction.LEFT){

                snakeHead.setX(snakeHead.getX() - 1);

            }else if(snake.currentDirection == Snake.Direction.RIGHT){

                snakeHead.setX(snakeHead.getX() + 1);

            }else if(snake.currentDirection == Snake.Direction.TOP){

                snakeHead.setY(snakeHead.getY() - 1);

            }else if(snake.currentDirection == Snake.Direction.BOTTOM){

                snakeHead.setY(snakeHead.getY() + 1);

            }



        }

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
