package mx.cicese.encuesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ComidaEspecifica extends AppCompatActivity {

    int[] IMAGES = {R.drawable.tortillas, R.drawable.bread, R.drawable.croissant,
            R.drawable.egg, R.drawable.soup, R.drawable.cereals};

    String[] TYPES = {"tortillas", "pan integral", "pan dulce", "huevos", "sopa/caldo","cereal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida_especifica);
        ListView listView = (ListView) findViewById(R.id.lista);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
    }

    public void siguiente(View v){
        Intent intent = new Intent(this, Bebidas.class);
        startActivity(intent);
    }

    public void atras(View v){
        finish();
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.adapter10, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_icon);
            TextView txt_type = (TextView) view.findViewById(R.id.txt_tipo);
            final TextView txt_quant = (TextView) view.findViewById(R.id.txt_quantity);
            SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);

            imageView.setImageResource(IMAGES[i]);
            txt_type.setText(TYPES[i]);

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    // TODO Auto-generated method stub
                    txt_quant.setText(String.valueOf(progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }
            });




            return view;
        }


    }
}