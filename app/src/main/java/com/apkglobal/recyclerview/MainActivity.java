package com.apkglobal.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Myadapter myadapter = new Myadapter();
        recyclerView.setAdapter(myadapter);
    }

    private class Myadapter extends RecyclerView.Adapter<Myholder> {
        List<Data> dataList;

        public Myadapter() {
            dataList = new ArrayList<>();
            Data data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);

            data = new Data();
            data.setB(true);
            dataList.add(data);
        }

        @NonNull
        @Override
        public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            Myholder myholder = new Myholder(view);
            return myholder;
        }

        @Override
        public void onBindViewHolder(@NonNull final Myholder holder, final int position) {
            Data data = dataList.get(position);
            holder.checkBox.setChecked(data.isB());

            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position)
                    {
                        case 0:
                            if (holder.checkBox.isChecked()==false)
                            {
                               Intent intent=new Intent(MainActivity.this,
                                       Main2Activity.class);
                               startActivity(intent);
                                  }
                            break;

                        case 1:
                            Toast.makeText(MainActivity.this,
                                    "click done", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

    private class Myholder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public Myholder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }
}
