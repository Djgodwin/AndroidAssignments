package damon.assignment2_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Damon on 2/11/2017.
 */

public class LightsFragment extends Fragment {
    private LightsModel mLights;
    private View view;

    public LightsFragment() {
        this.mLights = new LightsModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lights, container, false);
        return view;
    }

    public void changeLights() {
        mLights.updateLights_pos();
        updateLights();

    }

    public void updateLights() {

        if((mLights.getLight_pos() % 3) == 1) {
            view.findViewById(R.id.red_light).setVisibility(View.INVISIBLE);
            view.findViewById(R.id.yellow_light).setVisibility(View.VISIBLE);
        }

        else if((mLights.getLight_pos() % 3) == 2) {
            view.findViewById(R.id.yellow_light).setVisibility(View.INVISIBLE);
            view.findViewById(R.id.green_light).setVisibility(View.VISIBLE);
        }

        else {
            view.findViewById(R.id.green_light).setVisibility(View.INVISIBLE);
            view.findViewById(R.id.red_light).setVisibility(View.VISIBLE);
        }

    }

}
