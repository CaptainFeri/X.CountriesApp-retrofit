package com.example.xcountriesapp_retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xcountriesapp_retrofit.R;
import com.example.xcountriesapp_retrofit.callback.CountryDiffUtilCallBack;
import com.example.xcountriesapp_retrofit.databinding.CountryItemHolderBinding;
import com.example.xcountriesapp_retrofit.model.Example;

import java.util.ArrayList;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {

    private ArrayList<Example> mCountries = new ArrayList<>();
    private OnItemClickListener mListener;


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CountryItemHolderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.country_item_holder, parent, false);
        return new CountryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Example currentCountry = mCountries.get(position);
        holder.mBinding.setCountry(currentCountry);
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        CountryItemHolderBinding mBinding;

        public CountryViewHolder(CountryItemHolderBinding countryItemHolderBinding) {
            super(countryItemHolderBinding.getRoot());

            mBinding = countryItemHolderBinding;
            mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currentPosition = getAdapterPosition();
                    if (mListener != null && currentPosition != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(mCountries.get(currentPosition));
                    }
                }
            });
        }
    }

    public void setCountries(ArrayList<Example> countries) {
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new CountryDiffUtilCallBack(mCountries,countries),false);
        mCountries = countries;
        result.dispatchUpdatesTo(CountryListAdapter.this);
    }


    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Example country);
    }

}
