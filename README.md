# TestDesugarJdk7Libs
Desugar currently blows up in the app I'm working on. This is a minimal project to demonstrate the errors in building.

```
Exception in thread "main" java.lang.IllegalStateException: Couldn't desugar invokedynamic for es/lolrav/testdesugarjdk7libs/MyBrokenView.run using java/lang/invoke/LambdaMetafactory.metafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; (6) with arguments [()V, es/lolrav/testdesugarjdk7libs/MyBrokenView.lambda$breakDesugar$0()V (7), ()V]
	at com.google.devtools.build.android.desugar.LambdaDesugaring$InvokedynamicRewriter.visitInvokeDynamicInsn(LambdaDesugaring.java:389)
	at org.objectweb.asm.ClassReader.a(Unknown Source)
	at org.objectweb.asm.ClassReader.b(Unknown Source)
	at org.objectweb.asm.ClassReader.accept(Unknown Source)
	at org.objectweb.asm.ClassReader.accept(Unknown Source)
	at com.google.devtools.build.android.desugar.Desugar.main(Desugar.java:256)
Caused by: java.lang.IllegalAccessException: no such method: es.lolrav.testdesugarjdk7libs.MyBrokenView.lambda$breakDesugar$0()void/invokeSpecial
	at java.lang.invoke.MemberName.makeAccessException(MemberName.java:869)
	at java.lang.invoke.MemberName$Factory.resolveOrFail(MemberName.java:1005)
	at java.lang.invoke.MethodHandles$Lookup.resolveOrFail(MethodHandles.java:1385)
	at java.lang.invoke.MethodHandles$Lookup.findSpecial(MethodHandles.java:1003)
	at com.google.devtools.build.android.desugar.LambdaDesugaring$InvokedynamicRewriter.toMethodHandle(LambdaDesugaring.java:442)
	at com.google.devtools.build.android.desugar.LambdaDesugaring$InvokedynamicRewriter.toJvmMetatype(LambdaDesugaring.java:421)
	at com.google.devtools.build.android.desugar.LambdaDesugaring$InvokedynamicRewriter.visitInvokeDynamicInsn(LambdaDesugaring.java:352)
	... 5 more
Caused by: java.lang.VerifyError: Expecting a stackmap frame at branch target 55
Exception Details:
  Location:
    com/qozix/tileview/widgets/ZoomPanLayout.onMeasure(II)V @30: if_icmpge
  Reason:
    Expected stackmap frame at this location.
  Bytecode:
    0x0000000: 2ab4 008e 128f b800 933e 2ab4 0095 128f
    0x0000010: b800 9336 0403 3605 1505 2ab6 0099 a200
    0x0000020: 192a 1505 b600 9d3a 0619 061d 1504 b600
    0x0000030: a084 0501 a7ff e41b b800 a436 051c b800
    0x0000040: a436 0615 051b b800 a736 0515 061c b800
    0x0000050: a736 062a 1505 1506 b600 aab1          

	at java.lang.invoke.MethodHandleNatives.resolve(Native Method)
	at java.lang.invoke.MemberName$Factory.resolve(MemberName.java:977)
	at java.lang.invoke.MemberName$Factory.resolveOrFail(MemberName.java:1002)
	... 10 more
```
