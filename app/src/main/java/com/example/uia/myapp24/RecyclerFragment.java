package com.example.uia.myapp24;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uia.myapp24.mock.ComplexRecyclerViewAdapter;
import com.example.uia.myapp24.mock.MockGenerator;

public class RecyclerFragment extends Fragment implements ComplexRecyclerViewAdapter.OnItemClickListener {

    private RecyclerView mRecycler;
    private final ComplexRecyclerViewAdapter complexRecyclerViewAdapter = new ComplexRecyclerViewAdapter();

    private String LOG_TAG = "MyApp24";

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecycler = view.findViewById(R.id.recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(complexRecyclerViewAdapter);
        complexRecyclerViewAdapter.addData(MockGenerator.generate(), false);
        complexRecyclerViewAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View itemView, int position) {
        Log.d(LOG_TAG, position + "");
        complexRecyclerViewAdapter.removeItem(position);
    }

}
