package lifecycle.ru.innobi.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class TemperatureActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        textView = findViewById(R.id.temperature);
        textView.setText("Температура в городе " +
                getIntent().getExtras().getString(MainActivity.KEY_CITY) +": " +
                getIntent().getExtras().getInt(MainActivity.KEY_TEMPERATURE));
    }
}
