package diu.xm.example.com.financetracer;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class listViewAddapter extends ArrayAdapter<Customer> {

    private Activity context;
    private List<Customer> customerList;

    public listViewAddapter(Activity context, List<Customer> customerList) {
        super(context, R.layout.listview_layout, customerList);
        this.context = context;
        this.customerList = customerList;


    }


    @NonNull
    @Override
    public View getView(int position , View convertView, ViewGroup parent) {



        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.listview_layout, null,true);

        Customer Customer = customerList.get(position);

        TextView text=view.findViewById(R.id.textId);

        //use position for show in row
        text.setText( String.valueOf(position +1)+" . "+Customer.getName());

        return view;
    }
}
