package com.example.ahmetserdargeze.ikasbreakfastproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Cart;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu;
import com.example.ahmetserdargeze.ikasbreakfastproject.recyclerview.Adapter;
import com.example.ahmetserdargeze.ikasbreakfastproject.recyclerview.PriceAdapter;
import com.example.ahmetserdargeze.ikasbreakfastproject.retrofit.APIService;
import com.example.ahmetserdargeze.ikasbreakfastproject.retrofit.ApiUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class FoodFragment  extends Fragment {

    public static TextView rate_tax_tv,total_tax_tv,payment_tv,total_price_tv;
    public LinearLayout payment_ll;
    Button clearcart;

    RecyclerView rv;
    public static RecyclerView rv_price;

    public static List<Menu> dataset=new ArrayList<>();


    public static List<Cart> carts=new ArrayList<>();



    public static RecyclerView.Adapter mAdapter;
    public static RecyclerView.Adapter priceAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static RecyclerView.LayoutManager priceLayoutManager;



    public APIService downloadService;
    ArrayList<Menu> result=new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.foodfragment,container,false);

        rate_tax_tv=view.findViewById(R.id.rate_tax_tv);
        total_tax_tv=view.findViewById(R.id.total_tax_tv);
        payment_tv=view.findViewById(R.id.payment_tv);
        total_price_tv=view.findViewById(R.id.total_price_tv);
        payment_ll=view.findViewById(R.id.payment_ll);

        payment_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carts.size()!=0){
                    Toast.makeText(getContext(),"Payment Process is Succesfuly",Toast.LENGTH_LONG).show();
                    FoodFragment.clearCart();
                }else {
                    Toast.makeText(getContext(),"Error!! Cart is Empty",Toast.LENGTH_LONG).show();

                }

            }
        });

        downloadService= ApiUtils.getAPIServicewithAuth();
        downloadService.getMenu().enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                dataset=response.body();
                System.out.println(dataset.get(0).getImageUrl());


                rv = (RecyclerView) view.findViewById(R.id.my_recycler_view);
                mLayoutManager=new GridLayoutManager(getContext(),3);

                rv.setLayoutManager(mLayoutManager);
                rv.setHasFixedSize(true);


                // Adapter olusturup RecyclerView'a ekliyoruz



                mAdapter = new Adapter(dataset,getContext());
                rv.setAdapter(mAdapter);


                rv_price=(RecyclerView) view.findViewById(R.id.price_rv);
                priceLayoutManager=new GridLayoutManager(getContext(),1);
                rv_price.setLayoutManager(priceLayoutManager);
                rv.setHasFixedSize(true);
                priceAdapter=new PriceAdapter();
                rv_price.setAdapter(priceAdapter);

            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Log.i("error","hatavar"+t.getCause());

            }
        });

        clearcart=view.findViewById(R.id.clear_cart_bt);
        clearcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCart();

            }
        });








        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public static void refreshRv_Price(){
        priceAdapter=new PriceAdapter();
        rv_price.setLayoutManager(priceLayoutManager);
        rv_price.setAdapter(priceAdapter);
        rv_price.invalidate();




    }

    public static double totalAmaunt(){
        double price=0;
        for (int i=0;i<FoodFragment.carts.size();i++){
            price=price+carts.get(i).getTotal_price();
        }
        return price;
    }

    public static double totalTax() {
        double totaltax = 0;
        for (int i = 0; i < FoodFragment.carts.size(); i++) {
            totaltax = totaltax + (carts.get(i).getDiffer_tax()*carts.get(i).getQuantity());
        }
        return totaltax;
    }

    public static double taxRate(){
        double rate=0;
        rate=(100*totalTax())/(totalAmaunt());
        return rate;

    }

    public static void clearCart(){
        carts.clear();
        refreshRv_Price();
        total_price_tv.setText("0.0tl");
        total_tax_tv.setText("0.0tl");
        rate_tax_tv.setText("%0.0");

    }

    public static void clearOneRow(int index){
        carts.remove(index);
        refreshRv_Price();
        rate_tax_tv.setText("%" +new DecimalFormat("##.##").format(FoodFragment.taxRate()));
        total_tax_tv.setText(new DecimalFormat("##.##").format(FoodFragment.totalTax())+"tl");
        total_price_tv.setText(FoodFragment.totalAmaunt()+"tl");

    }




    }




