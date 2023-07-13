package com.example.turasistan_reader;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.sanalogi.nfcreader.PassportModel;
import com.sanalogi.nfcreader.ScanCardIntent;
import com.sanalogi.nfcreader.nfc.NfcConnection;
import com.sanalogi.nfcreader.nfc.NfcScanResultInterface;
import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity /*implements NfcScanResultInterface*/ {
    /*private static final int REQUEST_CODE_SCAN_CARD = 1;
    boolean passportMode = false;*/
    private Button girisyap, deneyin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        girisyap = findViewById(R.id.girisyap);
        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginScreen();
            }
        });

        deneyin = findViewById(R.id.deneyin);
        deneyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTryitScreen();
            }
        });

        //Intent intent = new ScanCardIntent.Builder(MainActivity.this ).setPassportMode(passportMode).build();
        //startActivityForResult(intent, REQUEST_CODE_SCAN_CARD);
    }

    public void openLoginScreen(){
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
    public void openTryitScreen(){
        Intent intent = new Intent(this, TryitScreen.class);
        startActivity(intent);
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_SCAN_CARD:
                if (resultCode == Activity.RESULT_OK) {
                    PassportModel card = (PassportModel) data.getSerializableExtra(ScanCardIntent.RESULT_PAYCARDS_CARD);
                    String[] arr ={
                            "1 NFC çipine bağlanılıyor.",
                            "2 NFC çipine bağlanıldı.",
                            "3 Kimlik bilgileri alınıyor, lütfen bekleyiniz.",
                            "4 Kimlik bilgiler alındı.",
                            "5 Kimlik sahibinin bilgileri alınıyor",
                            "6 Kimlik sahibinin bilgileri alındı.",
                            "7 Kimlik sahibinin biometrik resmi alınıyor.",
                            "8 Kimlik sahibinin bilgileri alındı.",
                            "9 NFC okuması tamamlandı."};
                    NfcConnection.getInstance().init(this); //NFC taginin bulanabilmesi icin eklenmeli
                    NfcConnection.getInstance().setNfcScanResultInterface(this);
                    NfcConnection.getInstance().setNfcScanSteps(arr);

                    NfcConnection.getInstance().setPassportModel(card);
                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void nfcResult(PassportModel passportModel) {

    }

    @Override
    public void nfcSteps(String s, String s1) {

    }

    @Override
    public void nfcError(Exception e, String s) {

    }*/
}