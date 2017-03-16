package com.app.diy.learning;

/**
 * Created by Cuong Pham on 3/10/17.
 */

public class test {
    public static class Inner{
        public void inmth(){}
    }
    public void mth(){
        OuterClass out = new OuterClass();
        OuterClass.StaticNestedClass a = new OuterClass.StaticNestedClass();
        OuterClass.InnerClass b = null;
    }
}
