package diu.xm.example.com.financetracer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCustomer extends AppCompatActivity {

    EditText nameAdd,phoneAdd,addressAdd;
    Button addClick,loadClick;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        setTitle("Create Customer Profile");

        myRef = FirebaseDatabase.getInstance().getReference("customer");
        //DatabaseReference myRef = database.getReference("message");

        nameAdd = (EditText) findViewById(R.id.nameId);
        phoneAdd = (EditText) findViewById(R.id.phoneId);
        addressAdd = (EditText) findViewById(R.id.addressId);
        addClick = (Button) findViewById(R.id.Addbtn);

///////////////////////
        loadClick = (Button) findViewById(R.id.loadbtn);
/////////////////////////

        addClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),customerDetailsActivity.class);
                startActivity(i);
            }
        });
    }
    public void saveData()
    {
        String name=nameAdd.getText().toString().trim();
        String phone=phoneAdd.getText().toString().trim();
        String address=addressAdd.getText().toString().trim();

        String key=myRef.push().getKey();

        Customer customer=new Customer(name,phone,address);

        myRef.child(key).setValue(customer);

        Toast.makeText(this,"New Customer Added Successfully",Toast.LENGTH_SHORT).show();


        if(name.isEmpty())
        {
            nameAdd.setError("Enter a name ");
            nameAdd.requestFocus();
            return;
        }

        if(phone.isEmpty())
        {
            phoneAdd.setError("Enter phone number");
            phoneAdd.requestFocus();
            return;
        }

        if(!Patterns.PHONE.matcher(phone).matches())
        {
            phoneAdd.setError("Enter valid phone number");
            phoneAdd.requestFocus();
            return;
        }

        if(address.isEmpty())
        {
            addressAdd.setError("Enter a address");
            addressAdd.requestFocus();
            return;
        }

        //for editText to be null
        nameAdd.setText("");
        phoneAdd.setText("");
        addressAdd.setText("");

    }


}