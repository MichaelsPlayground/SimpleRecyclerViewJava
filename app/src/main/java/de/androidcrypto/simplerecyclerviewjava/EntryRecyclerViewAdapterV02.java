package de.androidcrypto.simplerecyclerviewjava;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EntryRecyclerViewAdapterV02 extends RecyclerView.Adapter<EntryRecyclerViewAdapterV02.ViewHolder>{

    @NonNull
    @Override
    public EntryRecyclerViewAdapterV02.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull EntryRecyclerViewAdapterV02.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // add the inner class ViewHolder manually
    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
