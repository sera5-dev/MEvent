package com.furqoncreative.mevent.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.furqoncreative.mevent.R;
import com.furqoncreative.mevent.activity.EventDetailActivity;
import com.furqoncreative.mevent.activity.KonserDetailActivity;
import com.furqoncreative.mevent.model.Event;
import com.furqoncreative.mevent.model.Konser;
import com.squareup.picasso.Picasso;

import java.util.List;

public class KonserAdapter extends RecyclerView.Adapter<KonserAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Konser> mData ;


    public KonserAdapter(Context mContext, List<Konser> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Uri url = Uri.parse(mData.get(position).getPoster());
        Picasso.get().load(url).into(holder.img_poster);
        holder.tv_judul.setText(mData.get(position).getJudul());
        holder.tv_lokasi.setText(mData.get(position).getLokasi());
        holder.tv_tanggal.setText(mData.get(position).getTanggal());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, KonserDetailActivity.class);

                // passing data to the book activity
                intent.putExtra("Judul",mData.get(position).getJudul());
                intent.putExtra("Tanggal",mData.get(position).getTanggal());
                intent.putExtra("Lokasi",mData.get(position).getLokasi());
                intent.putExtra("Deskripsi",mData.get(position).getDeskripsi());
                intent.putExtra("Artis",mData.get(position).getArtis());
                intent.putExtra("Poster",mData.get(position).getPoster());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_judul;
        TextView tv_tanggal;
        TextView tv_lokasi;
        ImageView img_poster;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_judul = (TextView) itemView.findViewById(R.id.tv_judul) ;
            tv_tanggal = (TextView) itemView.findViewById(R.id.tv_tanggal) ;
            tv_lokasi = (TextView) itemView.findViewById(R.id.tv_lokasi) ;
            img_poster = (ImageView) itemView.findViewById(R.id.img_poster);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}