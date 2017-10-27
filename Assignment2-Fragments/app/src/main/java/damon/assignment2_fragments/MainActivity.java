package damon.assignment2_fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ButtonFragment.OnButtonClickListener {

    ButtonFragment buttonFragment;
    LightsFragment lightsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFragment = new ButtonFragment();
        lightsFragment = new LightsFragment();

        getFragmentManager().beginTransaction()
                .add(R.id.button_container, buttonFragment)
                .add(R.id.lights_container, lightsFragment)
                .commit();
        buttonFragment.setOnButtonClickListener(this);
    }

    public void startButtonClicked(View v) {
        buttonFragment.buttonClicked();
    }

    @Override
    public void onButtonClick() {
        lightsFragment.changeLights();
    }

    @Override
    public void onPause() {
        super.onPause();
        lightsFragment.updateLights();
    }
}
