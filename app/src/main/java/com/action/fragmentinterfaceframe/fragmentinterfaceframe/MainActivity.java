package com.action.fragmentinterfaceframe.fragmentinterfaceframe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.action.fragmentinterfaceframe.fragmentinterfaceframe.function.FunctionMnanger;
import com.action.fragmentinterfaceframe.fragmentinterfaceframe.function.FunctionNoParamNoResult;
import com.action.fragmentinterfaceframe.fragmentinterfaceframe.function.FunctionWithParamAndResult;
import com.action.fragmentinterfaceframe.fragmentinterfaceframe.function.FunctionWithParamOnly;
import com.action.fragmentinterfaceframe.fragmentinterfaceframe.function.FunctionWithResultOnly;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {


    private ViewPager viewpager;
    private RadioGroup radioGroup;

    private List<Fragment> fragments = new ArrayList<>();
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0,false);
        viewpager.setOffscreenPageLimit(4);
    }

    public void setFunctionsForFragment(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fm.findFragmentByTag(tag);
        FunctionMnanger functionMnanger = FunctionMnanger.getInstance();
        fragment.setmFunctionManager(functionMnanger.addFunction(new FunctionNoParamNoResult(Fragment1.INTERFACE_RESULT) {
            @Override
            public void function() {
                Toast.makeText(MainActivity.this, "成功调用无参无返回值的接口", Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithParamAndResult<String, String>(Fragment3.INTERFACE_RESULT) {
            @Override
            public String function(String param) {
                return "系统的字符串---" + param;
            }
        }).addFunction(new FunctionWithResultOnly<String>(Fragment2.INTERFACE_RESULT) {
            @Override
            public String function() {
                return "只有一个返回值的方法被调用！";
            }
        }).addFunction(new FunctionWithParamOnly<String>(Fragment4.INTERFACE_RESULT) {
            @Override
            public void function(String o) {
                Toast.makeText(MainActivity.this, "成功调用有参无返回值的接口：" + o, Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio1:
                viewpager.setCurrentItem(0);
                break;
            case R.id.radio2:
                viewpager.setCurrentItem(1);
                break;
            case R.id.radio3:
                viewpager.setCurrentItem(2);
                break;
            case R.id.radio4:
                viewpager.setCurrentItem(3);
                break;
        }
    }
}
