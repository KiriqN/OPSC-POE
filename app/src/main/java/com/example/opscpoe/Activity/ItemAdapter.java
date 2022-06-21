package com.example.opscpoe.Activity;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.opscpoe.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<String> items;
    private ItemViewHolder.OnNoteListener mOnNoteListener;
    public ProgressBar progressBar;


    recycler_view_interface view_interface;

    public ItemAdapter(List<String> items, recycler_view_interface _interface) {
        this.items = items;
        this.view_interface = _interface;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view, mOnNoteListener, view_interface).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.textView.setText(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView textView;
    private ItemAdapter adapter;
    OnNoteListener onNoteListener;

    public String name_data;

    public ItemViewHolder(@NonNull View itemView, OnNoteListener onNoteListener, recycler_view_interface view_interface) {
        super(itemView);






        itemView.setOnClickListener(new View.OnClickListener() {//------I moved ot here outside that so its added in creation
            @Override
            public void onClick(View view) {



                if (view_interface != null) {

                    int index = getAdapterPosition();

                    if (index != RecyclerView.NO_POSITION) {

                        view_interface.row_click_reciever(index);

                    }


                }
            }
        });


        textView = itemView.findViewById(R.id.text);
        itemView.findViewById(R.id.delete).setOnClickListener(view -> {//-------the on click for the delete button


            //-----Your on click was here--------

            this.onNoteListener = onNoteListener;
            adapter.items.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());


        });

    }

    @Override
    public void onClick(View v) {
        onNoteListener.onNoteClick(getAdapterPosition());
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    public ItemViewHolder linkAdapter(ItemAdapter adapter){
        this.adapter = adapter;
        return this;
    }






}
