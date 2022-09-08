package com.example.mypracticeapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    EditText eTNameDisplyVar;
    String stringNameVar;
    TextView tVNameViewVar;
    TextView intentPutExtra,etDateVar,etTimeVar;
    MediaPlayer mediaPlayerVar;
    VideoView videoViewVar;
    Button videoButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTNameDisplyVar = findViewById(R.id.et_diply);
        tVNameViewVar = findViewById(R.id.name_view);

        intentPutExtra = findViewById(R.id.et_intnt);

        etDateVar = findViewById(R.id.tv_dte_pkr);
        etTimeVar = findViewById(R.id.tv_time_pkr);

        mediaPlayerVar = MediaPlayer.create(MainActivity.this,R.raw.raisingmehigher);

        videoButton = findViewById(R.id.video_btn);
        videoViewVar = findViewById(R.id.videoView);

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri videolink = Uri.parse("https://www.ebookfrenzy.com/android_book/movie.mp4");
                videoViewVar.setVideoURI(videolink);
                videoViewVar.start();

                MediaController mediaController = new MediaController(MainActivity.this);
                videoViewVar.setMediaController(mediaController);
                mediaController.setAnchorView(videoViewVar);
            }
        });

    }



    public void name(View view) {
        stringNameVar = eTNameDisplyVar.getText().toString();
        tVNameViewVar.setText(stringNameVar);

    }



    public void intent(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("name",intentPutExtra.getText().toString());
        startActivity(intent);
    }



    public void alert(View view) {

        AlertDialog.Builder naveen = new AlertDialog.Builder(MainActivity.this);
        naveen.setTitle("Alert!!");
        naveen.setMessage("This is Alert Dialog Box ?");
        naveen.setIcon(android.R.drawable.ic_media_ff);
        naveen.setPositiveButton("YES", null );
        naveen.setNegativeButton("NO",null);
        naveen.setNeutralButton("Back",null);
        naveen.show();
    }




    public void datepicker(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                etDateVar.setText(i+1+ "/" +i1+ "/" +i2);
            }
        },1990,11,31);
        datePickerDialog.show();
    }




    public void customdialog(View view) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.activity_main);
        dialog.show();
    }



    public void timepicker(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                etTimeVar.setText(i+":"+i1);
            }
        },12,00,true);
        timePickerDialog.show();
    }




    public void music(View view) {

        mediaPlayerVar.start();

        if (mediaPlayerVar.isPlaying()){
            mediaPlayerVar.pause();
            mediaPlayerVar.start();
        }
        else {
            mediaPlayerVar.stop();
        }
    }



    public void toast(View view) {

        Toast.makeText(this, "Thanks", Toast.LENGTH_SHORT).show();
    }



    public void webview(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);

    }



    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void seting(MenuItem item) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }

    public void apppermis(MenuItem item) {
        Toast.makeText(this, "World", Toast.LENGTH_SHORT).show();
    }

    public void logout(MenuItem item) {

        Toast.makeText(this, "Thanks", Toast.LENGTH_SHORT).show();
    }





}