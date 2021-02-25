package com.cos.instauiexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InstaTopAdapter extends  RecyclerView.Adapter<InstaTopAdapter.MyViewHolder>{

    private final List<User> users;

    public InstaTopAdapter(List<User> users) {
        this.users = users;
    }

    public void addItem(User user) {
        users.add(user);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        users.remove(position);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.insta_top, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageView ivImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_top_name);
            ivImage = itemView.findViewById(R.id.iv_top_image);
        }

        public void setItem(User user) {
            tvName.setText((user.getUsername().toString()));
            ivImage.setImageResource(user.getPic());
        }
    }
}
