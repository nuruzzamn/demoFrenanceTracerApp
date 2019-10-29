package diu.xm.example.com.exammid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count=0;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button incre =(Button) findViewById(R.id.BtIn);
        Button decre =(Button) findViewById(R.id.btnDe);
        Button reset =(Button) findViewById(R.id.reset);
        show=(TextView)findViewById(R.id.show);

        incre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView show=(TextView)findViewById(R.id.show);

                count=count+1;
                show.setText(String.valueOf(count));

            }

        });

        decre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView show=(TextView)findViewById(R.id.show);

                count --;
                show.setText(String.valueOf(count));

            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  TextView show=(TextView)findViewById(R.id.show);
                count=0;
                show.setText(String.valueOf(count));

            }
        });



    }
}
