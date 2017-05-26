package com.example.aldo.comunicazionegetpost;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    private EditText codFisc,passw;
    private Button buttonAccedi,buttonRegistrati;
    private  final String url = "https://forward-honor.000webhostapp.com/login.php";
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("GESAN");
        getSupportActionBar().setSubtitle("Login");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.codFisc = (EditText)findViewById(R.id.codFiscLogin);
        this.passw = (EditText)findViewById(R.id.passLogin);
        this.buttonAccedi = (Button)findViewById(R.id.buttonAccess);
        this.buttonRegistrati = (Button)findViewById(R.id.signin);
        buttonEffect(buttonAccedi);
        buttonEffect(buttonRegistrati);
        builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Login");
        buttonRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistrazioneActivity.class);
                startActivityForResult(intent,1);
            }
        });
        buttonAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (codFisc.getText().toString().trim().isEmpty() || passw.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginActivity.this,"Inserire i dati",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("1")){
                            builder.setMessage("Accesso eseguito con successo");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(LoginActivity.this,SwipeTable.class);
                                    intent.putExtra("codicefiscale",codFisc.getText().toString());
                                    startActivity(intent);
                                }
                            });

                        } else {
                            builder.setMessage("Accesso negato. Controllare i dati inseriti");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    codFisc.setText("");
                                    passw.setText("");
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
                        Toast.makeText(LoginActivity.this,"Errore di connessione al server",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> map = new HashMap<String, String>();
                        map.put("codicefiscale",codFisc.getText().toString().trim().toUpperCase());
                        map.put("pas",passw.getText().toString());
                        return map;
                    }
                };
                CustomVolleyRequestQueue.getInstance(LoginActivity.this).addToRequestQueue(stringRequest);
            }
        });

    }
    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe000E1AD, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

    }
}
