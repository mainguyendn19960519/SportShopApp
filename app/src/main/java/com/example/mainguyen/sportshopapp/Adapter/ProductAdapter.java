package com.example.mainguyen.sportshopapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.mainguyen.sportshopapp.App.AppController;
import com.example.mainguyen.sportshopapp.Models.Product;
import com.example.mainguyen.sportshopapp.R;

import java.util.List;


/**
 * Created by ha.dinh on 4/19/2017.
 */

public class ProductAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Product> productsList;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public ProductAdapter(Activity activity, List<Product> productsList) {
        this.activity = activity;
        this.productsList = productsList;
    }

    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int i) {
        return productsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null)
            view = inflater.inflate(R.layout.list_product_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) view
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView depCode = (TextView) view.findViewById(R.id.depCode);
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView total_staff = (TextView) view.findViewById(R.id.total_staff);

        // getting movie data for the row
        Product d = productsList.get(position);

        // thumbnail image
        thumbNail.setImageUrl(d.getImage(), imageLoader);

        // Name
        title.setText(d.getProductName());

        // Code
        depCode.setText("Code: " + String.valueOf(d.getProductId()));

        // description
        description.setText(d.getDescription());

        // release year
        total_staff.setText(String.valueOf(5));

        return view;
    }
}
