package damon.assignment3_backgroundtasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//red should be lit for 5 seconds
//yellow should be lit for 2 seconds
//green should be lit for 3 seconds
//start and stop buttons
//when you stop the light, it should default to red.
//when you start the light, it should default to green.
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

    public void startButtonPressed(View v) {
        buttonFragment.startSequence(lightsFragment);
    }


    public void stopButtonPressed(View v) {
        buttonFragment.stopSequence(lightsFragment);
    }

    @Override
    public void onButtonClick() {
    }
    //@Override
    //public void onPause() {
    //    lightsFragment.updateLights();
    //}
}
