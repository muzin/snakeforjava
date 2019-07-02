package cn.muzin.gui.event;

import cn.muzin.context.SnakeContext;
import cn.muzin.entity.Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 贪吃蛇键盘监听事件
 */
public class SnakeKeyEvent extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();

        System.out.println("Key Pressed    " + keyCode + "    " + keyChar);

        Snake snake = (Snake) SnakeContext.getInstance().getContext("snake");

        // 方向键 上 或者  w键
        if(keyCode == 38 || keyCode == 87){

            snake.setCurrentDirection(Snake.Direction.TOP);

            // 方向键 下 或者  s键
        }else if(keyCode == 40 || keyCode == 83){

            snake.setCurrentDirection(Snake.Direction.BOTTOM);

            // 方向键 左 或者  a键
        }else if(keyCode == 37 || keyCode == 65){

            snake.setCurrentDirection(Snake.Direction.LEFT);

            // 方向键 右 或者  d键
        }else if(keyCode == 39 || keyCode == 68){

            snake.setCurrentDirection(Snake.Direction.RIGHT);

        }

        System.out.println(snake.currentDirection);

    }
}
