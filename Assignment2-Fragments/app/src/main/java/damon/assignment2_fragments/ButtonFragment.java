package damon.assignment2_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Damon on 2/11/2017.
 */

public class ButtonFragment extends Fragment {
    OnButtonClickListener mListener;

    public interface OnButtonClickListener {
        void onButtonClick();
    }

    void setOnButtonClickListener(OnButtonClickListener newListener) {
        this.mListener = newListener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_button, container, false);
    }

    public void buttonClicked() {
        mListener.onButtonClick();
    }
}
