package prom.jhsmile.com.promapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import prom.jhsmile.com.promapp.R;
import prom.jhsmile.com.promapp.model.ProductOfert;

/**
 * Created by jhdev on 11-11-17.
 */

public class ProductItemListAdapter extends RecyclerView.Adapter<ProductItemListAdapter.ViewHolder> implements View.OnClickListener{
    private Context mContext;
    private ArrayList<ProductOfert> mDataset;
    private View.OnClickListener listener;


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        ImageView mImgtView;
        TextView mDescription;
        ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.title);
            mImgtView = (ImageView) v.findViewById(R.id.image);
            mDescription = (TextView) v.findViewById(R.id.description);
        }
    }

    public ProductItemListAdapter(Context context, ArrayList<ProductOfert> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public ProductItemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_product_item_list, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).getTitle());
        holder.mDescription.setText(mDataset.get(position).getDescription());
        Glide.with(mContext)
                .load(mDataset.get(position).getImageUrl())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mImgtView);

    }
    
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;

    }
    @Override
    public void onClick(View v) {
      if (this.listener != null) {
         listener.onClick(v);
      }
    }
}
