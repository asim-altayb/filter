package joud.asim.sd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class jobs extends AppCompatActivity {
    ListView list;
    private JSONArray result;
    Button kh , bh , um;
    job_card card;
    private ArrayList<job_model> models= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        list=(ListView) findViewById(R.id.jobs_list);

        kh=(Button) findViewById(R.id.kh_filter);
        bh=(Button) findViewById(R.id.bh_filter);
        um=(Button) findViewById(R.id.um_filter);

        getData();

    }
    public void getData()
    {
        StringRequest stringRequest = new StringRequest("http://joud.rf.gd/Donors.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray("result");
                            System.out.println(result.toString());
                            getneeds(result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error in volly : "+error.getMessage());

                    }



                }

        )
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.10240");
                params.put("Cookie", "__test="+cookie.content+"; expires=Friday, January 1, 2038 at 1:55:55 AM; path=/");

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getApplication()));
        requestQueue.add(stringRequest);
    }

    private void getneeds(JSONArray j){
        for(int i=0;i<j.length();i++){
            try {
                JSONObject json = j.getJSONObject(i);
                models.add(new job_model(json.getString("job_name"),json.getString("job_place"),
                        json.getString("sek_type"),json.getString("years_experience"),
                        json.getString("age"),json.getString("spicialization"),
                        json.getString("gualification"),json.getString("adve_data")
                        ,json.getString("end_data"),json.getString("salary")));
                //(String job_name, String job_place, String sek_type, String year_ex, String age,
                // String spicialization, String gua, String adve_data, String end_data ,String salary
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        card = new job_card(models,Objects.requireNonNull(getApplication()).getApplicationContext());
        list.setAdapter(card);
    }

    /*
    *
    * 'job_name'=>$row["job_name"],
        'job_place'=>$row["job_place"],
        'sek_type'=>$row["sek_type"],
        'years_experience'=>$row["years_experience"],
        'age'=>$row['Age'],
	'spicialization'=>$row["spicialization"],
	'gualification'=>$row["gualification"],
	'adve_data'=>$row["adve_data"],
	'end_data'=>$row["end_data"],
	'salary'=>$row["salary"]*/
}
