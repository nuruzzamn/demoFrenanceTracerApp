package diu.xm.example.com.financetracer;

import android.content.Intent;
import android.support.annotation.NonNull;
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

public class newAdd extends AppCompatActivity {

    //code for show list view
    ListView listview;

    //  DrawerLayout drawerLayout;
    // ActionBarDrawerToggle actionBarDrawerToggle;
    // private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private List<Customer> customerlist;
    private  listViewAddapter listViewAddapter;
    //close code



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add);
        setTitle("addNewCuystomer");

        //code for show view
        myRef = FirebaseDatabase.getInstance().getReference("customer");
        customerlist = new ArrayList<>();
        listViewAddapter =new listViewAddapter ( newAdd.this,customerlist);
        listview=findViewById(R.id.listViewId);
        //close code

    }

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
            Intent i=new Intent(newAdd.this,AddCustomer.class);
            startActivity(i);
            Toast.makeText(this," add customer ",Toast.LENGTH_LONG).show();

        }

        if(item.getItemId()==R.id.logOut)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent i=new Intent(newAdd.this,MainActivity.class);
            startActivity(i);

            Toast.makeText(this," successfully log out ",Toast.LENGTH_LONG).show();
        }

        if(item.getItemId()==R.id.profileImage)
        {
            Toast.makeText(this," view image ",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    //code for show listView
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

    //close code
}
