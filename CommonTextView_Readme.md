# CommonTextView

是SuperTextView的精简版，但同样是一个功能强大的TextView，可以满足日常大部分布局方式，开发者可已自行组合属性配置出属于自己风格的样式!如果觉得对你有用的话，点一下右上的星星赞一下吧!

# 效果图
<div  align="center">    
<img src="http://osnoex6vf.bkt.clouddn.com/commontextview.jpg" width = "360" height = "640" alt="效果图" align=center /></div>
</div>

# 基本使用

### 1.添加Gradle依赖 
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

### 2.布局中如何使用（列出所有属性使用方法）

        <com.allen.library.CommonTextView
                android:layout_width="match_parent"
                android:layout_height="50dp"
                //左边view的属性
                ctv:cLeftIconDrawablePadding="10dp"
                ctv:cLeftIconResForDrawableLeft="@drawable/uu"
                ctv:cLeftTextColor="@color/colorAccent"
                
                ctv:cLeftTextSize="15sp"
                ctv:cLeftTextString="左边文字"
                ctv:cLeftViewPaddingLeft="10dp"
                ctv:cLeftViewPaddingRight="10dp"
                
                //中间view的属性
                ctv:cCenterIconDrawablePadding="10dp"
                ctv:cCenterIconResForDrawableLeft="@drawable/uu"
                ctv:cCenterTextColor="@color/colorAccent"
                ctv:cCenterTextSize="15sp"
                ctv:cCenterTextString="中间文字"
                ctv:cCenterViewPaddingLeft="10dp"
                ctv:cCenterViewPaddingRight="10dp"

                //右边view的属性
                ctv:cRightIconDrawablePadding="10dp"
                ctv:cRightIconResForDrawableLeft="@drawable/uu"
                ctv:cRightTextColor="@color/colorAccent"
                ctv:cRightTextSize="15sp"
                ctv:cRightTextString="右边文字"
                ctv:cRightViewPaddingLeft="10dp"
                ctv:cRightViewPaddingRight="10dp"

                //分割线的属性
                ctv:cDividerLineColor="@color/colorPrimary"
                ctv:cDividerLineHeight="1dp"
                ctv:cBothDividerLineMarginLR="10dp"
                ctv:cShowDividerLineType="bottom"

                //背景颜色
                ctv:cBackgroundColor="@color/colorAccent"

                //是否开启点击出现波纹效果---------默认关闭
                ctv:cUseRipple="true"

                //设置textView显示几行字符串------默认一行
                ctv:cSetLines="1"

                //设置一行显示最大字符数-----------默认10个
                ctv:cSetMaxEms="10"

                //设置是否单行显示-----------------默认单行
                ctv:cSetSingleLine="true" />

                //上下两行文字的间距
                ctv:cLeftTextViewLineSpacingExtra="8dp"
                ctv:cCenterTextViewLineSpacingExtra="8dp"
                ctv:cRightTextViewLineSpacingExtra="8dp"


                //使用上下两行显示的时候设置对齐方式,选择left_center|center|right_center中的一种方式（配合XXXTextViewLineSpacingExtra使用）

                ctv:cLeftTextViewGravity="left_center|center|right_center"
                ctv:cCenterTextViewGravity="left_center|center|right_center"
                ctv:cRightTextViewGravity="left_center|center|right_center"
                
                
                //点击事件配合onClick事件使用
                ctv:cLeftViewIsClickable="true"
                ctv:cCenterViewIsClickable="true"
                ctv:cRightViewIsClickable="true"
                
                cBackgroundDrawableRes="@drawable/selector_red"
                
                ctv:cCenterViewMarginLeft="200dp"
                ctv:cIsCenterAlignLeft="true"
                
                
                                
                                


        注意：
                1、上下的线可以通过   cShowDividerLineType 设置  有四种显示方式 none，top，bottom，both
                2、以上是全部的属性，用户可以根据需求选取需要使用的属性即可，不必全选
                3、图片的可以实现上下左右四个方位显示(XXX代表left,center,right)
                                                   XXXIconResForDrawableLeft
                                                   XXXIconResForDrawableTop
                                                   XXXIconResForDrawableRight
                                                   XXXIconResForDrawableBottom
