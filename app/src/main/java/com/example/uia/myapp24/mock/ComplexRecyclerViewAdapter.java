package com.example.uia.myapp24.mock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import com.example.uia.myapp24.R;

public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Object> items = new ArrayList<>();
    private final int USER = 0, PHOTO = 1;
    private OnItemClickListener mListener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case USER:
                View v1 = inflater.inflate(R.layout.li_text, parent, false);
                viewHolder = new UserHolder(v1);
                break;
            case PHOTO:
                View v2 = inflater.inflate(R.layout.li_image, parent, false);
                viewHolder = new PhotoHolder(v2);
                break;
            default:
                View v = inflater.inflate(R.layout.li_text, parent, false);
                viewHolder = new UserHolder(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case USER:
                UserHolder vh1 = (UserHolder) holder;
                configureUserHolder(vh1, position);
                vh1.setListener(mListener);
                break;
            case PHOTO:
                PhotoHolder vh2 = (PhotoHolder) holder;
                configurePhotoHolder(vh2, position);
                vh2.setListener(mListener);
                break;
            default:
                //RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) viewHolder;
                //configureDefaultViewHolder(vh, position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof User)
            return USER;
        else if (items.get(position) instanceof Photo)
            return PHOTO;

        return -1;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void addData(List<Object> objects, boolean refresh) {
        //Перед добавлением новых данных, очищаем старые
        if(refresh)
            items.clear();
        //Добавляем новые данные
        items.addAll(objects);
        //извещаем о изменении данных
        notifyDataSetChanged();
    }

    public void removeItem(int id) {
        if(id >= 0 && items.get(id) != null)
            items.remove(id);
        notifyDataSetChanged();
    }

    private void configureUserHolder(UserHolder vh, int position) {
        User user = (User) items.get(position);
        if (user != null) {
            vh.getName().setText(user.getName());
        }
    }

    private void configurePhotoHolder(PhotoHolder vh, int position) {
        Photo photo = (Photo) items.get(position);
        vh.getPhoto().setImageResource(photo.getImg());
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }


}
