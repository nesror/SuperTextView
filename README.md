# SuperTextView
========
单个textview支持多种字体样式，支持插入图片

<img src="img\img_1.png" />

Add NumChooseView to your project
----------------------------
Gradle:
```
   compile 'cn.yzapp.supertextview:supertextview:[look download]@aar'
```

Maven:
```
<dependency>
  <groupId>cn.yzapp.supertextview</groupId>
  <artifactId>supertextview</artifactId>
  <version>[look download]</version>
  <type>aar</type>
</dependency>
```
[ ![Download](https://api.bintray.com/packages/nesror/maven/supertextview/images/download.svg) ](https://bintray.com/artifact/download/nesror/maven/cn/yzapp/supertextview/supertextview/0.0.2/supertextview-0.0.2.aar)

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
