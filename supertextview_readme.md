## 文章目录
* 1、功能描述
* 2、效果图
* 3、如何使用
  - 3.1、 Android Studio导入方法
  - 3.2、 项目中如何使用
    - 3.2.1、布局中使用
    - 3.2.2、在代码中使用
    - 3.2.3、属性介绍
* 4、 实现原理
  - 4.1、需求分析
  - 4.2、代码封装
  - 4.3、总结

##1、功能描述
> [**SuperTextView**](https://github.com/lygttpod/SuperTextView)是一个功能强大的View，可以满足日常大部分布局样式，开发者可已自行组合属性配置出属于自己风格的样式!可能描述起来没有概念，还是直接看效果图吧！

## 2、 效果图

![Paste_Image.png](http://upload-images.jianshu.io/upload_images/2057501-87c62fbe413a2dda.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/480)

## 3、如何使用
> Android Studio导入方法，添加Gradle依赖

   先在项目根目录的 build.gradle 的 repositories 添加:

     allprojects {
         repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
    
 然后在dependencies添加:
 
        dependencies {
        ...
        compile 'com.github.lygttpod:SuperTextView:1.1.2'
        }
### 3.2、项目中如何使用
##### 3.2.1、布局中如何使用（示例中只列出部分属性，开发者可根据具体需求使用其他属性）
        <com.allen.supertextviewlibrary.SuperTextView
                android:id="@+id/super_tv"
                android:layout_width="match_parent"
                android:layout_height="80dp"
                stv:sLeftBottomTextColor2="@color/colorAccent"
                stv:sLeftBottomTextString="招商银行（8888）"
                stv:sLeftBottomTextString2="限额说明>>"
                stv:sLeftIconRes="@drawable/bank_zhao_shang"
                stv:sLeftTopTextString="银行卡支付"
                stv:sRightCheckBoxRes="@drawable/circular_check_bg"
                stv:sRightCheckBoxShow="true"
                stv:sLineShow="bottom"
                 />
        注意：
                1、上下的线可以通过   sLineShow 设置  有四种显示方式 none，top，bottom，both
                2、通过设置 sUseRipple=true 开启水波效果
##### 3.2.2、代码中如何使用
       /**
     * 可以通过链式设置大部分常用的属性值
     */
        superTextView.setLeftIcon(drawable)
                .setLeftString("")
                .setLeftTVColor(0)
                .setLeftTopString("")
                .setLeftTopTVColor(0)
                .setLeftBottomString("")
                .setLeftBottomTVColor(0)
                .setLeftBottomString2("")
                .setLeftBottomTVColor2(0)
                .setRightString("")
                .setRightTVColor(0)
                .setCbChecked(true)
                .setCbBackground(drawable)
                .setRightIcon(drawable)
                .setRightString("")
                .setRightTVColor(0)
                .setLeftString("")
          

###### 点击事件（可根据需求选择实现单个或者多个点击事件，需要配合xml添加是否允许点击的属性，详情见属性参数的意义）
        superTextView.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
                    @Override
                    public void onSuperTextViewClick() {
                        super.onSuperTextViewClick();
                        //do something
                    }

                    @Override
                    public void onLeftTopClick() {
                        super.onLeftTopClick();
                        //do something
                    }

                    @Override
                    public void onLeftBottomClick() {
                        super.onLeftBottomClick();
                        //do something
                    }

                    @Override
                    public void onLeftBottomClick2() {
                        super.onLeftBottomClick2();
                        //do something
                    }
                });

                注意：点击事件需要配合属性值使用
                sLeftTopViewIsClickable= true
                sLeftBottomViewIsClickable= true
                sLeftBottomView2IsClickable= true

##### 3.2.3、属性说明(以下属性全部可以通过xml文件配置和代码进行设置)

属性名 | 字段 | 描述
----|------|----
sLeftIconRes | reference  | 左边图标资源
sRightIconRes | reference  | 右边图标资源
sLeftIconWidth | dimension  | 左边图标的宽度
sLeftIconHeight | dimension  | 左边图标的高度
sRightIconWidth | dimension  | 右边图标的高度
sRightIconHeight | dimension  | 右边图标的高度
sRightCheckBoxRes | reference  | 右边CheckBox图标资源
sLeftTextString | string  | 左边文字字符串
sLeftTopTextString | string  | 左上文字字符串
sLeftBottomTextString | string  | 左下文字字符串
sLeftBottomTextString2 | string  | 左下第二个文字字符串
sCenterTextString | string  | 中间文字字符串
sRightTextString | string  | 右边文字字符串
sTopLineMargin| dimension | 顶部横线的Margin
sTopLineMarginLeft | dimension | 顶部横线的MarginLeft
sTopLineMarginRight | dimension | 顶部横线的MarginRight
sBottomLineMargin | dimension | 底部横线的Margin
sBottomLineMarginLeft | dimension | 底部横线的MarginLeft
sBottomLineMarginRight | dimension | 底部横线的MarginRight
sBothLineMargin | dimension | 上下两条横线的Margin
sBothLineMarginLeft | dimension |  上下两条横线的MarginLeft
sBothLineMarginRight | dimension | 上下两条横线的MarginRight
sCenterSpaceHeight | dimension | top和bottom文字间的高度
sLeftIconMarginLeft | dimension | 左边图标MarginLeft
sLeftTextMarginLeft | dimension | 左边文字MarginLeft
sLeftTopTextMarginLeft | dimension | 左上文字MarginLeft
sLeftBottomTextMarginLeft | dimension | 左下文字MarginLeft
sLeftBottomTextMarginLeft2 | dimension | 左下第二个文字MarginLeft
sRightTextStringRightIconRes | reference | 右边文字的右边图标资源
sRightTextStringRightIconResPadding | dimension | 右边文字的右边图标的Padding
sRightIconMarginRight |dimension | 右边icon的MarginRight
sRightTextMarginRight | dimension| 右边文字的MarginRight
sRightCheckBoxMarginRight | dimension| 右边CheckBox的MarginRight
sRightCheckBoxShow | boolean | 右边的CheckBox是否显示
sIsChecked | boolean | 是否选中
sUseRipple | boolean | 是否使用点击出现波纹效果
 sLeftTextSize | dimension |  左边文字的字体大小
 sLeftTopTextSize | dimension | 左上文字的字体大小
 sLeftBottomTextSize | dimension | 左下文字的字体大小   
 sLeftBottomTextSize2 | dimension | 左下第二个文字的字体大小   
 sRightTextSize | dimension |  右边文字的字体大小  
 sCenterTextSize | dimension |   中间文字的字体大小 
 sBackgroundColor | color | 背景颜色
 sLeftTextColor | color | 左边文字颜色
 sLeftTopTextColor | color | 左上文字颜色
 sLeftBottomTextColor | color | 左下文字颜色
 sLeftBottomTextColor2 | color | 左下第二个文字颜色
 sRightTextColor | color | 右边文字颜色
 sCenterTextColor | color | 中间文字颜色
 sIsSingLines | boolean | 是否单行显示
 sMaxLines | integer | 允许的最大行数
 sMaxEms | integer | 允许的最多字数
 sLineShow | enum | 分割线的显示方式none、top、bottom、both
 sBothLineWidth | dimension | 两条分割线的宽度
 sTopLineWidth | dimension | 上边分割线的宽度
 sBottomLineWidth | dimension | 下边分割线的宽度
 sLineColor | color | 分割线的颜色
 sLeftTopViewIsClickable | boolean | 左上view是否可点击
 sLeftBottomViewIsClickable | boolean | 左下view是否可点击
 sLeftBottomView2IsClickable | boolean | 左下第二个view是否可点击
 sBackgroundDrawableRes | reference | 背景资源
   
### 4、实现原理
##### 4.1、需求分析
> 黑格尔曾说过：存在即合理。SuperTextView的出现应该就是某种需求下的产物。

在开发项目的过程中你会发现有很多页面的布局都是类似的，就比如说常见的设置页面，基本上都是图标+文字+图标的格式，而且出现的频率都很高，如果不做处理势必会写很多无用的代码降低开发效率，正因为如此我们为什么不把这一类view统一封装起来呐（其实就是程序猿的懒惰，哈哈），有了这个想法就开始调研市场上主流应用的显示样式，经过调研总结出一套显示方案涵盖了市面上90%以上的布局样式，目的是在以后的使用中快速高效的开发。

##### 4.2、代码封装
> 在介绍封装之前先说一句题外话，其实任何功能的封装并不难，还是看你愿不愿意花时间去做，及时是简单的功能真正实现起来的时候还是会或多或少的遇到一些问题，发现问题解决问题的过程其实就是进步的过程。好了，废话不多说，下边看代码。

首先SuperTextView 是继承自 RelativeLayout实现，里边所有布局的添加都是通过Java代码实现的，事先定义好需要的参数名及类型

下边只列出部分参数
```
    private int backgroundColor;//背景颜色
    private int leftTVColor;//左边文字颜色
    private int leftTopTVColor;//左上文字颜色
    private int leftBottomTVColor;//左下文字颜色
    private int leftBottomTVColor2;//左下第二个文字颜色
    private int rightTVColor;//右边文字颜色
    private int centerTVColor;//中间文字颜色

    private boolean isSingLines = true;//是否单行显示   默认单行
    private int maxLines = 1;//最多几行    默认显示一行
    private int maxEms = 10;//最多几个字    默认显示10个汉子

    private static final int NONE = 0;
    private static final int TOP = 1;
    private static final int BOTTOM = 2;
    private static final int BOTH = 3;
    private static final int DEFAULT = BOTTOM;

```
然后就是在构造方法里边去实现各个方法
```
 public SuperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        getAttr(attrs);
        initLayout();
    }
```
我们知道系统控件可以从XML中拿到定义好的属性值，那么我们其实也是可以的，首先在attr中定义好相关属性名及字段类型然后通过AttributeSet去拿到相关属性值在进行设置
```
private void getAttr(AttributeSet attrs) {
        //获取我们在attr中定义的SuperTextView相关属性
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.SuperTextView);

        //下边展示的各个类型参数的获取方法，drawable、string、boolean、int、px
        leftIconRes = typedArray.getDrawable(R.styleable.SuperTextView_sLeftIconRes);
        leftTextString = typedArray.getString(R.styleable.SuperTextView_sLeftTextString);
        showCheckBox = typedArray.getBoolean(R.styleable.SuperTextView_sRightCheckBoxShow, false);
        lineType = typedArray.getInt(R.styleable.SuperTextView_sLineShow, DEFAULT);
        topLineMargin = typedArray.getDimensionPixelSize(R.styleable.SuperTextView_sTopLineMargin, defaultLinePadding);

        //获取完之后记得recycle()释放掉资源
        typedArray.recycle();
      }
```
接下来就拿一个view为例进行说明如何动态添加view及设置相关属性
```
/**
     * 初始化左边文字
     */
    private void initLeftText() {
        leftTV = new TextView(mContext);
        leftTextParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftTextParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        leftTextParams.addRule(RelativeLayout.RIGHT_OF, R.id.sLeftIconId);
        setMargin(leftTextParams, leftTVMarginLeft, 0, dip2px(mContext, 10), 0);
        leftTV.setId(R.id.sLeftTextId);
        leftTV.setLayoutParams(leftTextParams);
        leftTV.setText(leftTextString);
        //设置Params的方法抽离出来便于以后统一调用
        setTextViewParams(leftTV, isSingLines, maxLines, maxEms);
        //设置字体颜色的方法抽离出来便于以后统一调用
        setTextColor(leftTV, leftTVColor);
        //设置字体大小的方法抽离出来便于以后统一调用
        setTextSize(leftTV, leftTVSize);
        //调用addView方法把我们动态创建的view添加到布局中
        addView(leftTV);
    }
```
初始化完view之后就是要暴露一些方法供外部人员使用了（部分代码示例）
在这里我们返回SuperTextView对象是为了实现链式调用
```
    /**
     * 获取checkbox状态
     *
     * @return 返回选择框当前选中状态
     */
    public boolean getCbisChecked() {
        boolean isChecked = false;
        if (rightCheckBox != null) {
            isChecked = rightCheckBox.isChecked();
        }
        return isChecked;
    }

    /**
     * 设置左边文字的颜色
     *
     * @param textColor 文字颜色值
     * @return 返回对象
     */
    public SuperTextView setLeftTVColor(int textColor) {
        leftTVColor = textColor;
        if (leftTV == null) {
            initLeftText();
        } else {
            leftTV.setTextColor(textColor);
        }
        return this;
    }
```
最后就是一些回调方法的使用，以点击事件为例
```
/**
     * 点击事件接口
     * 这里没有使用interface是因为有些方法我们不是一定要实现的
     * 用到哪个方法再去重写方法就可以了
     */
    public static class OnSuperTextViewClickListener {
        public void onSuperTextViewClick() {
        }

        public void onLeftTopClick() {
        }

        public void onLeftBottomClick() {
        }

        public void onLeftBottomClick2() {
        }

    }
```
相关的set方法拿到OnSuperTextViewClickListener对象
```
   public SuperTextView setOnSuperTextViewClickListener(OnSuperTextViewClickListener listener) {
        onSuperTextViewClickListener = listener;
        return this;
    }
```

初始化view的时候在各个view的点击事件中添加相应的回调方法就行了
```
       if (mLeftTopViewIsClickable) {
            leftTopTV.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onSuperTextViewClickListener != null) {
                        onSuperTextViewClickListener.onLeftTopClick();
                    }
                }
            });
        }
```
***
> 以上只是源码中的部分方法拿出来供分析使用，看了之后是不是感觉实现其实很简单，赶紧自己着手实现一个吧！

##### 4.3、总结
想必看到这里的小伙伴已经对这个库的源码实现方式了解了，这里只是把实现的流程给大家介绍了一下，我又对这个库做了一个简化版的处理，有兴趣的小伙伴可以去读读源码哦，发现哪里写的不妥的地方还请指正。
# 意见反馈

如果遇到问题或者好的建议，请反馈到我的邮箱：[lygttpod@163.com](mailto:lygttpod@163.com) 或者[lygttpod@gmail.com](mailto:lygttpod@gmail.com)

如果觉得对你有用的话，点一下右上的星星赞一下吧!

# [**传送门**](https://github.com/lygttpod/SuperTextView)

