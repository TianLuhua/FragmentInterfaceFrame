package com.action.fragmentinterfaceframe.fragmentinterfaceframe;


import android.Manifest;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.action.fragmentinterfaceframe.fragmentinterfaceframe.function.FunctionMnanger;

/**
 * Created by Tianluhua on 2018/4/3.
 */

public class BaseFragment extends Fragment {

    protected FunctionMnanger mFunctionManager;
    protected MainActivity mBaseActivity;


    public void setmFunctionManager(FunctionMnanger mFunctionManager) {
        this.mFunctionManager = mFunctionManager;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mBaseActivity = (MainActivity) context;
            mBaseActivity.setFunctionsForFragment(getTag());
        }
    }
}
