package com.example.students_project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.students_project_1.datebase.DbHelper;
import com.example.students_project_1.models.Students;

import java.util.ArrayList;

public class Coustmer_Recycle_Adabter_all_Student extends RecyclerView.Adapter<Coustmer_Recycle_Adabter_all_Student.MyHolder> {

    Context context;
    ArrayList<Students> data;
    onItemClickListener listener;
    DbHelper dbHelper;

    public Coustmer_Recycle_Adabter_all_Student(Context context, ArrayList<Students> data, onItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
        this.dbHelper=dbHelper;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_all_student, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.tv_nameStudent.setText(data.get(position).getFirst_Name());
        holder.tv_nameStudent.setText(data.get(position).getLast_Name());
        holder.img_deleteStudent.setImageResource(data.get(position).getImg());

        holder.img_deleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDeleteClick(holder.getAdapterPosition());
            }
        });
        holder.tv_nameStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(holder.getAdapterPosition(),holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_nameStudent;
        ImageView img_deleteStudent;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tv_nameStudent = itemView.findViewById(R.id.tv_Student_name);
            img_deleteStudent = itemView.findViewById(R.id.img_delete_Student);
        }
    }

    interface onItemClickListener {
        void onClick(int students, int position);

        void onDeleteClick(int position);
    }
}
