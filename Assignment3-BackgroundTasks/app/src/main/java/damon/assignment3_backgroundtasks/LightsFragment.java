package damon.assignment3_backgroundtasks;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Damon on 2/23/2017.
 */

public class LightsFragment extends Fragment implements Animator.AnimatorListener {
    private LightsModel mLights;
    private View view;
    private Animator anim;

    public LightsFragment() {
        this.mLights = new LightsModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lights, container, false);
        return view;
    }

    public void stopLights() {
        anim.cancel();
        view.findViewById(R.id.red_light).setVisibility(View.VISIBLE);
        view.findViewById(R.id.green_light).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.yellow_light).setVisibility(View.INVISIBLE);
    }

    public void updateLights() {
        anim = AnimatorInflater.loadAnimator(getActivity(), R.animator.change_light_green);
        anim.addListener(this);
        View v = view.findViewById(R.id.green_light);

        anim.setTarget(v);
        view.findViewById(R.id.red_light).setVisibility(View.INVISIBLE);
        anim.start();
    }

    @Override
    public void onAnimationEnd(Animator a) {
        View v;
        anim.addListener(null);

        if(mLights.getLight_pos() == 1) {
            v = view.findViewById(R.id.red_light);
            anim = AnimatorInflater.loadAnimator(getActivity(), R.animator.change_light_red);
            mLights.setLight_pos(2);
        }
        else if(mLights.getLight_pos() == 2) {
            v = view.findViewById(R.id.yellow_light);
            anim = AnimatorInflater.loadAnimator(getActivity(), R.animator.change_light_yellow);
            mLights.setLight_pos(3);
        }
        else {
            v = view.findViewById(R.id.green_light);
            anim = AnimatorInflater.loadAnimator(getActivity(), R.animator.change_light_green);
            mLights.setLight_pos(1);
        }

        anim.addListener(this);
        anim.setTarget(v);
        anim.start();
    }

    @Override
    public void onAnimationRepeat(Animator a) {
    }

    @Override
    public void onAnimationStart(Animator a) {
    }

    @Override
    public void onAnimationCancel(Animator a) {
        anim.removeAllListeners();
    }
}

