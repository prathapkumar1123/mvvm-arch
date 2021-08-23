package com.sample.framework.mvvm.java.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sample.framework.mvvm.R;
import com.sample.framework.mvvm.databinding.ItemLayoutBinding;
import com.sample.framework.mvvm.java.network.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.DataViewHolder> {

    private final List<User> usersList;

    public MainAdapter(List<User> usersList) {
        this.usersList = usersList;
    }

    public void addData(List<User> userList) {
        this.usersList.addAll(userList);
    }

    @NonNull
    @NotNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_layout,
                parent, false);

        return new DataViewHolder(itemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DataViewHolder holder, int position) {
        holder.bind(usersList.get(position));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {

        private final ItemLayoutBinding itemLayoutBinding;

        public DataViewHolder(ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
        }

        void bind(User user) {
            itemLayoutBinding.textViewUserName.setText(user.name);
            itemLayoutBinding.textViewUserEmail.setText(user.email);
            Glide.with(itemLayoutBinding.imageViewAvatar.getContext())
                    .load(user.avatar)
                    .into(itemLayoutBinding.imageViewAvatar);
        }

        void bindListeners(MainAdapterListener listener) {
            itemLayoutBinding.getRoot().setOnClickListener(v -> {
                listener.onItemClicked();
            });
        }

    }

    public interface MainAdapterListener {

        void onItemClicked();

        void onSuccessClicked();

    }

}
