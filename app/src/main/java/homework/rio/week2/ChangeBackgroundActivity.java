package homework.rio.week2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;

public class ChangeBackgroundActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView[] images = new ImageView[6];
    private Context context;
    private TextView textView;
    private Button btnSaveBack;
    private ImageView image = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);
        connectView();
        context = this;
    }
    private void connectView() {
        btnSaveBack = (Button) findViewById(R.id.btnSaveBack);
        images[0] = (ImageView) findViewById(R.id.img0);
        images[1] = (ImageView) findViewById(R.id.img1);
        images[2] = (ImageView) findViewById(R.id.img2);
        images[3] = (ImageView) findViewById(R.id.img3);
        images[4] = (ImageView) findViewById(R.id.img4);
        images[5] = (ImageView) findViewById(R.id.img5);
        btnSaveBack.setOnClickListener(this);
        for(ImageView imageView : images) {
            imageView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSaveBack) {
            doClickButtonSaveBack();
        }
        else {
            for(ImageView imageView : images) {
                if(imageView.getId() == v.getId()) {
                    doClickImage(imageView);
                }
            }
        }
    }

    private void doClickImage(ImageView imageView) {
        for(ImageView img : images) {
            img.setBackgroundColor(0xFFFFFF);
        }
        imageView.setBackgroundColor(0xADD8E6);
        image = imageView;
    }

    private void doClickButtonSaveBack() {
        Intent intent = new Intent(context,MainActivity.class);
        if(image != null) {
            intent.putExtra(MainActivity.KEY_CODE_BACKGROUND,image.getId());
        }
        else {
            intent.putExtra(MainActivity.KEY_CODE_BACKGROUND, 0);
        }
        startActivity(intent);
    }
}
