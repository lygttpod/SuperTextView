# SuperButton

> ## SuperButton可以实现shape大部分属性设置，从此实现边框之类的UI宝宝再也不用写很多shape文件了，想怎么玩就怎么玩！

# 效果图
<div  align="center">    
<img src="http://osnoex6vf.bkt.clouddn.com/SuperButton.png" width = "480" alt="效果图" align=center /></div>
</div>


### 布局中如何使用(只是列出部分属性)
```
           <com.allen.library.SuperButton
                android:layout_width="70dp"
                android:layout_height="70dp"
                android:layout_margin="5dp"
                android:text="圆角边框"
                stv:sCornersRadius="5dp"
                stv:sStrokeColor="@color/colorAccent"
                stv:sStrokeWidth="0.2dp" />
```

### 属性说明(以下属性全部可以通过xml文件配置)

```
<?xml version="1.0" encoding="utf-8"?>
<shape
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape=["rectangle" | "oval" | "line" | "ring"] >
    <corners
        android:radius="integer"
        android:topLeftRadius="integer"
        android:topRightRadius="integer"
        android:bottomLeftRadius="integer"
        android:bottomRightRadius="integer" />
    <gradient
        android:angle="integer"
        android:centerX="integer"
        android:centerY="integer"
        android:centerColor="integer"
        android:endColor="color"
        android:gradientRadius="integer"
        android:startColor="color"
        android:type=["linear" | "radial" | "sweep"]
        android:useLevel=["true" | "false"] />
    <size
        android:width="integer"
        android:height="integer" />
    <solid
        android:color="color" />
    <stroke
        android:width="integer"
        android:color="color"
        android:dashWidth="integer"
        android:dashGap="integer" />
</shape>
```

> ### 以上shape对应下边的SuperButton属性

属性名 | 字段 | 描述 | 默认值
----|------|----| ----
sGravity | enum  | 设置文字对其方式<br>center<br>left<br>right<br>top<br>bottom | 默认center
sShapeType | enum  | 设置Shape的类型<br>rectangle<br>oval<br>right<br>line<br>ring | 默认rectangle
sSolidColor | color  | 填充颜色 | 默认
sSelectorPressedColor | color  | 按下时颜色 | 默认0x20000000
sSelectorDisableColor | color  | 不可点击颜色 | 默认0x20000000
sSelectorNormalColor | color  | 正常显示的颜色 | 默认0x20000000
sCornersRadius | dimension  | shape的四个圆角半径 | 默认0dp
sCornersTopLeftRadius | dimension  | shape的左上圆角半径 | 默认0dp
sCornersTopRightRadius | dimension  | shape的右上圆角半径 | 默认0dp
sCornersBottomLeftRadius | dimension  | shape的左下圆角半径 | 默认0dp
sCornersBottomRightRadius | dimension  | shape的右下圆角半径 | 默认0dp
sStrokeDashWidth | dimension  | shape的虚线宽度 | 默认0dp
sStrokeDashGap | dimension  | shape的虚线间隙 | 默认0dp
sStrokeWidth | dimension  | shape的边框宽度 | 默认0dp
sStrokeColor | color  | shape的边框颜色 | 默认0x20000000
sSizeWidth | dimension  | shape的SizeWidth | 默认0dp
sSizeHeight | dimension  | shape的SizeHeight | 默认0dp
sGradientOrientation | enum  | 设置渐变类型<br>TOP_BOTTOM<br>TR_BL<br>RIGHT_LEFT<br>BR_TL<br>BOTTOM_TOP<br>BL_TR<br>LEFT_RIGHT<br>TL_BR | 默认rectangle
sGradientType | enum  | 设置渐变类型<br>linear<br>radial<br>sweep | 默认rectangle
sGradientCenterX | dimension  | shape的CenterX | 默认0dp
sGradientCenterY | dimension  | shape的CenterY | 默认0dp
sGradientGradientRadius | dimension  | shape的GradientRadius | 默认0dp
sGradientStartColor | color  | shape的StartColor |
sGradientCenterColor | color  | shape的CenterColor |
sGradientEndColor | color  | shape的EndColor |
sGradientUseLevel | boolean  | shape的UseLevel | 默认flase
sUseSelector | boolean  | 是否使用selector | 默认false

