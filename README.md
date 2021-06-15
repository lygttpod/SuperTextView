# SuperTextView

[![](https://jitpack.io/v/lygttpod/SuperTextView.svg)](https://jitpack.io/#lygttpod/SuperTextView)
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SuperTextView-green.svg?style=true)](https://github.com/lygttpod)
[![](https://img.shields.io/github/stars/lygttpod/SuperTextView.svg)](https://github.com/lygttpod/SuperTextView/stargazers)
[![](https://img.shields.io/github/forks/lygttpod/SuperTextView.svg)](https://github.com/lygttpod/SuperTextView/network)


### 重磅推出SuperTextView2.x版本，属性参数相比1.x有些变化，1.x的用户升级2.x的时候请注意


## 1、功能描述
>  [**SuperTextView**](https://github.com/lygttpod/SuperTextView)是一个功能强大的View，可以满足日常大部分布局样式，开发者可已自行组合属性配置出属于自己风格的样式!可能描述起来没有概念，还是直接看效果图吧！

>  [**SuperButton**](https://github.com/lygttpod/SuperTextView/blob/master/SuperButton_Readme.md)拥有shape文件的大部分属性，从此写shape属性变得非常简单

>  [**CommonTextView**](https://github.com/lygttpod/SuperTextView/blob/master/CommonTextView_Readme.md)只是SuperTextView的逻辑简化，其实功能并不差少哦，有兴趣的可以看看

> 如果觉得对你有用的话，点一下右上的星星赞一下吧!

## 2、 效果 [**Demo下载地址**]( https://fir.im/eft1)

<p align="center">
  <img src="https://github.com/lygttpod/SuperTextView/blob/master/screen/supertextview_demo.png">
</p>

## 3、如何使用
### 3.1、Android Studio导入方法，添加Gradle依赖

   先在项目根目录的 build.gradle 的 repositories 添加:
```
     allprojects {
         repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```
 然后在dependencies添加:
```
        dependencies {
        ...
        compile 'com.github.lygttpod:SuperTextView:VERSION_CODE'
        }
```
> ## 温馨提示：项目中部分代码使用kotlin写的，所以你的项目需要支持kotlin

> ### 注意：VERSION_CODE为[![](https://jitpack.io/v/lygttpod/SuperTextView.svg)](https://jitpack.io/#lygttpod/SuperTextView)后面的数字，即最新的[release](https://github.com/lygttpod/SuperTextView/releases)版本号

### 3.2、项目中如何使用
#### 3.2.1、布局中如何使用（示例中只列出部分属性，开发者可根据具体需求使用其他属性）
```
            <com.allen.library.SuperTextView
                android:layout_width="match_parent"
                android:layout_height="80dp"
                stv:sCenterBottomTextColor="@color/colorAccent"
                stv:sCenterBottomTextString="限额说明>>"
                stv:sCenterTopTextString=" "
                stv:sCenterViewGravity="left_center"
                stv:sLeftBottomTextString="招商银行（8888）"
                stv:sLeftIconRes="@drawable/bank_zhao_shang"
                stv:sLeftTopTextString="银行卡支付"
                stv:sLeftViewGravity="left_center"
                stv:sRightCheckBoxRes="@drawable/circular_check_bg"
                stv:sRightViewType="checkbox" />
        注意：
                1、上下的线可以通过   sDividerLineType 设置  有四种显示方式 none，top，bottom，both
                2、通过设置 sUseRipple=true 开启水波效果
```
#### 3.2.2、代码中如何使用
```
       /**
     * 可以通过链式设置大部分常用的属性值
     */
   superTextView.setLeftTopString("")
                .setLeftString("")
                .setLeftBottomString("")
                .setCenterTopString("")
                .setCenterString("")
                .setCenterBottomString("")
                .setRightTopString("")
                .setRightString("")
                .setRightBottomString("")
                .setLeftIcon(0)
                .setRightIcon(0)
                .setCbChecked(true)
                .setCbBackground(null)
                .setLeftTvDrawableLeft(null)
                .setLeftTvDrawableRight(null)
                .setCenterTvDrawableLeft(null)
                .setCenterTvDrawableRight(null)
                .setRightTvDrawableLeft(null)
                .setRightTvDrawableRight(null);
                
   superTextView.setShapeCornersRadius(20)
                .setShapeCornersTopLeftRadius(20)
                .setShapeCornersBottomLeftRadius(20)
                .setShapeCornersTopRightRadius(20)
                .setShapeCornersBottomRightRadius(20)
                .setShapeStrokeColor(getResources().getColor(R.color.colorPrimary))
                .setShapeStrokeWidth(1)
                .setShapeSrokeDashWidth(1)
                .setShapeStrokeDashGap(5)
                .setShapeSolidColor(getResources().getColor(R.color.white))
                .setShapeSelectorNormalColor(getResources().getColor(R.color.red_btn))
                .setShapeSelectorPressedColor(getResources().getColor(R.color.gray))
                .useShape();//设置完各个参数之后这句调用才生效
```
#### 3.2.3点击事件（可根据需求选择实现单个或者多个点击事件）
```
        /**
         * 根据实际需求对需要的View设置点击事件
         */
        /**
         * 根据实际需求对需要的View设置点击事件
         */
        superTextView.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {
                string = "整个item的点击事件";
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setLeftTopTvClickListener(new SuperTextView.OnLeftTopTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getLeftTopString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setLeftTvClickListener(new SuperTextView.OnLeftTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getLeftString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setLeftBottomTvClickListener(new SuperTextView.OnLeftBottomTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getLeftBottomString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setCenterTopTvClickListener(new SuperTextView.OnCenterTopTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getCenterTopString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setCenterTvClickListener(new SuperTextView.OnCenterTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getCenterString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setCenterBottomTvClickListener(new SuperTextView.OnCenterBottomTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getCenterBottomString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setRightTopTvClickListener(new SuperTextView.OnRightTopTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getRightTopString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setRightTvClickListener(new SuperTextView.OnRightTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getRightString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setRightBottomTvClickListener(new SuperTextView.OnRightBottomTvClickListener() {
            @Override
            public void onClickListener() {
                string = superTextView.getRightBottomString();
                Toast.makeText(ClickActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        }).setLeftImageViewClickListener(new SuperTextView.OnLeftImageViewClickListener() {
            @Override
            public void onClickListener(ImageView imageView) {
                Toast.makeText(ClickActivity.this, "左边图片", Toast.LENGTH_SHORT).show();
            }
        }).setRightImageViewClickListener(new SuperTextView.OnRightImageViewClickListener() {
            @Override
            public void onClickListener(ImageView imageView) {
                Toast.makeText(ClickActivity.this, "右边图片", Toast.LENGTH_SHORT).show();
            }
        });

        superTextView_cb.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {
                superTextView.setCbChecked(!superTextView.getCbisChecked());
            }
        }).setCheckBoxCheckedChangeListener(new SuperTextView.OnCheckBoxCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ClickActivity.this, "" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        superTextView_switch.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {
                superTextView.setSwitchIsChecked(!superTextView.getSwitchIsChecked());
            }
        }).setSwitchCheckedChangeListener(new SuperTextView.OnSwitchCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ClickActivity.this, "" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
```
#### 3.2.4使用第三方库(Picasso或者Glide)加载网络图片
```
        String url1 = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG";
        String url2 = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=219781665,3032880226&fm=80&w=179&h=119&img.JPEG";
        String url3 = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3860616424,1789830124&fm=80&w=179&h=119&img.PNG";
        
        Picasso.with(this)
                .load(url1)
                .placeholder(R.drawable.head_default)
                .into(superTextView.getLeftIconIV());
        Glide.with(this)
                .load(url2)
                .placeholder(R.drawable.head_default)
                .fitCenter()
                .into(superTextView2.getRightIconIV());

        Glide.with(this)
                .load(url3)
                .placeholder(R.drawable.head_default)
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        superTextView3.setRightTvDrawableRight(resource);
                    }
                });
```

#### 3.2.5、属性说明(以下属性全部可以通过xml文件配置和代码进行设置)

属性名 | 字段 | 描述 | 默认值
----|------|----| ----
sLeftTextString | string  | 左边文字字符串
sLeftTopTextString | string  | 左上文字字符串
sLeftBottomTextString | string  | 左下文字字符串
sCenterTextString | string  | 中间文字字符串
sCenterTopTextString | string  | 中上文字字符串
sCenterBottomTextString | string  | 中下文字字符串
sRightTextString | string  | 右边文字字符串
sRightTopTextString | string  | 右上文字字符串
sRightBottomTextString | string  | 右下文字字符串
sLeftTextColor | color  | 左边文字颜色 | 默认0xFF373737
sLeftTopTextColor | color  | 左上文字颜色 | 默认0xFF373737
sLeftBottomTextColor | color  | 左下文字颜色 | 默认0xFF373737
sCenterTextColor | color  | 中间文字颜色 | 默认0xFF373737
sCenterTopTextColor | color  | 中上文字颜色 | 默认0xFF373737
sCenterBottomTextColor | color  | 中下文字颜色 | 默认0xFF373737
sRightTextColor | color  | 左边文字颜色 | 默认0xFF373737
sRightTopTextColor | color  | 右上文字颜色 | 默认0xFF373737
sRightBottomTextColor | color  | 右下文字颜色 | 默认0xFF373737
sLeftTextSize | dimension  | 左边字体大小 | 默认15sp
sLeftTopTextSize | dimension  | 左上字体大小 | 默认15sp
sLeftBottomTextSize | dimension  | 左下字体大小 | 默认15sp
sCenterTextSize | dimension  | 中间字体大小 | 默认15sp
sCenterTopTextSize | dimension  | 中上字体大小 | 默认15sp
sCenterBottomTextSize | dimension  | 中下字体大小 | 默认15sp
sRightTextSize | dimension  | 右边字体大小 | 默认15sp
sRightTopTextSize | dimension  | 右上字体大小 | 默认15sp
sRightBottomTextSize | dimension  | 右下字体大小 | 默认15sp
sLeftLines | integer  | 左边文字显示行数 | 默认不设置
sLeftTopLines | integer  | 左上文字显示行数 | 默认不设置
sLeftBottomLines | integer  | 左下文字显示行数 | 默认不设置
sCenterLines | integer  | 中间文字显示行数 | 默认不设置
sCenterTopLines | integer  | 中上文字显示行数 | 默认不设置
sCenterBottomLines | integer  | 中下文字显示行数 | 默认不设置
sRightLines | integer  | 右边文字显示行数 | 默认不设置
sRightTopLines | integer  | 右上文字显示行数 | 默认不设置
sRightBottomLines | integer  | 右下文字显示行数 | 默认不设置
sLeftMaxEms | integer  | 左边文字显示个数 | 默认不设置
sLeftTopMaxEms | integer  | 左上文字显示个数 | 默认不设置
sLeftBottomMaxEms | integer  | 左下文字显示个数 | 默认不设置
sCenterMaxEms | integer  | 中间文字显示个数 | 默认不设置
sCenterTopMaxEms | integer  | 中上文字显示个数 | 默认不设置
sCenterBottomMaxEms | integer  | 中下文字显示个数 | 默认不设置
sRightMaxEms | integer  | 右边文字显示个数 | 默认不设置
sRightTopMaxEms | integer  | 右上文字显示个数 | 默认不设置
sRightBottomMaxEms | integer  | 右下文字显示个数 | 默认不设置
sLeftViewGravity | enum  | 左边文字对齐方式<br>left_center(左对齐)<br>center(居中)<br>right_center(右对齐) | 默认center
sCenterViewGravity | enum  | 中间文字对齐方式<br>left_center(左对齐)<br>center(居中)<br>right_center(右对齐) | 默认center
sRightViewGravity | enum  | 右边文字对齐方式<br>left_center(左对齐)<br>center(居中)<br>right_center(右对齐) | 默认center
sLeftTvDrawableLeft | reference  | 左边TextView左侧的drawable
sLeftTvDrawableRight | reference  | 左边TextView右侧的drawable
sCenterTvDrawableLeft | reference  | 中间TextView左侧的drawable
sCenterTvDrawableRight | reference  | 中间TextView右侧的drawable
sRightTvDrawableLeft | reference  | 右边TextView左侧的drawable
sRightTvDrawableRight | reference  | 右边TextView右侧的drawable
sLeftTvDrawableWidth | dimension  | 左边TextView的drawable的宽度
sLeftTvDrawableHeight | dimension  | 左边TextView的drawable的高度
sCenterTvDrawableWidth | dimension  | 中间TextView的drawable的宽度
sCenterTvDrawableHeight | dimension  | 中间TextView的drawable的高度
sRightTvDrawableWidth | dimension  | 右边TextView的drawable的宽度
sRightTvDrawableHeight | dimension  | 右边TextView的drawable的高度
sTextViewDrawablePadding | dimension  | TextView的drawable对应的Padding | 默认10dp
sLeftViewWidth | dimension  | 左边textView的宽度  为了中间文字左对齐的时候使用
sTopDividerLineMarginLR | dimension  | 上边分割线的MarginLeft和MarginRight | 默认0dp
sTopDividerLineMarginLeft | dimension  | 上边分割线的MarginLeft | 默认0dp
sTopDividerLineMarginRight | dimension  | 上边分割线的MarginRight | 默认0dp
sBottomDividerLineMarginLR | dimension  | 下边分割线的MarginLeft和MarginRigh | 默认0dp
sBottomDividerLineMarginLeft | dimension  | 下边分割线的MarginLeft | 默认0dp
sBottomDividerLineMarginRight | dimension  | 下边分割线的MarginRight | 默认0dp
sDividerLineColor | color  | 分割线的颜色 | 默认0xFFE8E8E8
sDividerLineHeight | dimension  | 分割线的高度 | 默认0.5dp
sDividerLineType | enum  | 分割线显示方式 <br>none(不显示分割线)<br>top(显示上边的分割线)<br>bottom(显示下边的分割线)<br>both(显示上下两条分割线) | 默认bottom
sLeftViewMarginLeft | dimension  | 左边view的MarginLeft | 默认10dp
sLeftViewMarginRight | dimension  | 左边view的MarginRight | 默认10dp
sCenterViewMarginLeft | dimension  | 中间view的MarginLeft | 默认10dp
sCenterViewMarginRight | dimension  | 中间view的MarginRight | 默认10dp
sRightViewMarginLeft | dimension  | 右边view的MarginLeft | 默认10dp
sRightViewMarginRight | dimension  | 右边view的MarginRight | 默认10dp
sLeftTextIsBold(移除) | boolean  | 左边文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sLeftTopTextIsBold(移除) | boolean  | 左上文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sLeftBottomTextIsBold(移除) | boolean  | 左下文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sCenterTextIsBold(移除) | boolean  | 中间文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sCenterTopTextIsBold(移除) | boolean  | 中上文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sCenterBottomTextIsBold(移除) | boolean  | 中下文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sRightTextIsBold(移除) | boolean  | 右边文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sRightTopTextIsBold(移除) | boolean  | 右上文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sRightBottomTextIsBold(移除) | boolean  | 右下文字是否加粗 | 默认false（暂时去除此属性改为代码动态配置）
sLeftIconRes | reference  | 左边图片资源  可以用来显示网络图片或者本地
sRightIconRes | reference  | 右边图片资源  可以用来显示网络图片或者本地
sLeftIconWidth | dimension  | 左边图片资源的宽度  用于固定图片大小的时候使用
sLeftIconHeight | dimension  | 左边图片资源的高度  用于固定图片大小的时候使用
sRightIconWidth | dimension  | 右边图片资源的宽度  用于固定图片大小的时候使用
sRightIconHeight | dimension  | 右边图片资源的高度  用于固定图片大小的时候使用
sLeftIconMarginLeft | dimension  | 左边图片资源的MarginLeft | 默认10dp
sRightIconMarginRight | dimension  | 右边图片资源的MarginLeft | 默认10dp
sCenterSpaceHeight | dimension  | 上中下三行文字的间距 | 默认5dp
sRightCheckBoxRes | reference  | 右边CheckBox的资源
sRightCheckBoxMarginRight | dimension  | 右边CheckBox的MarginRight | 默认10dp
sIsChecked | boolean  | 右边CheckBox是否选中 | 默认 false
sUseRipple | boolean  | 是否开启点击出现水波效果 | 默认 true
sBackgroundDrawableRes | reference  | SuperTextView的背景资源
sRightViewType | enum  | 右边显示的特殊View<br>checkbox<br>switchBtn | 默认都不显示
sRightSwitchMarginRight | dimension  | 右边SwitchBtn的MarginRight | 默认10dp
sSwitchIsChecked | boolean  | 右边SwitchBtn是否选中 | 默认 false
sTextOff | string  | TextOff | 默认""
sTextOn | string  | TextOn | 默认""
sSwitchMinWidth | dimension  | SwitchMinWidth | 系统默认
sSwitchPadding | dimension  | SwitchPadding | 系统默认
sThumbTextPadding | dimension  | ThumbTextPadding | 系统默认
sThumbResource | reference  | 右边SwitchBtn自定义选中资源 | 系统默认
sTrackResource | reference  | 右边SwitchBtn自定义未选中资源 | 系统默认
sUseShape | boolean  | 是否使用shape设置圆角及触摸反馈<br>设为true之后才能使用一下属性 | 默认false
sShapeSolidColor | color  | 填充色 | 默认false
sShapeSelectorPressedColor | color  | 按下时候的颜色 | 默认0xffffffff
sShapeSelectorNormalColor | color  | 正常显示的颜色 | 默认0xffffffff
sShapeCornersRadius | dimension  | 四个角的圆角半径 | 默认0dp
sShapeCornersTopLeftRadius | dimension  | 左上角的圆角半径 | 默认0dp
sShapeCornersTopRightRadius | dimension  | 右上角的圆角半径 | 默认0dp
sShapeCornersBottomLeftRadius | dimension  | 左下角的圆角半径 | 默认0dp
sShapeCornersBottomRightRadius | dimension  | 右下角的圆角半径 | 默认0dp
sShapeStrokeWidth | dimension  | 边框宽度 | 默认0dp
sShapeStrokeDashWidth | dimension  | 虚线宽度 | 默认0dp
sShapeStrokeDashGap | dimension  | 虚线间隙宽度 | 默认0dp
sShapeStrokeColor | color  | 边框颜色 | 默认0dp
sLeftTextBackground | reference  | 左边textView的背景
sCenterTextBackground | reference  | 中间textView的背景
sRightTextBackground | reference  | 右边textView的背景
sLeftTextGravity | enum  | 左边TextView内文字对齐方式<br>left(左对齐)<br>center(居中)<br>right(右对齐) | 默认left
sCenterTextGravity | enum  | 中间TextView内文字对齐方式<br>left(左对齐)<br>center(居中)<br>right(右对齐) | 默认left
sRightTextGravity | enum  | 右边TextView内文字对齐方式<br>left(左对齐)<br>center(居中)<br>right(右对齐) | 默认left
sLeftIconShowCircle | boolean  | 左边ImageView是否显示为圆形 | 默认false
sRightIconShowCircle | boolean  | 右边ImageView是否显示为圆形 | 默认false

> 黑格尔曾说过：存在即合理。SuperTextView的出现应该就是某种需求下的产物。


# 4、[更新日志](https://github.com/lygttpod/SuperTextView/releases)

# 意见反馈

<a target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=33dacdd367ca0b5a9ba96a196a6658666b442b3ec528850e377d50f3d607f26b"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="STV&amp;RxHttp交流群" title="STV&amp;RxHttp交流群"></a>

或者手动加QQ群：688433795

如果遇到问题或者好的建议，请反馈到：[issue](https://github.com/lygttpod/RxHttpUtils/issues)、[lygttpod@163.com](mailto:lygttpod@163.com) 或者[lygttpod@gmail.com](mailto:lygttpod@gmail.com)

如果觉得对你有用的话，点一下右上的星星赞一下吧!

## 代码是最好的老师，更多详细用法请查看 [demo](https://github.com/lygttpod/SuperTextView/tree/master/app):feet:


# License
```
         Copyright 2016 Allen

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

          http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.

```
