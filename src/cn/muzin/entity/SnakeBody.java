package cn.muzin.entity;

/**
 * 蛇身对象
 * 用于保存蛇身信息
 */
public class SnakeBody {

    // 坐标 x
    private int x;

    // 坐标 y
    private int y;

    // 宽
    private int width;

    // 高
    private int height;

    public SnakeBody(){  }

    public SnakeBody(int x, int y, int width, int height){

        this.x = x;

        this.y = y;

        this.width = width;

        this.height = height;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SnakeBody setX(int x) {
        this.x = x;
        return this;
    }

    public SnakeBody setY(int y) {
        this.y = y;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public SnakeBody setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public SnakeBody setHeight(int height) {
        this.height = height;
        return this;
    }
}
