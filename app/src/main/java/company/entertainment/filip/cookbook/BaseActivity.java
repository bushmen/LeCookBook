package company.entertainment.filip.cookbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import company.entertainment.filip.cookbook.widgets.CookBookToolbar;

public abstract class BaseActivity extends AppCompatActivity {
    protected CookBookToolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = (CookBookToolbar)findViewById(R.id.toolbar);
    }
}