### 3.代码中如何使用
       /**
     * 可以通过链式设置大部分常用的属性值
     */

     1、set方法

        commonTextView
                        .setLeftTextString("")
                        .setLeftTextColor(0)
                        .setLeftTextSize(0)
                        .setLeftDrawableLeft(drawable)
                        .setLeftDrawableTop(drawable)
                        .setLeftDrawableRight(drawable)
                        .setLeftDrawableBottom(drawable)

                        .setCenterTextString("")
                        .setCenterTextColor(0)
                        .setCenterTextSize(0)
                        .setCenterDrawableLeft(drawable)
                        .setCenterDrawableTop(drawable)
                        .setCenterDrawableRight(drawable)
                        .setCenterDrawableBottom(drawable)

                        .setRightTextString("")
                        .setRightTextColor(0)
                        .setRightTextSize(0)
                        .setRightDrawableLeft(drawable)
                        .setRightDrawableTop(drawable)
                        .setRightDrawableRight(drawable)
                        .setRightDrawableBottom(drawable)

                        .setOnCommonTextViewClickListener(new CommonTextView.OnCommonTextViewClickListener(){
                            @Override
                            public void onCommonTextViewClick() {
                                super.onCommonTextViewClick();
                                //do click
                            }

                            @Override
                            public void onLeftViewClick() {
                                super.onLeftViewClick();
                                //do click
                            }

                            @Override
                            public void onCenterViewClick() {
                                super.onCenterViewClick();
                                //do click
                            }

                            @Override
                            public void onRightViewClick() {
                                super.onRightViewClick();
                                //do click
                            }
                        });

     2、get方法
               commonTextView.getLeftTextString();
               commonTextView.getCenterTextString();
               commonTextView.getRightTextString();

     3、使用图片缓存框架加载在网络图片

                Glide
                .with(this)
                .load("url")
                .placeholder(R.drawable.head_default)
                .into(new SimpleTarget<GlideDrawable>() {
                                   @Override
                                   public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                       commonTextView.setLeftDrawableLeft(resource);
                                   }
                               });
          
### 4.点击事件（可根据需求选择实现某个点击事件）

          点击事件配合两种方法使用才有效果
          
          ①、xml配置使用
                ctv:cLeftViewIsClickable="true"
                ctv:cCenterViewIsClickable="true"
                ctv:cRightViewIsClickable="true"
               
          ②、代码中设置
               commonTextView.setLeftViewIsClickable(true)
                       .setCenterViewIsClickable(true)
                       .setRightViewIsClickable(true)   
        commonTextView.
        setOnCommonTextViewClickListener(new CommonTextView.OnCommonTextViewClickListener(){
                                                  @Override
                                                  public void onCommonTextViewClick() {
                                                      super.onCommonTextViewClick();
                                                      //do click
                                                  }

                                                  @Override
                                                  public void onLeftViewClick() {
                                                      super.onLeftViewClick();
                                                      //do click
                                                  }

                                                  @Override
                                                  public void onCenterViewClick() {
                                                      super.onCenterViewClick();
                                                      //do click
                                                  }

                                                  @Override
                                                  public void onRightViewClick() {
                                                      super.onRightViewClick();
                                                      //do click
                                                  }
                                              });

