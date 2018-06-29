package com.example.ahmetserdargeze.ikasbreakfastproject.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmetserdargeze.ikasbreakfastproject.FoodFragment;
import com.example.ahmetserdargeze.ikasbreakfastproject.R;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Cart;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu;

import java.util.List;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.ViewHolder> {

    private List<Cart> mDataset;


//     Constructor
    public PriceAdapter(List<Cart> myDataset) {
        if (!myDataset.isEmpty())
            mDataset = myDataset;
    }

    public PriceAdapter() {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cancel;

        TextView adet_iv,product_name,porsiyon_tv,price_tv,nodata_tv;
        CardView price_cv;

        public ViewHolder(View v) {
            super(v);
//            nodata_tv=(TextView) v.findViewById(R.id.nodata_tv);
            price_cv=(CardView) v.findViewById(R.id.price_cv);
            adet_iv = (TextView) v.findViewById(R.id.adet_tv);
            product_name = (TextView) v.findViewById(R.id.product_name);
            porsiyon_tv = (TextView) v.findViewById(R.id.porsiyon_tv);
            price_tv = (TextView) v.findViewById(R.id.price_tv);
            cancel = (ImageView) v.findViewById(R.id.cancel_iv);

        }
    }

    @Override
    public PriceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // Card_view layoutmuzu kullanarak yeni bir view inflate ettik
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pricecardview, parent, false);

        // Olusturdugumuz ViewHolder classına az önce olusturdugumuz view'ı verdik
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (!FoodFragment.carts.isEmpty()){


            holder.price_cv.setVisibility(View.VISIBLE);
            holder.price_tv.setText(FoodFragment.carts.get(position).getTotal_price()+"");
            holder.adet_iv.setText(FoodFragment.carts.get(position).getQuantity()+"");
            holder.porsiyon_tv.setText(FoodFragment.carts.get(position).getSell_price()+"tl");
            holder.product_name.setText(FoodFragment.carts.get(position).getId()+" "+FoodFragment.carts.get(position).getName());
            holder.cancel.setImageResource(R.drawable.ic_cancel_black_24dp);
            holder.cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position= holder.getLayoutPosition();
                    FoodFragment.clearOneRow(position);

                }
            });
//            FoodFragment.refreshRv_Price();

        }else {
            holder.price_cv.setVisibility(View.INVISIBLE);



        }

    }

    // Datamızın boyutu
    @Override
    public int getItemCount() {
        return FoodFragment.carts.size();
    }
}
