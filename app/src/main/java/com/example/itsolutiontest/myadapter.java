package com.example.itsolutiontest;




import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.nameTextView.setText(dataholder.get(position).getMemberMobileNumber());
        holder.mobileTextView.setText(dataholder.get(position).getContact());
        holder.roleTextView.setText(dataholder.get(position).getRole());
        holder.subscriptionTextView.setText(dataholder.get(position).getSubscriptionFee());
        holder.depositAmountTextView.setText(dataholder.get(position).getDepositAmount());
        holder.loanAmountTextView.setText(dataholder.get(position).getLoanAmount());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView mobileTextView;
        private TextView roleTextView;
        private TextView subscriptionTextView;
        private TextView depositAmountTextView;
        private TextView loanAmountTextView;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            mobileTextView = itemView.findViewById(R.id.Mobile);
            roleTextView = itemView.findViewById(R.id.Member);
            subscriptionTextView = itemView.findViewById(R.id.subscription);
            depositAmountTextView = itemView.findViewById(R.id.depositAmount);
            loanAmountTextView=itemView.findViewById(R.id.loanAmount);

        }
    }
}
