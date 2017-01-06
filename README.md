# SuperTextView 以及简化版 [**CommonTextView**](https://github.com/lygttpod/SuperTextView/blob/master/CommonTextView_Readme.md)
一个功能强大的TextView，可以满足日常大部分布局方式，开发者可已自行组合属性配置出属于自己风格的样式!如果觉得对你有用的话，点一下右上的星星赞一下吧!

###因为这是首次编写的开源项目，经验并不是很足，使用过程中大家遇到什么问题欢迎在Issues或者发送邮件提出来，这边会尽快修改完善这个库，谢谢大家的支持！

#效果图
<div  align="center">    
<img src="https://github.com/lygttpod/SuperTextView/blob/master/screenshot/screenshot.png" width = "360" height = "640" alt="效果图" align=center /></div>
<div  align="center">    
<img src="https://github.com/lygttpod/SuperTextView/blob/master/screenshot/type1.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/lygttpod/SuperTextView/blob/master/screenshot/type2.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/lygttpod/SuperTextView/blob/master/screenshot/type3.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/lygttpod/SuperTextView/blob/master/screenshot/type4.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/lygttpod/SuperTextView/blob/master/screenshot/type5.png" width = "270" height = "480" alt="效果图" align=center />
<img src="https://github.com/lygttpod/SuperTextView/blob/master/screenshot/type6.png" width = "270" height = "480" alt="效果图" align=center />
</div>
#基本使用
##公告：由于Bintray试用期已到，穷屌丝无法支付起高昂的仓库管理费用(Bintrayr收费标准 $150/month）,故迁移库至JitPack，依赖方式有所改变，开发者在使用过程中请注意。
###1.添加Gradle依赖 
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
        compile 'com.github.lygttpod:SuperTextView:1.0.8'
        }

以下依赖方式将在2016年11月16号之后停止使用（老用户请注意）

        dependencies {
        ...
        compile 'com.allen.supertextview:supertextview:1.0.3'
        }

###2.布局中如何使用
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
                1、上下的线可以通过   sLineShow 设置  有四种显示方式 none，top，bottom，both
                2、通过设置 sUseRipple=true 开启水波效果
###3.代码中如何使用
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
                .setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
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
          
###4.点击事件（可根据需求选择实现某个点击事件）
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

###5.属性说明(以下属性全部可以通过xml文件配置和代码进行设置)
        <declare-styleable name="SuperTextView">
        <attr name="sLeftIconRes" format="reference"/>
        <attr name="sRightIconRes" format="reference"/>
        <attr name="sRightCheckBoxRes" format="reference"/>

        <attr name="sLeftTextString" format="string"/>
        <attr name="sCenterTextString" format="string"/>
        <attr name="sRightTextString" format="string"/>

        <attr name="sLeftTopTextString" format="string"/>
        <attr name="sLeftBottomTextString" format="string"/>
        <attr name="sLeftBottomTextString2" format="string"/>


        <attr name="sTopLineMargin" format="dimension"/>
        <attr name="sBottomLineMargin" format="dimension"/>
        <attr name="sBothLineMargin" format="dimension"/>

        <attr name="sLeftIconMarginLeft" format="dimension"/>
        <attr name="sLeftTextMarginLeft" format="dimension"/>

        <attr name="sLeftTopTextMarginLeft" format="dimension"/>
        <attr name="sLeftBottomTextMarginLeft" format="dimension"/>
        <attr name="sLeftBottomTextMarginLeft2" format="dimension"/>

        <attr name="sRightIconMarginRight" format="dimension"/>
        <attr name="sRightTextMarginRight" format="dimension"/>
        <attr name="sRightCheckBoxMarginRight" format="dimension"/>
        <attr name="sRightCheckBoxShow" format="boolean"/>
        <attr name="sIsChecked" format="boolean"/>
        <attr name="sUseRipple" format="boolean"/>

        <attr name="sLeftTextSize" format="dimension"/>
        <attr name="sLeftTopTextSize" format="dimension"/>
        <attr name="sLeftBottomTextSize" format="dimension"/>
        <attr name="sLeftBottomTextSize2" format="dimension"/>
        <attr name="sRightTextSize" format="dimension"/>
        <attr name="sCenterTextSize" format="dimension"/>

        <attr name="sBackgroundColor" format="color"/>
        <attr name="sLeftTextColor" format="color"/>
        <attr name="sLeftTopTextColor" format="color"/>
        <attr name="sLeftBottomTextColor" format="color"/>
        <attr name="sLeftBottomTextColor2" format="color"/>
        <attr name="sRightTextColor" format="color"/>
        <attr name="sCenterTextColor" format="color"/>

        <attr name="sLineShow" format="enum">
            <enum name="none" value="0"/>
            <enum name="top" value="1"/>
            <enum name="bottom" value="2"/>
            <enum name="both" value="3"/>
        </attr>

    </declare-styleable> 
    
###6.使用第三方库(Picasso或者Glide)加载网络图片
         Picasso.with(this)
         .load(url)
         .placeholder(R.drawable.head_default)
         .into((ImageView) superTextView.getView(SuperTextView.leftImageViewId));
    
#更新日志

### V1.0.8
* 	修复CommonTextView点击事件无效的bug

### V1.0.7
* 	CommonTextView新增支持加载网络图片

### V1.0.6
* 	新增设置分割线颜色和宽度的方法
* 	新增简化版CommonTextView

### V1.0.3
* 	新增左右两边图片支持常用三方库加载网络图片

### V1.0.2
* 修复文字内容过多，超过1行的处理，导致两边的文字会引起重叠的bug

### V1.0.1
* 修复编译版本不同导致无法正常使用的bug

### V1.0.0
* 功能强大的TextView

#意见反馈
如果遇到问题或者好的建议，请反馈到我的邮箱：lygttpod@163.com 或者lygttpod@gmail.com 或者QQ：460605805

如果觉得对你有用的话，点一下右上的星星赞一下吧!

#License
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
