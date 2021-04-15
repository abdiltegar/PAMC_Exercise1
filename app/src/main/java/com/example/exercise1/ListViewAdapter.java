package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variable dengan jenis data context
    Context mContext;

    //Deklarasi variable dengan jenis data Layout inflater
    LayoutInflater inflater;

    //Deklarasi variable dengan jenis data arrayList
    private ArrayList<ClassNama> arrayList;
    private ArrayList<ClassNama> arraylistfiltered;  // for loading  filter data

    public ListViewAdapter(Context context){
        //memberi nilai mContext dengan context
        mContext = context;

        //mengatur Layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arraylist dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua elemen ke arrayList
        this.arrayList.addAll(Home_Activity.classNamaArrayList);

        this.arraylistfiltered = arrayList;
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //Fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        //cek kondisi apakah view null atau tidak
        if (view == null){
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk TextView
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpa data dalam tampilkan tanpa menggunakan struktur data lain
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        return view;
    }

    // put below code (method) in Adapter class
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = arrayList.size();
                    filterResults.values = arrayList;
                }else{
                    List<ClassNama> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(ClassNama itemsModel:arrayList){
                        if(itemsModel.getName().toLowerCase().contains(searchStr.toLowerCase())){
                            resultsModel.add(itemsModel);
                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                Home_Activity.classNamaArrayList = (ArrayList<ClassNama>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}