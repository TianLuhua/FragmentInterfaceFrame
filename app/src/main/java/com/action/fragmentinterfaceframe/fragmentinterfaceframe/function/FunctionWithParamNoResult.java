package com.action.fragmentinterfaceframe.fragmentinterfaceframe.function;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public abstract class FunctionWithParamNoResult<R> extends Function {

    public FunctionWithParamNoResult(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract R function();
}
