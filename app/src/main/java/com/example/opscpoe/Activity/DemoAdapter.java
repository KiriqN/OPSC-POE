package com.example.opscpoe.Activity;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.opscpoe.R;

import org.w3c.dom.Text;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoVH> {

    List<String> items;
    private DemoVH.OnNoteListener mOnNoteListener;

    public DemoAdapter(List<String> items, DemoVH.OnNoteListener onNoteListener) {
        this.items = items;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public DemoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new DemoVH(view, mOnNoteListener).linkAdapter(this);
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

    public DemoVH(@NonNull View itemView, OnNoteListener onNoteListener) {
        super(itemView);

        textView = itemView.findViewById(R.id.text);
        itemView.findViewById(R.id.delete).setOnClickListener(view -> {

            this.onNoteListener = onNoteListener;
            adapter.items.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());

            itemView.setOnClickListener(this);
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
