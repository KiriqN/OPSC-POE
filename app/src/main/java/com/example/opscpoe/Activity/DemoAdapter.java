package com.example.opscpoe.Activity;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.opscpoe.R;

import org.w3c.dom.Text;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoVH> {

    List<String> items;
    private DemoVH.OnNoteListener mOnNoteListener;

    recycler_view_interface view_interface;

    public DemoAdapter(List<String> items, recycler_view_interface _interface) {
        this.items = items;
        this.view_interface = _interface;

    }

    @NonNull
    @Override
    public DemoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new DemoVH(view, mOnNoteListener, view_interface).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoVH holder, int position) {

        holder.textView.setText(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class DemoVH extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView textView;
    private DemoAdapter adapter;
    OnNoteListener onNoteListener;

    public String name_data;

    public DemoVH(@NonNull View itemView, OnNoteListener onNoteListener, recycler_view_interface view_interface) {
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

    public DemoVH linkAdapter(DemoAdapter adapter){
        this.adapter = adapter;
        return this;
    }




}
