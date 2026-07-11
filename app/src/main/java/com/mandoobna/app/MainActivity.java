package com.mandoob.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> ordersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerOrders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ordersList = new ArrayList<>();
        ordersList.add("طلب رقم 1001 - قيد الانتظار");
        ordersList.add("طلب رقم 1002 - تم التسليم");
        ordersList.add("طلب رقم 1003 - جاري التوصيل");
        ordersList.add("طلب رقم 1004 - ملغي");

        recyclerView.setAdapter(new OrdersAdapter());
    }

    class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {

        @Override
        public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new OrderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(OrderViewHolder holder, int position) {
            holder.textView.setText(ordersList.get(position));
        }

        @Override
        public int getItemCount() {
            return ordersList.size();
        }

        class OrderViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public OrderViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