### 5.属性说明(以下属性全部可以通过xml文件配置和代码进行设置)

        <declare-styleable name="CommonTextView">

                <attr name="cLeftIconResForDrawableLeft" format="reference" />
                <attr name="cLeftIconResForDrawableTop" format="reference" />
                <attr name="cLeftIconResForDrawableRight" format="reference" />
                <attr name="cLeftIconResForDrawableBottom" format="reference" />

                <attr name="cCenterIconResForDrawableLeft" format="reference" />
                <attr name="cCenterIconResForDrawableTop" format="reference" />
                <attr name="cCenterIconResForDrawableRight" format="reference" />
                <attr name="cCenterIconResForDrawableBottom" format="reference" />

                <attr name="cRightIconResForDrawableLeft" format="reference" />
                <attr name="cRightIconResForDrawableTop" format="reference" />
                <attr name="cRightIconResForDrawableRight" format="reference" />
                <attr name="cRightIconResForDrawableBottom" format="reference" />


                <attr name="cLeftTextString" format="string" />
                <attr name="cCenterTextString" format="string" />
                <attr name="cRightTextString" format="string" />

                <attr name="cLeftTextSize" format="dimension" />
                <attr name="cRightTextSize" format="dimension" />
                <attr name="cCenterTextSize" format="dimension" />

                <attr name="cLeftTextColor" format="color" />
                <attr name="cRightTextColor" format="color" />
                <attr name="cCenterTextColor" format="color" />

                <attr name="cLeftIconDrawablePadding" format="dimension" />
                <attr name="cCenterIconDrawablePadding" format="dimension" />
                <attr name="cRightIconDrawablePadding" format="dimension" />

                <attr name="cLeftViewPaddingLeft" format="dimension" />
                <attr name="cLeftViewPaddingRight" format="dimension" />
                <attr name="cCenterViewPaddingLeft" format="dimension" />
                <attr name="cCenterViewPaddingRight" format="dimension" />
                <attr name="cRightViewPaddingLeft" format="dimension" />
                <attr name="cRightViewPaddingRight" format="dimension" />

                attr name="cTopDividerLineMarginLR" format="dimension" />
                <attr name="cTopDividerLineMarginLeft" format="dimension" />
                <attr name="cTopDividerLineMarginRight" format="dimension" />
                
                <attr name="cBottomDividerLineMarginLR" format="dimension" />
                <attr name="cBottomDividerLineMarginLeft" format="dimension" />
                <attr name="cBottomDividerLineMarginRight" format="dimension" />
                
                <attr name="cBothDividerLineMarginLeft" format="dimension" />
                <attr name="cBothDividerLineMarginRight" format="dimension" />

                <attr name="cLeftTextViewLineSpacingExtra" format="dimension" />
                <attr name="cCenterTextViewLineSpacingExtra" format="dimension" />
                <attr name="cRightTextViewLineSpacingExtra" format="dimension" />

                <attr name="cDividerLineColor" format="color" />
                <attr name="cDividerLineHeight" format="dimension" />

                <attr name="cShowDividerLineType" format="enum">
                    <enum name="none" value="0" />
                    <enum name="top" value="1" />
                    <enum name="bottom" value="2" />
                    <enum name="both" value="3" />
                </attr>

                <attr name="cUseRipple" format="boolean" />
                <attr name="cBackgroundColor" format="color" />

                <attr name="cSetSingleLine" format="boolean" />
                <attr name="cSetMaxEms" format="integer" />
                <attr name="cSetLines" format="integer" />

                <attr name="cLeftTextViewGravity" format="enum">
                            <enum name="left_center" value="0" />
                            <enum name="center" value="1" />
                            <enum name="right_center" value="2" />
                        </attr>
                <attr name="cCenterTextViewGravity" format="enum">
                            <enum name="left_center" value="0" />
                            <enum name="center" value="1" />
                            <enum name="right_center" value="2" />
                        </attr>
                <attr name="cRightTextViewGravity" format="enum">
                            <enum name="left_center" value="0" />
                            <enum name="center" value="1" />
                            <enum name="right_center" value="2" />
                        </attr>
                <attr name="cLeftViewIsClickable" format="boolean" />
                <attr name="cCenterViewIsClickable" format="boolean" />
                <attr name="cRightViewIsClickable" format="boolean" />
                
                <attr name="cBackgroundDrawableRes" format="reference" />
                <attr name="cIsCenterAlignLeft" format="boolean" />
                <attr name="cCenterViewMarginLeft" format="dimension" />
                
                
            </declare-styleable>

# 意见反馈
如果遇到问题或者好的建议，请反馈到我的邮箱：lygttpod@163.com 或者lygttpod@gmail.com 或者QQ：460605805

如果觉得对你有用的话，点一下右上的星星赞一下吧!

# License
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
