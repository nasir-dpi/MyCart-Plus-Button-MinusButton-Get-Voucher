package com.example.mycart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BottomSheet_RecyclerAdapter extends RecyclerView.Adapter<BottomSheet_RecyclerAdapter.RecyclerViewHolder> {

    private Context context;
    private List<Bottomsheet_recycler_design_childClass> productList;

    public BottomSheet_RecyclerAdapter(Context context, List<Bottomsheet_recycler_design_childClass> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.bottom_sheet_recyler_layout,null);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        final Bottomsheet_recycler_design_childClass bottomsheet_recycler_design_childClass = productList.get(position);
        //Bottomsheet_recycler_design_childClass design = productList.get(position);
        holder.image.setImageDrawable(context.getResources().getDrawable(bottomsheet_recycler_design_childClass.image));
        holder.title.setText(bottomsheet_recycler_design_childClass.title);
        holder.shoerdesc.setText(bottomsheet_recycler_design_childClass.shortdesc);
        holder.price.setText(bottomsheet_recycler_design_childClass.price);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,shoerdesc,price;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.text_view_title);
            shoerdesc = itemView.findViewById(R.id.text_view_short_desc);
            price = itemView.findViewById(R.id.text_view_price);
        }
    }
}
