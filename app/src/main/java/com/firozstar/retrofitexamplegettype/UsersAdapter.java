package com.firozstar.retrofitexamplegettype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    Context context;
    List<UserListResponse> userListResponseList;

    public UsersAdapter(Context context, List<UserListResponse> userListResponseList){
        this.context = context;
        this.userListResponseList = userListResponseList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_list_items, null);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, final int position) {
        // set the data
        holder.name.setText("Name: " + userListResponseList.get(position).getName());
        holder.email.setText("Email: " + userListResponseList.get(position).getEmail());
        // implement setONCLickListtener on itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a toast with user name
                Toast.makeText(context,userListResponseList.get(position).getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userListResponseList.size(); // size of the list items
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{

        // init the item view's
        TextView name, email;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);

            // get the reference of item view's
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
