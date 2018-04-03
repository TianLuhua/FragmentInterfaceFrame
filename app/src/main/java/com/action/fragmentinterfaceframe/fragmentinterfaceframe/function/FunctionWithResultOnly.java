package com.action.fragmentinterfaceframe.fragmentinterfaceframe.function;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public abstract class FunctionWithResultOnly<R> extends Function {
    public FunctionWithResultOnly(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract R function();

}
