# java版 贪吃蛇 for 教学

# 目录结构
```
├── context
│   └── SnakeContext.java                       贪吃蛇上下文
├── entity
│   ├── Food.java                               食物对象
│   ├── SnakeBody.java                          蛇身体对象
│   ├── Snake.java                              蛇对象
│   └── SnakeMap.java                           贪吃蛇地图对象
├── gui
│   ├── event
│   │   └── SnakeKeyEvent.java                  贪吃蛇键盘事件处理
│   └── SnakeFrame.java                         贪吃蛇界面
├── Main.java                                   主程序
└── thread  
    ├── SnakeDrawThread.java                    贪吃蛇绘制线程
    └── SnakeRunThread.java                     贪吃蛇运行线程
```


## context

### SnakeContext 贪吃蛇上下文
用于存放蛇，食物，以及线程等对象信息

## entity

### Snake 
蛇对象，记录蛇的方向，蛇身信息 
### SnakeBody 
蛇身对象， 记录蛇身坐标，大小等信息
### Food 
食物对象， 记录食物的位置，大小信息
### SnakeMap 
贪吃蛇地图信息， 记录地图的大小 

## gui

### SnakeFrame
贪吃蛇界面，在此Frame中绘制蛇，食物等信息。

绘制时，将graphics对象传给贪吃蛇绘制线程`SnakeDrawThread`去绘制界面图形。

## gui.event

### SnakeKeyEvent
贪吃蛇键盘监听事件对象，用于监听方向键，改变蛇的走向。

### thread

### SnakeDrawThread
贪吃蛇绘制线程，根据所提供的蛇，食物的信息，将蛇，食物绘制到页面上。

### SnakeRunThread
贪吃蛇运行线程，定时改变蛇的坐标信息，  如果蛇吃到食物，改变食物的位置，添加蛇身长度。
