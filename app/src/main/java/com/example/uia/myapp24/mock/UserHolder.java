package com.example.uia.myapp24.mock;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.uia.myapp24.R;

public class UserHolder extends RecyclerView.ViewHolder {

    private TextView mName;

    public UserHolder(View itemView) {
        super(itemView);

        mName = itemView.findViewById(R.id.tv_text);
    }

    public TextView getName() {
        return mName;
    }

    public void setName(TextView name) {
        this.mName = name;
    }

    public void setListener(final ComplexRecyclerViewAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(view, position);
                }

            }
        });
    }

}
