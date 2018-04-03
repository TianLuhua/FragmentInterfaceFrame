package com.action.fragmentinterfaceframe.fragmentinterfaceframe.function;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public abstract class FunctionWithParamAndResult<P, R> extends Function {

    public FunctionWithParamAndResult(String mFunctionName) {
        super(mFunctionName);
    }

    public abstract R function(P param);
}
