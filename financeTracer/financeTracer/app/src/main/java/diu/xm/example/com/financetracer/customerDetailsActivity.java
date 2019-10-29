package diu.xm.example.com.financetracer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class customerDetailsActivity extends AppCompatActivity {

    ListView listview;

  //  DrawerLayout drawerLayout;
   // ActionBarDrawerToggle actionBarDrawerToggle;
   // private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private List<Customer> customerlist;
    private  listViewAddapter listViewAddapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details2);
        setTitle("Customer Details");


        myRef = FirebaseDatabase.getInstance().getReference("customer");
        customerlist = new ArrayList<>();

        listViewAddapter =new listViewAddapter ( customerDetailsActivity.this,customerlist);


        listview=findViewById(R.id.listViewId);

    }

    //code for menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.addCustomer)
        {
            Intent i=new Intent(customerDetailsActivity.this,AddCustomer.class);
            startActivity(i);
            Toast.makeText(this," add customer ",Toast.LENGTH_LONG).show();
        }

        if(item.getItemId()==R.id.logOut)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent i=new Intent(customerDetailsActivity.this,MainActivity.class);
            startActivity(i);

            Toast.makeText(this," successfully log out ",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //close code for menu

    //code for show listview
    @Override
    protected void onStart() {

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                customerlist.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                {
                    Customer customer=dataSnapshot1.getValue(Customer.class);
                    customerlist.add(customer);

                }

                listview.setAdapter(listViewAddapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }

    //close code for menu
}
