package com.example.students_project_1.datebase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.students_project_1.models.Admin;
import com.example.students_project_1.models.Presence;
import com.example.students_project_1.models.Students;
import com.example.students_project_1.models.Subject_Student;
import com.example.students_project_1.models.Subjects;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "Student", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Admin.CREATE_TABLE);
        sqLiteDatabase.execSQL(Presence.CREATE_TABLE);
        sqLiteDatabase.execSQL(Students.CREATE_TABLE);
        sqLiteDatabase.execSQL(Subject_Student.CREATE_TABLE);
        sqLiteDatabase.execSQL(Subjects.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + Admin.TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + Presence.TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + Students.TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + Subject_Student.TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + Subjects.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //--------------------------------------------------------------------------------
    //------------------------------Table Admin
    public boolean insertAdmin(String user_name, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Admin.COL_USER_NAME, user_name);
        values.put(Admin.COL_EMAIL, email);
        values.put(Admin.COL_PASSWORD, password);
        long row = db.insert(Admin.TABLE_NAME, null, values);
        return row > 0;
    }

    public boolean updateAdmin(String id, String user_name, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Admin.COL_USER_NAME, user_name);
        values.put(Admin.COL_EMAIL, email);
        values.put(Admin.COL_PASSWORD, password);
        int rowId = db.update(Admin.TABLE_NAME, values, Admin.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public boolean deleteAdmin(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int rowId = db.delete(Admin.TABLE_NAME, Admin.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }


    public ArrayList<Admin> getAllAdmin() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Admin> data = new ArrayList<>();
        String query = " SELECT * FROM " + Admin.TABLE_NAME + " ORDER BY " + Admin.COL_ID + " DESC ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Admin.COL_ID));
                String user_name = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_USER_NAME));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_EMAIL));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_PASSWORD));
                Admin admin = new Admin(id, user_name, email, password);
                data.add(admin);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return data;
    }


    public ArrayList<Admin> getAllAdmibyUserName(String userName) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Admin> data = new ArrayList<>();
        String query = " SELECT * FROM " + Admin.TABLE_NAME + " WHERE " + Admin.COL_USER_NAME + " LIKE '%' || ? || '%' ";
        Cursor cursor = db.rawQuery(query, new String[]{userName});
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Admin.COL_ID));
                String user_name = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_USER_NAME));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_EMAIL));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_PASSWORD));
                Admin admin = new Admin(id, user_name, email, password);
                data.add(admin);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return data;
    }

    public ArrayList<Admin> getAdmin_User_Email(String userName) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Admin> data = new ArrayList<>();
        String query = " SELECT * FROM " + Admin.TABLE_NAME + " WHERE " + Admin.COL_USER_NAME + " LIKE '%' || ? || '%' ";
        Cursor cursor = db.rawQuery(query, new String[]{userName});
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Admin.COL_ID));
                String user_name = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_USER_NAME));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_EMAIL));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(Admin.COL_PASSWORD));
                Admin admin = new Admin(id, user_name, email, password);
                data.add(admin);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return data;
    }


    //-------------------------------------------------------------------------------------------
    //-------------------------------------Table Presence
    public boolean insertPresence(String month, String day, int student_id, int subject_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Presence.COL_MONTH, month);
        values.put(Presence.COL_DAY, day);
        values.put(Presence.COL_STUDENT_ID, student_id);
        values.put(Presence.COL_SUBJECT_ID, subject_id);
        long row = db.insert(Presence.TABLE_NAME, null, values);
        return row > 0;
    }

    public boolean updeatePresence(String id, String month, String day, int student_id, int subject_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Presence.COL_MONTH, month);
        values.put(Presence.COL_DAY, day);
        values.put(Presence.COL_STUDENT_ID, student_id);
        values.put(Presence.COL_SUBJECT_ID, subject_id);
        int rowId = db.update(Presence.TABLE_NAME, values, Presence.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public boolean deletePresence(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int rowId = db.delete(Presence.TABLE_NAME, Presence.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public ArrayList<Presence> getAllPresence() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Presence> data = new ArrayList<>();
        String query = " SELECT * FROM " + Presence.TABLE_NAME + " ORDER BY " + Presence.COL_ID + " DESC ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Presence.COL_ID));
                String month = cursor.getString(cursor.getColumnIndexOrThrow(Presence.COL_MONTH));
                String day = cursor.getString(cursor.getColumnIndexOrThrow(Presence.COL_DAY));
                int student_id = cursor.getInt(cursor.getColumnIndexOrThrow(Presence.COL_STUDENT_ID));
                int subject_id = cursor.getInt(cursor.getColumnIndexOrThrow(Presence.COL_SUBJECT_ID));
                Presence presence = new Presence(id, month, day, student_id, subject_id);
                data.add(presence);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return data;
    }
    //-------------------------------------------------------------------------------
    // -----------------------------------Table Students

    public boolean insertStudents(String first_Name, String last_Name, int birthdate) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Students.COL_FIRST_NAME, first_Name);
        values.put(Students.COL_LAST_NAME, last_Name);
        values.put(Students.COL_BIRTHDATE, birthdate);
        long row = db.insert(Students.TABLE_NAME, null, values);
        return row > 0;
    }

    public boolean updeateStudents(String id, String first_Name, String last_Name, int birthdate) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Students.COL_FIRST_NAME, first_Name);
        values.put(Students.COL_LAST_NAME, last_Name);
        values.put(Students.COL_BIRTHDATE, birthdate);
        int rowId = db.update(Students.TABLE_NAME, values, Students.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public boolean deleteStudents(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int rowId = db.delete(Students.TABLE_NAME, Students.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public ArrayList<Students> getAllStudents() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Students> data = new ArrayList<>();
        String query = " SELECT * FROM " + Students.TABLE_NAME + " ORDER BY " + Students.COL_ID + " DESC ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Students.COL_ID));
                String first_Name = cursor.getString(cursor.getColumnIndexOrThrow(Students.COL_FIRST_NAME));
                String last_Name = cursor.getString(cursor.getColumnIndexOrThrow(Students.COL_LAST_NAME));
                int birthdate = cursor.getInt(cursor.getColumnIndexOrThrow(Students.COL_BIRTHDATE));
                Students students = new Students(id, first_Name, last_Name, birthdate);
                data.add(students);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return data;
    }

    //---------------------------------------------------------------------------------------
    // ---------------------------Table Subject_Student

    public boolean insertSubject_Student(int student_id, int subject_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Subject_Student.COL_STUDENT_ID, student_id);
        values.put(Subject_Student.COL_SUBJECT_ID, subject_id);
        long row = db.insert(Subject_Student.TABLE_NAME, null, values);
        return row > 0;
    }

    public boolean updeateSubject_Student(String id, int student_id, int subject_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Subject_Student.COL_STUDENT_ID, student_id);
        values.put(Subject_Student.COL_SUBJECT_ID, subject_id);
        int rowId = db.update(Subject_Student.TABLE_NAME, values, Subject_Student.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public boolean deleteSubject_Student(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int rowId = db.delete(Subject_Student.TABLE_NAME, Subject_Student.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public ArrayList<Subject_Student> getAllSubject_Student() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Subject_Student> data = new ArrayList<>();
        String query = " SELECT * FROM " + Subject_Student.TABLE_NAME + " ORDER BY " + Subject_Student.COL_ID + " DESC ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Subject_Student.COL_ID));
                int student_id = cursor.getInt(cursor.getColumnIndexOrThrow(Subject_Student.COL_STUDENT_ID));
                int subject_id = cursor.getInt(cursor.getColumnIndexOrThrow(Subject_Student.COL_SUBJECT_ID));
                Subject_Student subject_student = new Subject_Student(id, student_id, subject_id);
                data.add(subject_student);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return data;
    }
    //---------------------------------------------------------------------------------------
    //---------------------------------Table Subjects

    public boolean insertSubjects(String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Subjects.COL_NAME, name);
        long row = db.insert(Subjects.TABLE_NAME, null, values);
        return row > 0;
    }

    public boolean updeateSubject_Student(String id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Subjects.COL_NAME, name);
        int rowId = db.update(Subjects.TABLE_NAME, values, Subjects.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public boolean deleteSubjects(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int rowId = db.delete(Subjects.TABLE_NAME, Subjects.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public ArrayList<Subjects> getAllSubjects() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Subjects> data = new ArrayList<>();
        String query = " SELECT * FROM " + Subjects.TABLE_NAME + " ORDER BY " + Subjects.COL_ID + " DESC ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Subjects.COL_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(Subjects.COL_NAME));
                Subjects subjects = new Subjects(id, name);
                data.add(subjects);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return data;
    }
    //----------------------------------------------------------------------------------------------------------


}
