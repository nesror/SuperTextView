# SuperTextView
========
单个textview支持多种字体样式，支持插入图片

<img src="img\img_1.png" />

Add SuperTextView to your project
----------------------------
Step 1. Add the JitPack repository to your build file
```
	maven { url "https://www.jitpack.io" }
```

Step 2. Add the dependency
```
	compile 'com.github.nesror:SuperTextView:[look download]'
```
[![](https://www.jitpack.io/v/nesror/SuperTextView.svg)](https://www.jitpack.io/#nesror/SuperTextView)

* 新版本已经使用jitpack.io，以下是旧版本：
* Gradle:
```
   compile 'cn.yzapp.supertextview:supertextview:[look download]@aar'
```
Use
----------------------------
~~~~{java}
RoundedStrokeSpan strokeSpan = new RoundedStrokeSpan(this, R.color.colorAccent, R.color.colorPrimary);
strokeSpan.setPadding(8, -8, 10, 18);

SuperTextView textView = (SuperTextView) findViewById(R.id.textview);
textView.addText("你好世界", new ForegroundColorSpan(getResources().getColor(R.color.colorAccent)),new StrikethroughSpan())
        .text("电话")
        .setSpan(strokeSpan)
        .setUrl("tel:0123456789")
        .setFontColor(getResources().getColor(R.color.colorPrimary))
        .add()
        .addImage(getResources().getDrawable(R.drawable.icon_city))
        .text("我的blog")
        .setUrl("http://blog.yzapp.cn")
        .setFontStyle(Typeface.BOLD_ITALIC)
        .setFontColor(getResources().getColor(R.color.colorPrimary))
        .add();
~~~~
