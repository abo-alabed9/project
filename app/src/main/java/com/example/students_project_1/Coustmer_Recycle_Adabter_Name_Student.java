package com.example.students_project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.students_project_1.models.Students;

import java.util.ArrayList;

public class Coustmer_Recycle_Adabter_Name_Student extends RecyclerView.Adapter<Coustmer_Recycle_Adabter_Name_Student.MyHolder> {

    Context context;
    ArrayList<Students>data;

    public Coustmer_Recycle_Adabter_Name_Student(Context context, ArrayList<Students> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_name_students,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.cb_name_student.setText(data.get(position).getFirst_Name());
        holder.cb_name_student.setText(data.get(position).getLast_Name());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CheckBox cb_name_student;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            cb_name_student=itemView.findViewById(R.id.cb_name_student);
        }
    }
}
