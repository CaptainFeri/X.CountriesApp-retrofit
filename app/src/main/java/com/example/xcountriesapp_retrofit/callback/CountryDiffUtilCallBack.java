package com.example.xcountriesapp_retrofit.callback;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.xcountriesapp_retrofit.model.Example;

import java.util.ArrayList;

public class CountryDiffUtilCallBack extends DiffUtil.Callback {

    ArrayList<Example> oldCountriesList;
    ArrayList<Example> newCountriesList;

    public CountryDiffUtilCallBack(ArrayList<Example> oldCountriesList, ArrayList<Example> newCountriesList) {
        this.oldCountriesList = oldCountriesList;
        this.newCountriesList = newCountriesList;
    }

    @Override
    public int getOldListSize() {
        return oldCountriesList == null ? 0 : oldCountriesList.size();
    }

    @Override
    public int getNewListSize() {
        return newCountriesList == null ? 0 : newCountriesList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCountriesList.get(oldItemPosition).getNumericCode().equals(newCountriesList.get(newItemPosition).getNumericCode());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCountriesList.get(oldItemPosition).equals(newCountriesList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
