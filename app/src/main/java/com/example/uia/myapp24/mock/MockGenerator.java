package com.example.uia.myapp24.mock;

import com.example.uia.myapp24.R;

import java.util.ArrayList;
import java.util.List;

public class MockGenerator {
    public static List<Object> generate() {
        List<Object> mocks = new ArrayList<>(2);
        mocks.add(new User("Android"));
        mocks.add(new Photo(R.mipmap.ic_launcher_round));
        mocks.add(new User("IOS"));
        mocks.add(new Photo(R.mipmap.ic_launcher));
        return mocks;
    }
}
