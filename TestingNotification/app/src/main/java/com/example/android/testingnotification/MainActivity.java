package com.example.android.testingnotification;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "default";
    private static final int importance = NotificationManager.IMPORTANCE_HIGH;
    private static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNotificationChannel();

        Button button = findViewById(R.id.buttonNotification);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID);
                mBuilder.setSmallIcon(R.drawable.greyheart);
                mBuilder.setContentTitle("Hey You!");
                mBuilder.setContentText("You are loved");
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
            }
        });
    }

    private NotificationChannel setupNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(
                      CHANNEL_ID
                    , getString(R.string.channel_name)
                    , importance);
            channel.setDescription(getString(R.string.channel_description));
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            return channel;
        } else {
            return null;
        }
    }



//    public void sendNotificationAction(View view){
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
//        mBuilder.setSmallIcon(R.drawable.greyheart);
//        mBuilder.setContentTitle("Hey You!");
//        mBuilder.setContentText("You are loved");
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
//    }
}
