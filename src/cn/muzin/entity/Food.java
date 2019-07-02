package cn.muzin.entity;

public class Food {
    // 坐标 x
    private int x;

    // 坐标 y
    private int y;

    // 宽
    private int width;

    // 高
    private int height;

    public Food(){
        this(25, 25);
    }

    public Food(int width, int height){

        this.x = -1;

        this.y = -1;

        this.width = width;

        this.height = height;

    }

    public Food(int x, int y, int width, int height){

        this.x = x;

        this.y = y;

        this.width = width;

        this.height = height;

    }

    public void random(){
        int randomFoodX = ((int) Math.floor(Math.random() * (SnakeMap.WIDTH / Snake.snakeWidth)));
        int randomFoodY = ((int) Math.floor(Math.random() * (SnakeMap.HEIGHT / Snake.snakeHeight)));

        this.x = randomFoodX;
        this.y = randomFoodY;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Food setX(int x) {
        this.x = x;
        return this;
    }

    public Food setY(int y) {
        this.y = y;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Food setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Food setHeight(int height) {
        this.height = height;
        return this;
    }
}
