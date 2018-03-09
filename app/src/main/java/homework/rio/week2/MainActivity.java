package homework.rio.week2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_CODE_TEXT = "TEXT";
    public static final String KEY_CODE_COLOR = "COLOR";
    public static final String KEY_CODE_BACKGROUND = "BACKGROUND";
    private ImageView imageBackGround;
    private TextView txtTit;
    private Button btnBack;
    private Button btnTit;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        getData();
        context = this;
    }
    private void connectView() {
        imageBackGround = (ImageView) findViewById(R.id.imageBackGround);
        txtTit = (TextView) findViewById(R.id.txtTit);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnTit = (Button) findViewById(R.id.btnTit);
        btnTit.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }
    private void getData() {
        String text = getIntent().getStringExtra(KEY_CODE_TEXT);
        int color = getIntent().getIntExtra(KEY_CODE_COLOR,0);
        int imageID = getIntent().getIntExtra(KEY_CODE_BACKGROUND,0);
        if((text != null)&&(color != 0)) {
            txtTit.setText(text);
            txtTit.setTextColor(color);
        }
        if(imageID != 0) {
//            ImageView imageBack = (ImageView) findViewById(imageID);
//            imageBackGround.setImageDrawable(imageBack.getDrawable());
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btnTit.getId()) {
            doClickButtonTit();
        }
        else if(v.getId() == R.id.btnBack) {
            doClickButtonBack();
        }
    }
    private void doClickButtonTit() {
        Intent intent = new Intent(context,ChangeTitleActivity.class);
        intent.putExtra(KEY_CODE_TEXT,txtTit.getText().toString());
        intent.putExtra(KEY_CODE_COLOR,txtTit.getCurrentTextColor());
        startActivity(intent);
    }
    private void doClickButtonBack() {
        Intent intent = new Intent(context,ChangeBackgroundActivity.class);
        startActivity(intent);
    }
}
