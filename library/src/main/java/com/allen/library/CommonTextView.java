package com.allen.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by allen on 2016/11/21.
 * <p>
 * 通用的textView可以实现大部分常用布局样式
 */

public class CommonTextView extends RelativeLayout {

    private Context mContext;

    private int defaultColor = 0xFF373737;//文字默认颜色
    private int defaultDividerLineColor = 0xFFE8E8E8;//分割线默认颜色
    private int defaultSize;//默认字体大小
    private int defaultPadding;//默认边距

    private int mBackgroundColor = 0xffffffff;//背景颜色


    private Drawable mLeft_drawableLeft;
    private Drawable mLeft_drawableTop;
    private Drawable mLeft_drawableRight;
    private Drawable mLeft_drawableBottom;

    private Drawable mCenter_drawableLeft;
    private Drawable mCenter_drawableTop;
    private Drawable mCenter_drawableRight;
    private Drawable mCenter_drawableBottom;

    private Drawable mRight_drawableLeft;
    private Drawable mRight_drawableTop;
    private Drawable mRight_drawableRight;
    private Drawable mRight_drawableBottom;


    private String mLeftTextString;
    private String mRightTextString;
    private String mCenterTextString;

    private int mLeftTextSize;
    private int mRightTextSize;
    private int mCenterTextSize;

    private int mLeftTextColor;
    private int mCenterTextColor;
    private int mRightTextColor;

    private int mLeftIconDrawablePadding;
    private int mCenterIconDrawablePadding;
    private int mRightIconDrawablePadding;

    private int mLeftViewPaddingLeft;
    private int mLeftViewPaddingRight;

    private int mCenterViewPaddingLeft;
    private int mCenterViewPaddingRight;

    private int mRightViewPaddingLeft;
    private int mRightViewPaddingRight;

    private int mTopDividerLineMarginLR;
    private int mBottomDividerLineMarginLR;
    private int mBothDividerLineMarginLR;

    private int mDividerLineType;
    private int mDividerLineColor;
    private int mDividerLineHeight;


    private int mLeftTextViewLineSpacingExtra;
    private int mCenterTextViewLineSpacingExtra;
    private int mRightTextViewLineSpacingExtra;

    /**
     * 分割线的类型
     */
    private static final int NONE = 0;
    private static final int TOP = 1;
    private static final int BOTTOM = 2;
    private static final int BOTH = 3;
    private static final int DEFAULT = BOTTOM;

    /**
     * 是否使用点击出现波纹效果
     */
    private boolean useRipple;

    private boolean mSetSingleLine = true;
    private int mSetMaxEms = 10;
    private int mSetLines = 1;

    private TextView leftTextView, centerTextView, rightTextView;

    private View topLineView, bottomLineView;

    private RelativeLayout.LayoutParams leftTVParams, centerTVParams, rightTVParams, topLineParams, bottomLineParams;

    private OnCommonTextViewClickListener onCommonTextViewClickListener;


    public CommonTextView(Context context) {
        this(context, null);
    }

