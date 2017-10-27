package damon.assignment2_fragments;

/**
 * Created by Damon on 2/12/2017.
 */

public class LightsModel {
    private int light_pos = 0;

    public void updateLights_pos() {
        this.light_pos++;
    }

    public int getLight_pos() {
        return this.light_pos;
    }
}
