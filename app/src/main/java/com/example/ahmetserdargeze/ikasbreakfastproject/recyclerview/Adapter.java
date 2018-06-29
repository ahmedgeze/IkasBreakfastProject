package com.example.ahmetserdargeze.ikasbreakfastproject.recyclerview;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ahmetserdargeze.ikasbreakfastproject.FoodFragment;
import com.example.ahmetserdargeze.ikasbreakfastproject.R;
import com.example.ahmetserdargeze.ikasbreakfastproject.RecyclerViewClickListener;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Cart;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {

    Button calculator;
    TextView dialog_koin,dialog_kur,dialog_result;
    ImageView dialog_exit;
    Spinner quantity,type;

    Adapter.ViewHolder holder;



    public   List<Menu> mDataset;
    public static Context context;
    private static RecyclerViewClickListener itemListener;

    public static int x;

    public Adapter(List<Menu> mDataset,Context context) {
        this.mDataset = mDataset;
        this.context=context;
    }

    public Adapter() {
    }

    public List<Menu> getmDataset() {
        return mDataset;
    }

    public  void setmDataset(List<Menu> mDataset) {
        this.mDataset = mDataset;
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        LinearLayout food_ll;
        TextView name,price ;
        ImageView pic;


        public ViewHolder(View v) {
            super(v);
            food_ll=(LinearLayout) v.findViewById(R.id.food_parent_ll) ;
            pic=(ImageView) v.findViewById(R.id.food_iv);
            name=(TextView) v.findViewById(R.id.food_name_tv);
            price=(TextView) v.findViewById(R.id.food_price_tv);





        }

    }





    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.foodcardview,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;



    }




        @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder, int position) {
        this.holder=holder;

        switch (mDataset.get(position).getName().toString()){
            case "Ayran":
                holder.pic.setImageResource(R.drawable.ayran);
                break;
            case "Cacık":
                holder.pic.setImageResource(R.drawable.cacik);
                break;
            case "Cam Şişe Doğal Su":
                holder.pic.setImageResource(R.drawable.camsisesu);
                break;
            case "Sade Soda":
                holder.pic.setImageResource(R.drawable.soda);
                break;

            case "Şalgam":
                holder.pic.setImageResource(R.drawable.salgam);
                break;
            case "Çorba":
                holder.pic.setImageResource(R.drawable.corba);
                break;
            case "İrmik Helvası":
                holder.pic.setImageResource(R.drawable.irmikhelvasi);
                break;
            case "Kavurma":
                holder.pic.setImageResource(R.drawable.kavurma);
                break;


            case "Kuru Fasulye":
                holder.pic.setImageResource(R.drawable.kurufasulye);
                break;
            case "Kutu İçecekler":
                holder.pic.setImageResource(R.drawable.kutuicecek);
                break;
            case "Pet Şişe Su":
                holder.pic.setImageResource(R.drawable.petsisesu);
                break;

            case "Pilav":
                holder.pic.setImageResource(R.drawable.pilav);
                break;
            case "Salata":
                holder.pic.setImageResource(R.drawable.salata);
                break;
            case "Şişe İçecekler":
                holder.pic.setImageResource(R.drawable.siseicecek);
                break;
            case "Yoğurt":
                holder.pic.setImageResource(R.drawable.yogurt);
                break;

        }

        holder.price.setText(mDataset.get(position).getSellPrice().toString());
        holder.name.setText(mDataset.get(position).getName());

        holder.food_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=holder.getLayoutPosition();
                System.out.println(holder.name.getText());
                System.out.println(x);
                System.out.println(mDataset.get(x).getName());

                final Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.dialog_layout);

                dialog.setTitle("Exchange Rate Calculator");

                calculator=(Button) dialog.findViewById(R.id.add_chart);