    public CommonTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        defaultSize = dip2px(context, 13);
        defaultPadding = dip2px(context, 10);
        getAttr(attrs);
        init();
    }

    /**
     * 获取自定义控件资源
     *
     * @param attrs attrs
     */
    private void getAttr(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.CommonTextView);

        ////////设置文字或者图片资源////////
        mLeft_drawableLeft = typedArray.getDrawable(R.styleable.CommonTextView_cLeftIconResForDrawableLeft);
        mLeft_drawableTop = typedArray.getDrawable(R.styleable.CommonTextView_cLeftIconResForDrawableTop);
        mLeft_drawableRight = typedArray.getDrawable(R.styleable.CommonTextView_cLeftIconResForDrawableRight);
        mLeft_drawableBottom = typedArray.getDrawable(R.styleable.CommonTextView_cLeftIconResForDrawableBottom);

        mCenter_drawableLeft = typedArray.getDrawable(R.styleable.CommonTextView_cCenterIconResForDrawableLeft);
        mCenter_drawableTop = typedArray.getDrawable(R.styleable.CommonTextView_cCenterIconResForDrawableTop);
        mCenter_drawableRight = typedArray.getDrawable(R.styleable.CommonTextView_cCenterIconResForDrawableRight);
        mCenter_drawableBottom = typedArray.getDrawable(R.styleable.CommonTextView_cCenterIconResForDrawableBottom);

        mRight_drawableLeft = typedArray.getDrawable(R.styleable.CommonTextView_cRightIconResForDrawableLeft);
        mRight_drawableTop = typedArray.getDrawable(R.styleable.CommonTextView_cRightIconResForDrawableTop);
        mRight_drawableRight = typedArray.getDrawable(R.styleable.CommonTextView_cRightIconResForDrawableRight);
        mRight_drawableBottom = typedArray.getDrawable(R.styleable.CommonTextView_cRightIconResForDrawableBottom);

        mLeftTextString = typedArray.getString(R.styleable.CommonTextView_cLeftTextString);
        mCenterTextString = typedArray.getString(R.styleable.CommonTextView_cCenterTextString);
        mRightTextString = typedArray.getString(R.styleable.CommonTextView_cRightTextString);

        mLeftTextColor = typedArray.getColor(R.styleable.CommonTextView_cLeftTextColor, defaultColor);
        mCenterTextColor = typedArray.getColor(R.styleable.CommonTextView_cCenterTextColor, defaultColor);
        mRightTextColor = typedArray.getColor(R.styleable.CommonTextView_cRightTextColor, defaultColor);

        mLeftTextSize = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cLeftTextSize, defaultSize);
        mCenterTextSize = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cCenterTextSize, defaultSize);
        mRightTextSize = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cRightTextSize, defaultSize);

        mLeftIconDrawablePadding = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cLeftIconDrawablePadding, defaultPadding);
        mCenterIconDrawablePadding = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cCenterIconDrawablePadding, defaultPadding);
        mRightIconDrawablePadding = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cRightIconDrawablePadding, defaultPadding);

        mLeftViewPaddingLeft = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cLeftViewPaddingLeft, defaultPadding);
        mLeftViewPaddingRight = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cLeftViewPaddingRight, defaultPadding);
        mCenterViewPaddingLeft = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cCenterViewPaddingLeft, defaultPadding);
        mCenterViewPaddingRight = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cCenterViewPaddingRight, defaultPadding);
        mRightViewPaddingLeft = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cRightViewPaddingLeft, defaultPadding);
        mRightViewPaddingRight = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cRightViewPaddingRight, defaultPadding);

        mBothDividerLineMarginLR = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cBothDividerLineMarginLR, 0);
        mTopDividerLineMarginLR = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cTopDividerLineMarginLR, 0);
        mBottomDividerLineMarginLR = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cBottomDividerLineMarginLR, 0);

        mLeftTextViewLineSpacingExtra = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cLeftTextViewLineSpacingExtra, 0);
        mCenterTextViewLineSpacingExtra = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cCenterTextViewLineSpacingExtra, 0);
        mRightTextViewLineSpacingExtra = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cRightTextViewLineSpacingExtra, 0);

        mDividerLineType = typedArray.getInt(R.styleable.CommonTextView_cShowDividerLineType, DEFAULT);
        mDividerLineColor = typedArray.getColor(R.styleable.CommonTextView_cDividerLineColor, defaultDividerLineColor);

        mDividerLineHeight = typedArray.getDimensionPixelSize(R.styleable.CommonTextView_cDividerLineHeight, dip2px(mContext, 0.5f));

        useRipple = typedArray.getBoolean(R.styleable.CommonTextView_cUseRipple, false);

        mBackgroundColor = typedArray.getColor(R.styleable.CommonTextView_cBackgroundColor, mBackgroundColor);

        mSetSingleLine = typedArray.getBoolean(R.styleable.CommonTextView_cSetSingleLine, true);
        mSetMaxEms = typedArray.getInt(R.styleable.CommonTextView_cSetMaxEms, mSetMaxEms);
        mSetLines = typedArray.getInt(R.styleable.CommonTextView_cSetLines, 1);

        typedArray.recycle();
    }

    /**
     * 初始化
     */
    private void init() {
        initCommonTextView();
        initLineView();
        if (mLeftTextString != null) {
            initLeftText();
        }
        if (mCenterTextString != null) {
            initCenterText();
        }
        if (mRightTextString != null) {
            initRightText();
        }
    }

    /**
     * 初始化commonTextView
     */
    private void initCommonTextView() {
        this.setBackgroundColor(mBackgroundColor);
        if (useRipple) {
            this.setBackgroundResource(R.drawable.selector_white);
        }
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCommonTextViewClickListener != null) {
                    onCommonTextViewClickListener.onCommonTextViewClick();
                }
            }
        });
    }

    /**
     * 初始化分割线
     */
    private void initLineView() {
        switch (mDividerLineType) {
            case NONE:
                break;
            case TOP:
                initTopLineView(mTopDividerLineMarginLR);
                break;
            case BOTTOM:
                initBottomLineView(mBottomDividerLineMarginLR);
                break;
            case BOTH:
                initTopLineView(mBothDividerLineMarginLR);
                initBottomLineView(mBothDividerLineMarginLR);
                break;
        }

    }

    /**
     * 设置上边分割线view
     *
     * @param margin 左右间距
     */
    private void initTopLineView(int margin) {
        if (topLineView == null) {
            if (topLineParams == null) {
                topLineParams = new LayoutParams(LayoutParams.MATCH_PARENT, mDividerLineHeight);
            }
            topLineParams.addRule(ALIGN_PARENT_TOP, TRUE);
            topLineParams.setMargins(margin, 0, margin, 0);
            topLineView = new View(mContext);
            topLineView.setLayoutParams(topLineParams);
            topLineView.setBackgroundColor(mDividerLineColor);
        }
        addView(topLineView);
    }

    /**
     * 设置底部分割线view
     *
     * @param margin 左右间距
     */
    private void initBottomLineView(int margin) {
        if (bottomLineView == null) {
            if (bottomLineParams == null) {
                bottomLineParams = new LayoutParams(LayoutParams.MATCH_PARENT, mDividerLineHeight);
            }
            bottomLineParams.addRule(ALIGN_PARENT_BOTTOM, TRUE);
            bottomLineParams.setMargins(margin, 0, margin, 0);

            bottomLineView = new View(mContext);
            bottomLineView.setLayoutParams(bottomLineParams);
            bottomLineView.setBackgroundColor(mDividerLineColor);
        }
        addView(bottomLineView);
    }


    /**
     * 初始化左边textView
     */
    private void initLeftText() {
        if (leftTextView == null) {
            if (leftTVParams == null) {
                leftTVParams = getParams(leftTVParams);
            }
            leftTVParams.addRule(CENTER_VERTICAL, TRUE);
            leftTVParams.addRule(ALIGN_PARENT_LEFT, TRUE);
//            leftTVParams.addRule(LEFT_OF, R.id.cRightTextId);
            leftTVParams.setMargins(mLeftViewPaddingLeft, 0, mLeftViewPaddingRight, 0);
            leftTextView = initText(leftTextView, leftTVParams, R.id.cLeftTextId, mLeftTextColor, mLeftTextSize);
            leftTextView.setText(mLeftTextString);
//            leftTextView.setGravity(Gravity.CENTER_VERTICAL);
            leftTextView.setLineSpacing(mLeftTextViewLineSpacingExtra, 1.0f);
        }

        setDrawable(leftTextView, mLeft_drawableLeft, mLeft_drawableTop, mLeft_drawableRight, mLeft_drawableBottom, mLeftIconDrawablePadding);

    }

    /**
     * 初始化中间textView
     */
    private void initCenterText() {
        if (centerTextView == null) {
            if (centerTVParams == null) {
                centerTVParams = getParams(centerTVParams);
            }

            centerTVParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
            centerTVParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
            centerTVParams.setMargins(mCenterViewPaddingLeft, 0, mCenterViewPaddingRight, 0);

            centerTextView = initText(centerTextView, centerTVParams, R.id.cCenterTextId, mCenterTextColor, mCenterTextSize);
            centerTextView.setText(mCenterTextString);
            centerTextView.setLineSpacing(mCenterTextViewLineSpacingExtra, 1.0f);

        }
        setDrawable(centerTextView, mCenter_drawableLeft, mCenter_drawableTop, mCenter_drawableRight, mCenter_drawableBottom, mCenterIconDrawablePadding);

    }

    /**
     * 初始化右边textView
     */
    private void initRightText() {
        if (rightTextView == null) {
            if (rightTVParams == null) {
                rightTVParams = getParams(rightTVParams);
            }

            rightTVParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
            rightTVParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
            rightTVParams.setMargins(mRightViewPaddingLeft, 0, mRightViewPaddingRight, 0);
            rightTextView = initText(rightTextView, rightTVParams, R.id.cRightTextId, mRightTextColor, mRightTextSize);
            rightTextView.setText(mRightTextString);
//            rightTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
            rightTextView.setLineSpacing(mRightTextViewLineSpacingExtra, 1.0f);

        }
        setDrawable(rightTextView, mRight_drawableLeft, mRight_drawableTop, mRight_drawableRight, mRight_drawableBottom, mRightIconDrawablePadding);

    }


    /**
     * 初始化Params
     *
     * @param params 对象
     * @return 返回
     */
    public LayoutParams getParams(LayoutParams params) {
        if (params == null) {
            params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        }
        return params;
    }

    /**
     * 初始化textView
     *
     * @param textView     对象
     * @param layoutParams 对象
     * @param id           id
     * @param textColor    颜色值
     * @param textSize     字体大小
     * @return 返回
     */
    public TextView initText(TextView textView, LayoutParams layoutParams, int id, int textColor, int textSize) {
        if (textView == null) {
            textView = new TextView(mContext);
            textView.setId(id);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(textColor);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            textView.setGravity(Gravity.CENTER);
            textView.setLines(mSetLines);
            textView.setSingleLine(mSetSingleLine);
            textView.setMaxEms(mSetMaxEms);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            addView(textView);
        }
        return textView;
    }

    /**
     * 设置textView的drawable
     *
     * @param textView        对象
     * @param drawableLeft    左边图标
     * @param drawableTop     上边图标
     * @param drawableRight   右边图标
     * @param drawableBottom  下边图标
     * @param drawablePadding 图标距离文字的间距
     */
    public void setDrawable(TextView textView, Drawable drawableLeft, Drawable drawableTop, Drawable drawableRight, Drawable drawableBottom, int drawablePadding) {
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
        textView.setCompoundDrawablePadding(drawablePadding);
    }

    /**
     * 设置左边文字字符串
     *
     * @param string 字符串
     * @return 返回
     */
    public CommonTextView setLeftTextString(String string) {
        if (leftTextView == null) {
            initLeftText();
        }
        leftTextView.setText(string);
        return this;
    }

    /**
     * 设置左边文字字体大小
     *
     * @param size 字体大小
     * @return 返回
     */
    public CommonTextView setLeftTextSize(float size) {
        if (leftTextView == null) {
            initLeftText();
        }
        leftTextView.setTextSize(size);
        return this;
    }

    /**
     * set Left TextColor
     *
     * @param color textColor
     * @return return
     */
    public CommonTextView setLeftTextColor(int color) {
        if (leftTextView == null) {
            initLeftText();
        }
        leftTextView.setTextColor(color);
        return this;
    }

    /**
     * 设置中间文字字符串
     *
     * @param string 字符串
     * @return 返回
     */
    public CommonTextView setCenterTextString(String string) {
        if (centerTextView == null) {
            initCenterText();
        }
        centerTextView.setText(string);
        return this;
    }

    /**
     * 设置中间文字字体大小
     *
     * @param size 字体大小
     * @return 返回
     */
    public CommonTextView setCenterTextSize(float size) {
        if (centerTextView == null) {
            initCenterText();
        }
        centerTextView.setTextSize(size);
        return this;
    }

    /**
     * 设置中间文字颜色值
     *
     * @param color 颜色值
     * @return 返回
     */
    public CommonTextView setCenterTextColor(int color) {
        if (centerTextView == null) {
            initCenterText();
        }
        centerTextView.setTextColor(color);
        return this;
    }

    /**
     * 设置右边文字字符串
     *
     * @param string 字符串
     * @return 返回
     */
    public CommonTextView setRightTextString(String string) {
        if (rightTextView == null) {
            initRightText();
        }
        rightTextView.setText(string);
        return this;
    }

    /**
     * 设置右边文字的字体大小
     *
     * @param size 字体大小
     * @return 返回
     */
    public CommonTextView setRightTextSize(float size) {
        if (rightTextView == null) {
            initRightText();
        }
        rightTextView.setTextSize(size);
        return this;
    }

    /**
     * 设置右边文字的颜色
     *
     * @param color 颜色值
     * @return 返回
     */
    public CommonTextView setRightTextColor(int color) {
        if (rightTextView == null) {
            initRightText();
        }
        rightTextView.setTextColor(color);
        return this;
    }

    /**
     * 设置左边view的drawableLeft
     *
     * @param drawableLeft 资源
     * @return 返回
     */
    public CommonTextView setLeftDrawableLeft(Drawable drawableLeft) {
        if (drawableLeft != null) {
            drawableLeft.setBounds(0, 0, drawableLeft.getMinimumWidth(), drawableLeft.getMinimumHeight());
        }
        if (leftTextView == null) {
            initLeftText();
        }
        leftTextView.setCompoundDrawables(drawableLeft, null, null, null);
        return this;
    }

    /**
     * 设置左边view的drawableTop
     *
     * @param drawableTop 资源
     * @returnTop 返回
     */
    public CommonTextView setLeftDrawableTop(Drawable drawableTop) {
        if (drawableTop != null) {
            drawableTop.setBounds(0, 0, drawableTop.getMinimumWidth(), drawableTop.getMinimumHeight());
        }
        if (leftTextView == null) {
            initLeftText();
        }
        leftTextView.setCompoundDrawables(null, drawableTop, null, null);
        return this;
    }

    /**
     * 设置左边view的drawableRight
     *
     * @param drawableRight 资源
     * @return 返回
     */
    public CommonTextView setLeftDrawableRight(Drawable drawableRight) {
        if (drawableRight != null) {
            drawableRight.setBounds(0, 0, drawableRight.getMinimumWidth(), drawableRight.getMinimumHeight());
        }
        if (leftTextView == null) {
            initLeftText();
        }
        leftTextView.setCompoundDrawables(null, null, drawableRight, null);
        return this;
    }

    /**
     * 设置左边view的drawableBottom
     *
     * @param drawableBottom 资源
     * @return 返回
     */
    public CommonTextView setLeftDrawableBottom(Drawable drawableBottom) {
        if (drawableBottom != null) {
            drawableBottom.setBounds(0, 0, drawableBottom.getMinimumWidth(), drawableBottom.getMinimumHeight());
        }
        if (leftTextView == null) {
            initLeftText();
        }
        leftTextView.setCompoundDrawables(null, null, null, drawableBottom);
        return this;
    }

    /**
     * 设置中间view的drawableLeft
     *
     * @param drawableLeft 资源
     * @return 返回
     */
    public CommonTextView setCenterDrawableLeft(Drawable drawableLeft) {
        if (drawableLeft != null) {
            drawableLeft.setBounds(0, 0, drawableLeft.getMinimumWidth(), drawableLeft.getMinimumHeight());
        }
        if (centerTextView == null) {
            initCenterText();
        }
        centerTextView.setCompoundDrawables(drawableLeft, null, null, null);
        return this;
    }

    /**
     * 设置中间view的drawableTop
     *
     * @param drawableTop 资源
     * @returnTop 返回
     */
    public CommonTextView setCenterDrawableTop(Drawable drawableTop) {
        if (drawableTop != null) {
            drawableTop.setBounds(0, 0, drawableTop.getMinimumWidth(), drawableTop.getMinimumHeight());
        }
        if (centerTextView == null) {
            initCenterText();
        }
        centerTextView.setCompoundDrawables(null, drawableTop, null, null);
        return this;
    }

    /**
     * 设置中间view的drawableRight
     *
     * @param drawableRight 资源
     * @return 返回
     */
    public CommonTextView setCenterDrawableRight(Drawable drawableRight) {
        if (drawableRight != null) {
            drawableRight.setBounds(0, 0, drawableRight.getMinimumWidth(), drawableRight.getMinimumHeight());
        }
        if (centerTextView == null) {
            initCenterText();
        }
        centerTextView.setCompoundDrawables(null, null, drawableRight, null);
        return this;
    }

    /**
     * 设置中间view的drawableBottom
     *
     * @param drawableBottom 资源
     * @return 返回
     */
    public CommonTextView setCenterDrawableBottom(Drawable drawableBottom) {
        if (drawableBottom != null) {
            drawableBottom.setBounds(0, 0, drawableBottom.getMinimumWidth(), drawableBottom.getMinimumHeight());
        }
        if (centerTextView == null) {
            initCenterText();
        }
        centerTextView.setCompoundDrawables(null, null, null, drawableBottom);
        return this;
    }

    /**
     * 设置右边view的drawableLeft
     *
     * @param drawableLeft 资源
     * @return 返回
     */
    public CommonTextView setRightDrawableLeft(Drawable drawableLeft) {
        if (drawableLeft != null) {
            drawableLeft.setBounds(0, 0, drawableLeft.getMinimumWidth(), drawableLeft.getMinimumHeight());
        }
        if (rightTextView == null) {
            initRightText();
        }
        rightTextView.setCompoundDrawables(drawableLeft, null, null, null);
        return this;
    }

    /**
     * 设置右边view的drawableTop
     *
     * @param drawableTop 资源
     * @returnTop 返回
     */
    public CommonTextView setRightDrawableTop(Drawable drawableTop) {
        if (drawableTop != null) {
            drawableTop.setBounds(0, 0, drawableTop.getMinimumWidth(), drawableTop.getMinimumHeight());
        }
        if (rightTextView == null) {
            initRightText();
        }
        rightTextView.setCompoundDrawables(null, drawableTop, null, null);
        return this;
    }

    /**
     * 设置右边view的drawableRight
     *
     * @param drawableRight 资源
     * @return 返回
     */
    public CommonTextView setRightDrawableRight(Drawable drawableRight) {
        if (drawableRight != null) {
            drawableRight.setBounds(0, 0, drawableRight.getMinimumWidth(), drawableRight.getMinimumHeight());
        }
        if (rightTextView == null) {
            initRightText();
        }
        rightTextView.setCompoundDrawables(null, null, drawableRight, null);
        return this;
    }

    /**
     * 设置右边view的drawableBottom
     *
     * @param drawableBottom 资源
     * @return 返回
     */
    public CommonTextView setRightDrawableBottom(Drawable drawableBottom) {
        if (drawableBottom != null) {
            drawableBottom.setBounds(0, 0, drawableBottom.getMinimumWidth(), drawableBottom.getMinimumHeight());
        }
        if (rightTextView == null) {
            initRightText();
        }
        rightTextView.setCompoundDrawables(null, null, null, drawableBottom);
        return this;
    }

    /**
     * 获取左边textView的值
     *
     * @return 返回
     */
    public CharSequence getLeftTextString() {
        return leftTextView != null ? leftTextView.getText() : "";
    }

    /**
     * 获取中间textView的值
     *
     * @return 返回
     */
    public CharSequence getCenterTextString() {
        return centerTextView != null ? centerTextView.getText() : "";
    }

    /**
     * 获取右边textView的值
     *
     * @return 返回
     */
    public CharSequence getRightTextString() {
        return rightTextView != null ? rightTextView.getText() : "";
    }

    /**
     * 点击事件接口
     */
    public static class OnCommonTextViewClickListener {
        public void onCommonTextViewClick() {
        }

        public void onLeftViewClick() {
        }

        public void onCenterViewClick() {
        }

        public void onRightViewClick() {
        }

    }

    /**
     * 点击事件
     *
     * @param listener listener对象
     * @return 返回当前对象便于链式操作
     */
    public CommonTextView setOnCommonTextViewClickListener(OnCommonTextViewClickListener listener) {
        this.onCommonTextViewClickListener = listener;
        return this;
    }

    /**
     * 单位转换工具类
     *
     * @param context  上下文对象
     * @param dipValue 值
     * @return 返回值
     */
    public int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 单位转换工具类
     *
     * @param context 上下文对象
     * @param pxValue 值
     * @return 返回值
     */
    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 单位转换工具类
     *
     * @param context 上下文对象
     * @param spValue 值
     * @return 返回值
     */
    public int sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }

}
