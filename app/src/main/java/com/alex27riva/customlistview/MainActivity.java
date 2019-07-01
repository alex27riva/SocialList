package com.alex27riva.customlistview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Facebook","Whatsapp","Twitter","Instagram","Youtube"};
    String mDescription[] = {"Connect with your friends", "Don't use Whatsapp", "A good social network", "Unuseful social", "TV replacement"};
    int images [] = {R.drawable.facebook, R.drawable.whatsapp, R.drawable.twitter, R.drawable.instagram, R.drawable.youtube};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this,mTitle, mDescription, images );
        listView.setAdapter(adapter);
///*
        //imposto il click sulle immagini
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id ) {

                switch(position) {
                    case 0:
                        //Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                        GoToURL("https://play.google.com/store/apps/details?id=com.facebook.katana&hl=it");
                        break;
                    case 1:
                        GoToURL("https://play.google.com/store/apps/details?id=com.whatsapp");
                        break;

                    case 2:
                        GoToURL("https://play.google.com/store/apps/details?id=com.twitter.android");
                        break;

                    case 3:
                        GoToURL("https://play.google.com/store/apps/details?id=com.instagram.android");
                        break;

                    case 4:
                        GoToURL("https://play.google.com/store/apps/details?id=com.google.android.youtube");
                        break;



                }

            }

        });
//*/

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textTitle, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);


            View row = layoutInflater.inflate(R.layout.row, parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textTitle);
            TextView myDescription = row.findViewById(R.id.textComment);

            //imposto le risorse
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }
    void GoToURL(String url){
        Uri uri = Uri.parse(url);
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

}
