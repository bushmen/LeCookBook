package company.entertainment.filip.cookbook.mainpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import company.entertainment.filip.cookbook.R;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
