package de.androidcrypto.simplerecyclerviewjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class EntryRecyclerViewAdapter extends RecyclerView.Adapter<EntryRecyclerViewAdapter.ViewHolder>{

    // step 1 define the variables needed
    private List<EntryModel> entryList;
    Context context;

    // step 2 define a constructor
    public EntryRecyclerViewAdapter(List<EntryModel> entryList, Context context) {
        this.entryList = entryList;
        this.context = context;
    }

    @NonNull
    @Override
    public EntryRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // step 4 bind the single_entry.xml with our recyclerView
        return new EntryRecyclerViewAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_entry, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EntryRecyclerViewAdapter.ViewHolder holder, int position) {
        // step 5 bind the data of each element to a single_entry
        // setting data to our text views from our modal class.
        EntryModel entryModel = entryList.get(position);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        String entryTime  = dateFormat.format(entryModel.getTimestamp());
        holder.entryTitle.setText(entryModel.getTitle());
        holder.entryUrl.setText(entryModel.getUrl());
        holder.entryTimestamp.setText(entryTime);

        // step 6 add a onClickListener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do your jobs
                int actualPosition = holder.getAdapterPosition();
                Toast.makeText(context,
                        "click on entry " + actualPosition + " (number - 1)",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // step 4 return the size of our entryList
        return entryList.size();
    }

    // add the inner class ViewHolder manually
    class ViewHolder extends RecyclerView.ViewHolder {
        // step 3 creating variables for our text views.
        private final TextView entryTitle;
        private final TextView entryUrl;
        private final TextView entryTimestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            entryTitle = itemView.findViewById(R.id.tvEntryTitle);
            entryUrl = itemView.findViewById(R.id.tvEntryUrl);
            entryTimestamp = itemView.findViewById(R.id.tvEntryTimestamp);
        }
    }
}
