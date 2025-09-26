package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import  android.hardware.Sensor ;
import  android.hardware.SensorEvent ;
import  android.hardware.SensorEventListener ;
import  android.hardware.SensorManager ;
import  android.os.Bundle ;
import  android.view.View ;
import  android.widget.Button ;
import  android.widget.TextView ;

public  class  OpActivity extends  AppCompatActivity  implements  View . OnClickListener ,  SensorEventListener  {

    private  SensorManager  sm ;
    private  Sensor  mSensorAccelerometer ;
    private  TextView  ms_step ;
    private  Button  btn_start ;
    private  int  step  =  0 ;    //步數
    private  double  oriValue  =  0 ;   //原始值
    private  double  lstValue  =  0 ;   //上次的值
    private  double  curValue  =  0 ;   //當前值
    private boolean  motiveState  =  true ;    //是否處於運動狀態
    private  boolean  processState  =  false ;    //標記當前是否已經在計步

    @Override
    protected  void  onCreate ( Bundle  savedInstanceState )  {
        super . onCreate ( savedInstanceState );
        setContentView ( R . layout . activity_op );

        sm  =  ( SensorManager )  getSystemService ( SENSOR_SERVICE );
        mSensorAccelerometer  =  sm . getDefaultSensor ( Sensor . TYPE_ACCELEROMETER );
        sm . registerListener ( this ,  mSensorAccelerometer ,  SensorManager . SENSOR_DELAY_UI );

        ms_step  =  ( TextView )  findViewById ( R . id . ms_step );
        btn_start  =  ( Button )  findViewById ( R . id . btn_start );
        btn_start . setOnClickListener ( this );
    }

    @Override
    public  void  onSensorChanged ( SensorEvent  event )  {

        //設定一個精度範圍
        double  range  =  1 ;
        float []  value  =  event . values ;

        //計算當前的模
        curValue  =  magnitude ( value [ 0 ],  value [ 1 ],  value [ 2 ]);

        //向上加速的狀態
        if  ( motiveState  ==  true )  {
            if  ( curValue  >=  lstValue )  lstValue  =  curValue ;
            else  {
                //檢測到一次峰值
                if  ( Math . abs ( curValue  -  lstValue )  >  range )  {
                    oriValue  =  curValue ;
                    motiveState  =  false ;
                }
            }
        }
        //向下加速的狀態
        if  (motiveState  ==  false )  {
            if  ( curValue  <=  lstValue )  lstValue  =  curValue ;
            else  {
                if  ( Math . abs ( curValue  -  lstValue )  >  range )  {
                    //檢測到一次峰值
                    oriValue  =  curValue ;
                    if  ( processState  ==  true )  {
                        step ++ ;   //步數 +  1
                        if  (processState  ==  true )  {
                            ms_step . setText ( step  +  "" );     //讀數更新
                        }
                    }
                    motiveState  =  true ;
                }
            }
        }
    }

    @Override
    public  void  onAccuracyChanged ( Sensor  sensor ,  int  accuracy )  {}

    @Override
    public  void  onClick ( View  v )  {

        step  =  0 ;
        ms_step . setText ( "0" );
        if  ( processState  ==  true )  {
            btn_start . setText ( "開始" );
            processState  =  false ;
        }  else  {
            btn_start . setText ( "停止" );
            processState  =  true ;
        }
    }

    //向量求模
    public  double  magnitude ( float  x ,  float  y ,  float  z )  {
        double  magnitude  =  0 ;
        magnitude  =  Math . sqrt ( x  *  x  +  y  *  y  +  z  *  z );
        return  magnitude ;
    }

    @Override
    protected  void  onDestroy ()  {
        super . onDestroy ();
        sm . unregisterListener ( this );
    }
    public void button7_Click(View view){
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}