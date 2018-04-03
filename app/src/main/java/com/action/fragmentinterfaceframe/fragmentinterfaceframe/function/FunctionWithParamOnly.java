package com.action.fragmentinterfaceframe.fragmentinterfaceframe.function;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public abstract class FunctionWithParamOnly<P> extends Function {

    public FunctionWithParamOnly(String functionName) {
        super(functionName);
    }

    public abstract void function(P p);
}
