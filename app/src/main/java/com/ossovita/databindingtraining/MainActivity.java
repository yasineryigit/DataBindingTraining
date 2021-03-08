package com.ossovita.databindingtraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ossovita.databindingtraining.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding amb;
    private MainActivityClickHandler handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amb = DataBindingUtil.setContentView(this,R.layout.activity_main);
        amb.setStudent(getCurrentStudent());

        handlers = new MainActivityClickHandler(this);
        amb.setClickHandler(handlers);
    }

    private Student getCurrentStudent(){
        Student student = new Student();
        student.setStudentName("Mike");
        student.setStudentEmail("mike@gmail.com");
        return student;
    }

    public class MainActivityClickHandler{
        Context context;

        public MainActivityClickHandler(Context context) {
            this.context = context;
        }

        public void onEnrollButtonClicked(){
            Toast.makeText(context, "Enroll clicked", Toast.LENGTH_SHORT).show();
        }
        public void onCancelButtonClicked(){
            Toast.makeText(context, "Cancel clicked", Toast.LENGTH_SHORT).show();

        }
    }


}