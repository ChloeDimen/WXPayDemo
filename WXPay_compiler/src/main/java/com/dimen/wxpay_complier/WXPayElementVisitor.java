package com.dimen.wxpay_complier;


import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/**
 * 文件名：com.dimen.wxpay_complier
 * 描    述：
 * 作    者：Dimen
 * 时    间：2020/7/27
 */
public class WXPayElementVisitor extends SimpleAnnotationValueVisitor7<Void,Void> {
    private String packageName;
    private TypeMirror mTypeMirror;
    private Filer mFiler;

    public void setFiler(Filer mFiler) {
        this.mFiler = mFiler;
    }

    @Override
    public Void visitString(String s, Void aVoid) {
        packageName=s;
        return aVoid;
    }

    @Override
    public Void visitType(TypeMirror t, Void aVoid) {
        mTypeMirror=t;
        generateJavaCode();
        return aVoid;
    }
    /**
     * build WXPayEntryActivity.java
     */
    private void generateJavaCode() {
        final TypeSpec targetActivity =
                TypeSpec.classBuilder("WXPayEntryActivity")
                        .addModifiers(Modifier.PUBLIC)
                        .addModifiers(Modifier.FINAL)
                        .superclass(TypeName.get(mTypeMirror))
                        .build();

        final JavaFile javaFile = JavaFile.builder(packageName + ".wxapi", targetActivity)
                .addFileComment("微信入口文件").build();

        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("build WXPayEntryActivity.java failed");
        }


    }
}
