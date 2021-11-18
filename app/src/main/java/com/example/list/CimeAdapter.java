package com.example.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.list.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.list.databinding.ListItemCrimeBinding;

import java.util.List;

public class CimeAdapter extends RecyclerView.Adapter<CimeAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;

    public CimeAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListItemCrimeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText("# Crime: " + mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderItem mItem;

        public ViewHolder(ListItemCrimeBinding binding) {
            super(binding.getRoot());
            mIdView = binding.crimeTitle;
            mContentView = binding.crimeDate;
        }

        @Override
        @NonNull
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}