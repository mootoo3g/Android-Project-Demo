package com.example.pranav.airlineee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgAirline;
    RatingBar rabRating;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgAirline = findViewById(R.id.rgAirline);
        rabRating = findViewById(R.id.rabRating);
        btnSubmit = findViewById(R.id.btnSubmit);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*  1) Group (HAamare group ka naam h rg airline waha seh milega id ) (aapne konsa check kiya id milla)seh milega id  */
                int id = rgAirline.getCheckedRadioButtonId();

                /*2) Id seh milega  radio button */
                RadioButton rb = findViewById(id);

                /*3) RadioButton seh Milega Text(airindia ,go, vistara...)*/
                String airline = rb.getText().toString();




                String rating = String.valueOf(rabRating.getRating()); /*Is converts double to string (Rating lera h)*/

                String msg = "Airline "+airline + "Rating "+ rating;
                Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();


                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"+"mootoo3g@gmail.com"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Airline Feedback");
                emailIntent.putExtra(Intent.EXTRA_TEXT,msg);
                startActivity(emailIntent);



            }
        });






    }
}
