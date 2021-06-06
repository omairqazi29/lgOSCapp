package com.example.liquidgalaxyoscsender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.net.*;

import com.illposed.osc.*;

public class MainActivity extends AppCompatActivity {
    private String myIP = "192.168.31.46";
    private int myPort = 8140;
    private OSCPortOut oscPortOut;
    private MyTask Mytask;
    private String arg;


    public void Bangkok(View view)  {
        arg="Bangkok";
        Mytask=new MyTask();
        Mytask.execute();
    }

    public void London(View view)  {
        arg="London";
        Mytask=new MyTask();
        Mytask.execute();
    }

    public void Paris(View view)  {
        arg="Paris";
        Mytask=new MyTask();
        Mytask.execute();
    }

    public void Dubai(View view)  {
        arg="Dubai";
        Mytask=new MyTask();
        Mytask.execute();
    }

    public void Tokyo(View view)  {
        arg="Tokyo";
        Mytask=new MyTask();
        Mytask.execute();
    }


    public class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                // Connect to some IP address and port
                oscPortOut = new OSCPortOut(InetAddress.getByName(myIP), myPort);
            } catch (UnknownHostException e) {
                e.printStackTrace();
                // Error handling when your IP isn't found
            } catch (Exception e) {
                // Errorhandling for any other errors
            }
            try {
                OSCMessage message= new OSCMessage("/flyto");
                message.addArgument(arg);
                oscPortOut.send(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

