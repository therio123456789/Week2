package homework.rio.week2;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ChangeTitleActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnShow;
    private EditText editText;
    private Button[] listButton;
    private Button btnSave;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_title);
        connectView();
        getData();
        context = this;
    }

    private void getData() {
        String text = getIntent().getStringExtra(MainActivity.KEY_CODE_TEXT);
        int color = getIntent().getIntExtra(MainActivity.KEY_CODE_COLOR,0);
        editText.setText(text);
        btnShow.setBackgroundColor(color);
    }

    private void connectView() {
        btnShow = (Button) findViewById(R.id.btnShow);
        editText = (EditText) findViewById(R.id.eTxt);
        listButton = new Button[6];
        listButton[0] = (Button) findViewById(R.id.btnPink);
        listButton[1] = (Button) findViewById(R.id.btnPurple);
        listButton[2] = (Button) findViewById(R.id.btnIndigo);
        listButton[3] = (Button) findViewById(R.id.btnBlue);
        listButton[4] = (Button) findViewById(R.id.btnTeal);
        listButton[5] = (Button) findViewById(R.id.btnGreen);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        for(int i = 0; i < listButton.length; i++) {
            listButton[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSave) {
            doClickButtonSave();
        }
        else {
            for(Button btn : listButton) {
                if(btn.getId() == v.getId()) {
                    doClickButtonColor(btn);
                }
            }
        }
    }
    private void doClickButtonSave() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.KEY_CODE_TEXT,editText.getText().toString());
        ColorDrawable colorDrawable = (ColorDrawable) btnShow.getBackground();
        intent.putExtra(MainActivity.KEY_CODE_COLOR,colorDrawable.getColor());
        startActivity(intent);
    }
    private void doClickButtonColor(Button btn) {
        ColorDrawable buttonColor = (ColorDrawable) btn.getBackground();
        int color = buttonColor.getColor();
        btnShow.setBackgroundColor(color);
    }
}
