package HPQC.OTA;

import hpqc.otaclient.IStep;
import com4j.Com4jObject;

public class Step {
    
    IStep step_;

    public Step(Com4jObject step) {
        step_ = step.queryInterface(IStep.class);
    }
    
    public Step(IStep step) {
        step_ = step;
    }

}
