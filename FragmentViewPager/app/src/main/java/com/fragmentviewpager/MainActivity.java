package com.fragmentviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button home;
    private Button xinxi;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initId();
        initFrament();
    }

    private void initFrament() {
        fragmentList.add(new FramentHome());
        fragmentList.add(new FramentXinXi());
        initAddFragment(0);
    }

    private void initAddFragment(int index) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.framel, fragmentList.get(index));
        transaction.commit();

    }

    private void initId() {
        home = (Button) findViewById(R.id.bt_home);
        xinxi = (Button) findViewById(R.id.bt_xinxi);
        home.setOnClickListener(this);
        xinxi.setOnClickListener(this);
        home.setSelected(true);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bt_home:
                initAddFragment(0);
                home.setSelected(true);
                xinxi.setSelected(false);
                break;
            case R.id.bt_xinxi:
                initAddFragment(1);
                xinxi.setSelected(true);
                home.setSelected(false);
                break;
        }
    }
}
