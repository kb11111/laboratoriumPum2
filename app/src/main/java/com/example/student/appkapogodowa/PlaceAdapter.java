package com.example.student.appkapogodowa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Katarzyna on 28.12.2017.
 */


    public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

        private ArrayList<Place> places = new ArrayList<>();

        PlaceAdapter(ArrayList<Place> places) {
            this.places = places;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, null);
            return new ViewHolder(itemLayoutView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.setPlace_name(places.get(position).getPlaceName());
            holder.setInfo(places.get(position).getInformation() + "");

        }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.place_name)
            String place_name;

            @BindView(R.id.info)
            String info;
        @OnClick(R.id.place_select)
        void selectPlace() {

            openAlertDialog();
        }

        public void setPlace_name(String place_name) {
            this.place_name = place_name;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        private void openAlertDialog() {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(itemView.getContext(), android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(itemView.getContext());
            }
            builder.setTitle("Czy dobrze wybrałeś?")
                    .setMessage("Może wybierzesz jeszcze raz?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //n
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
