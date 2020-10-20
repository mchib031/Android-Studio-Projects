package com.lab.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onOpenInGoogleMaps(View view){
        EditText teamAddress = (EditText)findViewById(R.id.teamAdressField);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void onSetAvatarButton(View view){
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_CANCELED)return;
        ImageView avatarImage = (ImageView)findViewById(R.id.avatarImage);
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID",R.id.teamid00)){
            case R.id.teamid00:
                drawableName="ic_logo_00";
                break;
            case R.id.teamid01:
                drawableName="ic_logo_01";
                break;
            case R.id.teamid02:
                drawableName="ic_logo_02";
                break;
            case R.id.teamid03:
                drawableName="ic_logo_03";
                break;
            case R.id.teamid04:
                drawableName="ic_logo_04";
                break;
            case R.id.teamid05:
                drawableName="ic_logo_05";
                break;
            default:
                drawableName="ic_logo_00";
                break;
        }
        int resId = getResources().getIdentifier(drawableName,"drawable",getPackageName());
        avatarImage.setImageResource(resId);
    }

}