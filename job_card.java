package joud.asim.sd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class job_card extends BaseAdapter {
    private ArrayList<job_model> models;
    private Context context;
    static String  place;

    public job_card(ArrayList<job_model> models, Context context) {
        this.models = models;
        this.context = context;
    }


    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = View.inflate(context, R.layout.job_list,null);
        View result;
        result=view;
        if(view == null){
            Toast.makeText(context, "Network soo Bad !", Toast.LENGTH_LONG).show();

            result =view;
        }
        else{
            result=view;

            TextView job_name=view.findViewById(R.id.job_name);
            TextView salary=view.findViewById(R.id.salary);

            Button show=view.findViewById(R.id.show_det);


            final job_model model=models.get(i);


            job_name.setText(model.getJob_name());
            salary.setText(model.getSalary());
            place=model.job_place;


            //call
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,LoginActivity.class);
                    intent.putExtra("adv_data",model.getAdve_data());
                    intent.putExtra("age",model.getAge());
                    intent.putExtra("end_data",model.getEnd_data());
                    intent.putExtra("gua",model.getGua());
                    intent.putExtra("job_name",model.getJob_name());
                    intent.putExtra("job_place",model.getJob_place());
                    intent.putExtra("salary",model.getSalary());
                    intent.putExtra("sek_type",model.getSek_type());
                    intent.putExtra("spicialization",model.getSpicialization());
                    intent.putExtra("year_ex",model.getYear_ex());

                }
            });




        }
        return result;

    }
}