//                dialog_koin=(TextView) dialog.findViewById(R.id.ex_dialog_coin);
                dialog_kur=(TextView) dialog.findViewById(R.id.dialog_welcome_tv);
                dialog_result=(TextView) dialog.findViewById(R.id.dialog_quantity_tv);
                dialog_exit=(ImageView) dialog.findViewById(R.id.custom_exit);
                quantity=(Spinner) dialog.findViewById(R.id.quantity_spinner);
                type=(Spinner) dialog.findViewById(R.id.type_spinner);

                List<Integer> quantity_list=new ArrayList<>();
                final List<String>  type_list=new ArrayList<>();

                for (int i=0;i<10;i++)
                    quantity_list.add(i+1);

                ArrayAdapter<Integer> dataAdapter=new ArrayAdapter<Integer>(context,R.layout.support_simple_spinner_dropdown_item,quantity_list);
                dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                quantity.setAdapter(dataAdapter);

                if (mDataset.get(x).getVariations().size()==0)
                    type_list.add("ID: "+mDataset.get(x).getId()+" "+mDataset.get(x).getName()+" "+mDataset.get(x).getSellPrice()+"TL");

                else{
                    for (int j=0;j<mDataset.get(x).getVariations().size();j++)
                        type_list.add("ID: "+mDataset.get(x).getVariations().get(j).getId()
                                +" "+mDataset.get(x).getVariations().get(j).getName()
                                +" "+mDataset.get(x).getVariations().get(j).getSellPrice()+"TL");

                }

                ArrayAdapter<String> typeAdapter=new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,type_list);
                typeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                type.setAdapter(typeAdapter);








                Window window=dialog.getWindow();
                window.setGravity(Gravity.CENTER|Gravity.TOP);
                WindowManager.LayoutParams lp=window.getAttributes();


                lp.x=100;
                lp.y=100;
                lp.width=1000;
                lp.height=1000;
                lp.alpha=0.9f;

                window.setAttributes(lp);






                calculator.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position,id=0,quantity_no=0;
                        double sell_price=0,differ_tax=0,total_price=0;
                        String name="";

                        quantity_no=Integer.parseInt(String.valueOf(quantity.getSelectedItem()));
                        if (type_list.size()==1){
                            id=mDataset.get(x).getId();
                            sell_price=mDataset.get(x).getSellPrice();
                            differ_tax=sell_price-mDataset.get(x).getSellPriceWithoutTax();
                            name=mDataset.get(x).getName();


                        }
                        else if (type_list.size()>1){
                            position=Integer.parseInt(String.valueOf(type.getSelectedItemPosition()));
                            id=mDataset.get(x).getVariations().get(position).getId();
                            sell_price=mDataset.get(x).getVariations().get(position).getSellPrice();
                            differ_tax=sell_price-mDataset.get(x).getVariations().get(position).getSellPriceWithoutTax();
                            name=mDataset.get(x).getVariations().get(position).getName();

                        }
                        total_price=quantity_no*sell_price;
                        Cart cart=new Cart(id,quantity_no,sell_price,differ_tax,name,total_price);

                        FoodFragment.carts.add(cart);

                        System.out.println("id"+FoodFragment.carts.get(FoodFragment.carts.size()-1).getId());
                        System.out.println("id"+FoodFragment.carts.get(FoodFragment.carts.size()-1).getName());
                        System.out.println("id"+FoodFragment.carts.get(FoodFragment.carts.size()-1).getSell_price());
                        System.out.println("id"+FoodFragment.carts.get(FoodFragment.carts.size()-1).getDiffer_tax());
                        System.out.println("id"+FoodFragment.carts.get(FoodFragment.carts.size()-1).getQuantity());
                        System.out.println("id"+FoodFragment.carts.get(FoodFragment.carts.size()-1).getTotal_price());


                        FoodFragment.refreshRv_Price();
                        FoodFragment.rate_tax_tv.setText("%" +new DecimalFormat("##.##").format(FoodFragment.taxRate()));
                        FoodFragment.total_tax_tv.setText(new DecimalFormat("##.##").format(FoodFragment.totalTax())+"tl");
                        FoodFragment.total_price_tv.setText(FoodFragment.totalAmaunt()+"tl");
                        dialog.cancel();

                    }
                });

                dialog_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();


                    }
                });





                dialog.show();

            }
        });

    }





    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
