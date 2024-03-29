package com.example.soapcountry.ui.country.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.soapcountry.R;
import com.example.soapcountry.model.response.listcountry.CountryCodeAndName;
import com.example.soapcountry.util.Util;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter {
    List<CountryCodeAndName> countryList = new ArrayList<>();
    List<CountryCodeAndName> filteredList = new ArrayList<>();
    private static ClickOnCountry itemListener;
    private static final int VIEW_HEADER = 0;
    private static final int VIEW_COUNTRY = 1;


    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<CountryCodeAndName> mData) {
        this.filteredList = new ArrayList<>();
        this.countryList = mData;
        this.filteredList.addAll(countryList);
        notifyDataSetChanged();
    }


    public void setListener(ClickOnCountry clickOnCountry) {
        itemListener = clickOnCountry;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_header_item, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
            return new CountryViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_HEADER) {
            ((HeaderViewHolder) holder).BindView(filteredList.get(position));
        } else {
            ((CountryViewHolder) holder).bindView(filteredList.get(position));
            holder.itemView.setOnClickListener(v -> itemListener.clikOnTransport(filteredList.get(holder.getAdapterPosition())));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (filteredList.get(position).getTypeOfView() == 0) {
            return VIEW_HEADER;
        } else {
            return VIEW_COUNTRY;
        }
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final ImageView imageView;

        public CountryViewHolder(@NonNull View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.title);
            imageView = (ImageView) view.findViewById(R.id.image_flag);
        }

        @SuppressLint("SetTextI18n")
        public void bindView(CountryCodeAndName country) {
            name.setText(country.getsName() + " - " + country.getsISOCode());
            Glide.with(itemView.getContext()).load(UtilFlagKt.getUrlFlag(country.getsISOCode())).transition(DrawableTransitionOptions.withCrossFade()).placeholder(R.drawable.loading_animation).into(imageView);
        }

    }


    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.header);
        }

        public void BindView(CountryCodeAndName country) {
            title.setText(country.getsName().substring(0, 1));
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public List<CountryCodeAndName> filter(String text) {
        filteredList.clear();
        if (text.isEmpty()) {
            filteredList.addAll(countryList);
        } else {
            text = text.toLowerCase();
            for (CountryCodeAndName taxis : countryList) {
                if (taxis.getsName().toLowerCase().contains(text.toLowerCase()) && taxis.getTypeOfView() == VIEW_COUNTRY) {
                    filteredList.add(taxis);
                }
            }
        }
        notifyDataSetChanged();
        return filteredList;
    }

    public interface ClickOnCountry {
        void clikOnTransport(CountryCodeAndName country);
    }
}
