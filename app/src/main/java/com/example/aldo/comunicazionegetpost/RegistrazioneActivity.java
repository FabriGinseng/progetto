package com.example.aldo.comunicazionegetpost;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.example.aldo.comunicazionegetpost.LoginActivity.buttonEffect;

public class RegistrazioneActivity extends AppCompatActivity {

    private EditText editDataNascita;
    // 0 nome, 1 cognome, 2 codice fiscale, 3 pec
    private EditText[] editDatiPersonali = new EditText[4];
    private RadioGroup groupEsenzione,groupSesso;
    private final String url ="https://forward-honor.000webhostapp.com/registrazione.php";
    private Button buttonRegistrati;
    private AlertDialog.Builder builder;
    private EditText passw;

    private Button btndialog;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_registrazione);
        getSupportActionBar().setTitle("GESAN");
        getSupportActionBar().setSubtitle("Registrazione");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        buttonRegistrati = (Button)findViewById(R.id.btnRegistrazione);
        editDatiPersonali[0] = (EditText)findViewById(R.id.registrazione_nome);
        editDatiPersonali[1] = (EditText)findViewById(R.id.registrazione_cognome);
        editDatiPersonali[2] = (EditText)findViewById(R.id.registrazione_codice_fiscale);
        editDataNascita = (EditText)findViewById(R.id.registrazione_data);
        btndialog=(Button)findViewById(R.id.buttonDialogOK);

        editDatiPersonali[3] = (EditText)findViewById(R.id.registrazione_pec);
        groupSesso = (RadioGroup)findViewById(R.id.registrazione_sesso);
        groupEsenzione = (RadioGroup)findViewById(R.id.registrazione_esenzione);
        buttonEffect(buttonRegistrati);
        // buttonEffect(btndialog);
        passw=(EditText)findViewById(R.id.registrazionePassword) ;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Registrazione");
        editDataNascita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog d = new Dialog(RegistrazioneActivity.this);
                d.setContentView(R.layout.custom_date);
                d.setTitle("Data di nascita");
                final DatePicker datePicker = (DatePicker)d.findViewById(R.id.datePick);
                Button button = (Button) d.findViewById(R.id.buttonDialogOK);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        editDataNascita.setText(datePicker.getYear() + "-" + datePicker.getMonth() + "-" + datePicker.getDayOfMonth());
                        d.dismiss();
                    }
                });
                d.show();
            }
        });
        buttonRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editDataNascita.getText().toString().isEmpty()) {
                    Toast.makeText(RegistrazioneActivity.this,"Inserisci tutti i dati", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (groupSesso.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(RegistrazioneActivity.this, "Inserisci tutti i dati", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (groupEsenzione.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(RegistrazioneActivity.this, "Inserisci tutti i dati", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (passw.getText().toString().isEmpty())
                {
                    Toast.makeText(RegistrazioneActivity.this, "Inserisci tutti i dati",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (editDatiPersonali[2].getText().toString().trim().length() != 16) {
                    Toast.makeText(RegistrazioneActivity.this, "Errore nell'inserimento del codice fiscale", Toast.LENGTH_SHORT).show();
                    return;
                }
                for (int i=0;i<4;i++){
                    if (editDatiPersonali[i].getText().toString().trim().isEmpty()) {
                        Toast.makeText(RegistrazioneActivity.this, "Inserisci tutti i dati", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("1")){
                            builder.setMessage("Registrazione riuscita");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                        } else {
                            builder.setMessage("Registrazione non riuscita");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    return;
                                }
                            });
                        }
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        builder.setMessage("Errore di connessione");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }){
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError{
                        RadioButton sesso,esenzione;
                        sesso = (RadioButton)findViewById(groupSesso.getCheckedRadioButtonId());
                        esenzione = (RadioButton)findViewById(groupEsenzione.getCheckedRadioButtonId());
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("name",editDatiPersonali[0].getText().toString());
                        params.put("surname",editDatiPersonali[1].getText().toString());
                        params.put("codicefiscale",editDatiPersonali[2].getText().toString().toUpperCase());
                        params.put("email",editDatiPersonali[3].getText().toString());
                        params.put("sex",sesso.getText().toString());
                        params.put("esenzione",esenzione.getText().toString().toUpperCase());
                        params.put("data",editDataNascita.getText().toString());
                        params.put("pas",passw.getText().toString());
                        return params;
                    }

                };
                CustomVolleyRequestQueue.getInstance(RegistrazioneActivity.this).addToRequestQueue(stringRequest);
            }
        });

    }
    public void generatoreCodiceFiscale(){

    }
}