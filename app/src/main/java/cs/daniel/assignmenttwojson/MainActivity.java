package cs.daniel.assignmenttwojson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> arrayList;
    DataAdapter dataAdapter;

    Button btnFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<>();

        btnFetch = (Button)findViewById(R.id.btnFetch);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parseJsonData();
            }
        });
    }

    // Parse data from url in JSON format

    private void parseJsonData() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pixabay.com/api/?key=24142055-f5330b530546127304666113b&q=yellow+flowers&image_type=photo";
        StringRequest request = new StringRequest(Request.Method.GET, url, new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("hits");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject dataObject = array.getJSONObject(i);
                                String image = dataObject.getString("userImageURL");
                                String user = dataObject.getString("user");
                                String like = dataObject.getString("likes");
                                Model model = new Model(image, user, like);
                                arrayList.add(model);
                            }

                            dataAdapter = new DataAdapter(MainActivity.this, arrayList);
                            recyclerView.setAdapter(dataAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error: failed to fetch", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }
}