package cn.muzin.entity;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public static final int snakeWidth = 25;

    public static final int snakeHeight = 25;

    // 蛇身
    private List<SnakeBody> bodys = null;

    // 当前移动方向
    public Direction currentDirection = null;

    public static enum Direction  {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    public Snake() {

        // 初始化 蛇身体
        bodys = new ArrayList<SnakeBody>();

        // 方向随机值数组，
        Direction[] randomDirectionBase = new Direction[]{
                Direction.LEFT,
                Direction.RIGHT,
                Direction.TOP,
                Direction.BOTTOM};

        // 当前方向根据 方向枚举进行随机
        currentDirection = randomDirectionBase[(int)Math.floor(Math.random() * 4)];

        // 初始化 蛇身
        initSnakeBody();

    }

    /**
     * 初始化 贪吃蛇身体
     *
     * 随机蛇头，并初始化3个蛇身
     */
    private void initSnakeBody(){

        int snakeHeadX = (int) Math.floor(Math.random() * (SnakeMap.WIDTH / snakeWidth - 5)) + 5;
        int snakeHeadY = (int) Math.floor(Math.random() * (SnakeMap.HEIGHT / snakeHeight - 5)) + 5;

        for(int i = 0; i < 3; i++){

           if(Direction.LEFT == currentDirection) {
               SnakeBody snakeBodyItem = new SnakeBody()
                       .setX(snakeHeadX + i)
                       .setY(snakeHeadY)
                       .setWidth(snakeWidth)
                       .setHeight(snakeHeight);
               // 添加 蛇身到 蛇内部
               getBodys().add(snakeBodyItem);

           }else if(Direction.RIGHT == currentDirection) {
               SnakeBody snakeBodyItem = new SnakeBody()
                       .setX(snakeHeadX - i)
                       .setY(snakeHeadY)
                       .setWidth(snakeWidth)
                       .setHeight(snakeHeight);
               // 添加 蛇身到 蛇内部
               getBodys().add(snakeBodyItem);
           }else if(Direction.TOP == currentDirection) {
               SnakeBody snakeBodyItem = new SnakeBody()
                       .setX(snakeHeadX)
                       .setY(snakeHeadY - i)
                       .setWidth(snakeWidth)
                       .setHeight(snakeHeight);
               // 添加 蛇身到 蛇内部
               getBodys().add(snakeBodyItem);
           }else if(Direction.BOTTOM == currentDirection) {
               SnakeBody snakeBodyItem = new SnakeBody()
                       .setX(snakeHeadX)
                       .setY(snakeHeadY + i)
                       .setWidth(snakeWidth)
                       .setHeight(snakeHeight);
               // 添加 蛇身到 蛇内部
               getBodys().add(snakeBodyItem);
           }

        }

    }

    // 获取蛇头
    public SnakeBody getHead(){

        if(bodys != null && bodys.size() != 0){
            return bodys.get(0);
        }else{
            return null;
        }

    }

    public List<SnakeBody> getBodys(){
        return this.bodys;
    }


    // 获取蛇尾
    public SnakeBody getTail(){

        if(bodys != null && bodys.size() != 0){
            return bodys.get(bodys.size() - 1);
        }else{
            return null;
        }

    }

    /**
     * 获取蛇的长度
     * @return
     */
    public int getSize(){
        if(bodys != null){
            return bodys.size();
        }else{
            return 0;
        }
    }

    /**
     * TODO 增加身体
     *
     * 根据 蛇尾和蛇尾倒数第二个计算出蛇尾的移动方向，判断蛇身体应该添加到哪一边
     * @return
     */
    public Snake addBody(){

        Direction snakeTailDirection = null;

        SnakeBody lastSnakeBody = this.getTail();
        SnakeBody previousOfLastSnakeBody = this.getBodys().get(this.getBodys().size() - 2);

        // x轴相同，说明  蛇 是 上下移动
        if(previousOfLastSnakeBody.getX() == lastSnakeBody.getX()){
            // 蛇 向 上移动
            if(previousOfLastSnakeBody.getY() < lastSnakeBody.getY()){
                snakeTailDirection = Snake.Direction.TOP;
                // 蛇 向 下移动
            }else{
                snakeTailDirection = Snake.Direction.BOTTOM;
            }
        }else{
            // 蛇 向左移动
            if(previousOfLastSnakeBody.getX() < lastSnakeBody.getX()){
                snakeTailDirection = Snake.Direction.LEFT;
                // 蛇 向 右移动
            }else{
                snakeTailDirection = Snake.Direction.RIGHT;
            }
        }

        if(Direction.LEFT == snakeTailDirection) {
            SnakeBody snakeBodyItem = new SnakeBody()
                    .setX(lastSnakeBody.getX() + 1)
                    .setY(lastSnakeBody.getY())
                    .setWidth(snakeWidth)
                    .setHeight(snakeHeight);
            // 添加 蛇身到 蛇内部
            getBodys().add(snakeBodyItem);

        }else if(Direction.RIGHT == snakeTailDirection) {
            SnakeBody snakeBodyItem = new SnakeBody()
                    .setX(lastSnakeBody.getX() - 1)
                    .setY(lastSnakeBody.getY())
                    .setWidth(snakeWidth)
                    .setHeight(snakeHeight);
            // 添加 蛇身到 蛇内部
            getBodys().add(snakeBodyItem);
        }else if(Direction.TOP == snakeTailDirection) {
            SnakeBody snakeBodyItem = new SnakeBody()
                    .setX(lastSnakeBody.getX())
                    .setY(lastSnakeBody.getY() - 1)
                    .setWidth(snakeWidth)
                    .setHeight(snakeHeight);
            // 添加 蛇身到 蛇内部
            getBodys().add(snakeBodyItem);
        }else if(Direction.BOTTOM == snakeTailDirection) {
            SnakeBody snakeBodyItem = new SnakeBody()
                    .setX(lastSnakeBody.getX())
                    .setY(lastSnakeBody.getY() + 1)
                    .setWidth(snakeWidth)
                    .setHeight(snakeHeight);
            // 添加 蛇身到 蛇内部
            getBodys().add(snakeBodyItem);
        }


        return null;
    }

    /**
     * 设置当前移动方向
     * @param d
     * @return
     */
    public Snake setCurrentDirection(Direction d){
        this.currentDirection = d;
        return this;
    }

    /**
     * 检查是否越界
     * @return
     */
    public boolean isBeachBound(){
        if((this.getHead().getX() <= 0 && this.currentDirection == Snake.Direction.LEFT)
                || (this.getHead().getX() >= (SnakeMap.WIDTH/Snake.snakeWidth-1) && this.currentDirection == Snake.Direction.RIGHT)
                || (this.getHead().getY() <= 0 && this.currentDirection == Snake.Direction.TOP)
                || (this.getHead().getY() >= (SnakeMap.HEIGHT/Snake.snakeHeight) && this.currentDirection == Snake.Direction.BOTTOM)
        ){
            return true;
        }else{
            return false;
        }
    }

}
