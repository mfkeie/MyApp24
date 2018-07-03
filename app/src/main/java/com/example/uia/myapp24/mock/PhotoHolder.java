package com.example.uia.myapp24.mock;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.uia.myapp24.R;

public class PhotoHolder extends RecyclerView.ViewHolder {

    private ImageView mPhoto;

    public PhotoHolder(View itemView) {
        super(itemView);
        mPhoto = itemView.findViewById(R.id.iv_img);
    }

    public ImageView getPhoto() {
        return mPhoto;
    }

    public void setPhoto(ImageView photo) {
        this.mPhoto = photo;
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
