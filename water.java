package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class water extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener{
    private TextView output;
    private TextView output2;
    private Calendar dt = Calendar.getInstance();
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        output = (TextView) findViewById(R.id.IbIOutput);
        output2 = (TextView) findViewById(R.id.IbIOutput2);
    }
    @Override
    public void onDateSet (DatePicker datePicker, int y, int m, int d){
        output.setText("日期:" + y + "/" + (m + 1) + "/" + d);
    }
    @Override
    public void onTimeSet (TimePicker timePicker, int h, int m){
        output2.setText("時間:" + h + ":" + m);
    }
    public void button_Click (View view){
        DatePickerDialog dlg = new DatePickerDialog(this, this,
                dt.get(Calendar.YEAR),
                dt.get(Calendar.MONTH),
                dt.get(Calendar.DAY_OF_MONTH));
        dlg.show();
    }
    public void button2_Click (View view){
        TimePickerDialog dlg = new TimePickerDialog(this,this,
                dt.get(Calendar.HOUR),
                dt.get(Calendar.MINUTE),true);
        dlg.show();
    }
    public void button3_Click(View view) {
        EditText name=(EditText)findViewById(R.id.editTextTextPersonName2);//姓名
        String str = name.getText().toString();
        EditText Ml=(EditText)findViewById(R.id.editTextNumber);//目標水量
        int tmp=Integer.parseInt(Ml.getText().toString());
        int water = 0; //水量選擇
        CheckBox one =(CheckBox)findViewById(R.id.checkBox100);
        if(one.isChecked())
            water+=100;
        CheckBox two =(CheckBox)findViewById(R.id.checkBox200);
        if (two.isChecked())
            water+=200;
        CheckBox three =(CheckBox)findViewById(R.id.checkBox300);
        if(three.isChecked())
            water+=300;
        CheckBox four =(CheckBox)findViewById(R.id.checkBox400);
        if(four.isChecked())
            water+=400;
        CheckBox five =(CheckBox)findViewById(R.id.checkBox500);
        if(five.isChecked())
            water+=500;
        CheckBox six =(CheckBox)findViewById(R.id.checkBox600);
        if(five.isChecked())
            water+=600;
        int w = tmp-water;


        if(w>0){
            TextView output = (TextView) findViewById(R.id.lblOutput3);
            output.setText(str+"，您離今日喝水量還差"+w+"毫升(ml)，請立刻拿起你的水壺大飲一口");
        }
        else{
            TextView output = (TextView) findViewById(R.id.lblOutput3);
            output.setText(str+"，您今日水已經喝夠多了，請遠離你的水壺或是繼續增加本日飲水量");
        }

    }
    public void button4_Click(View view) {
        TextView output = (TextView) findViewById(R.id.IbIOutput);
        output.setText("");
        TextView output1 = (TextView) findViewById(R.id.editTextTextPersonName2);
        output1.setText("");
        TextView output2 = (TextView) findViewById(R.id.editTextNumber);
        output2.setText("");
        TextView output3 = (TextView) findViewById(R.id.IbIOutput2);
        output3.setText("");
        TextView output4 = (TextView) findViewById(R.id.lblOutput3);
        output4.setText("");
    }
    public void button7_Click(View view){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}