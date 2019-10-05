package com.example.mycart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;
    //static int count =0;


    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        final Product product = productList.get(position);
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        // holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));
        //holder.counterText.setText(String.valueOf(getItemCount()));

        holder.count.setText(String.valueOf(product.getCount()));
        holder.plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setCount(product.getCount() + 1);
                holder.count.setText(String.valueOf(product.getCount()));
                //product.setCount(product.getCount() + 1);
               //holder.count.setText(String.valueOf(product.getCount()+1));
                // product.setCount(product.getCount() + 1);
                //holder.count.setText(product.getCount());
            }
        });

        holder.minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (product.getCount() > 1) {
                    product.setCount(product.getCount() - 1);
                    holder.count.setText(String.valueOf(product.getCount()));
                    //product.setCount(product.getCount() - 1);
                    //holder.count.setText(String.valueOf(product.getCount()-1));
                    //product.setCount(product.getCount() - 1);
                    //holder.count.setText(product.getCount());
                }
            }
        });

        holder.getBoucherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetClass bottomSheet = new BottomSheetClass();
                bottomSheet.show(((AppCompatActivity) context).getSupportFragmentManager(),"bottomSheetClass");


            }
        });


    }

    @Override
    public int getItemCount() {

        return productList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewPrice, count;
        AppCompatCheckBox checkBox;
        Button minusbtn, plusbtn ,getBoucherbtn;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitleid);
            textViewDesc = itemView.findViewById(R.id.textViewShortDescid);
            // textViewRating =itemView.findViewById(R.id.textViewRatingid);
            textViewPrice = itemView.findViewById(R.id.textViewPriceid);
            count = itemView.findViewById(R.id.counter_text);
            checkBox = itemView.findViewById(R.id.checkid);
            minusbtn = itemView.findViewById(R.id.minusbtn);
            plusbtn = itemView.findViewById(R.id.plusbtn);
            getBoucherbtn=itemView.findViewById(R.id.btngetVoucherClick);




        }


    }

}
