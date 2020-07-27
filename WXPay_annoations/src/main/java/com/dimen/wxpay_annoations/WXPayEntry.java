package com.dimen.wxpay_annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件名：com.dimen.wxpay_annoations
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface WXPayEntry {

    String packageName();//包名
    Class<?> entryClass();//类的class
}
