package HPQC.OTA;

import hpqc.otaclient.IDesignStep;
import com4j.Com4jObject;

public class DesignStep {
    
    IDesignStep designStep_;

    public DesignStep(Com4jObject designStep) {
        designStep_ = designStep.queryInterface(IDesignStep.class);
    }
    
    public DesignStep(IDesignStep designStep) {
        designStep_ = designStep;
    }
    
    public String getName() {
        return designStep_.stepName();
    }
    
    public String getDescription() {
        return designStep_.stepDescription();
    }
    
    public String getExpectedResult() {
        return designStep_.stepExpectedResult();
    }

}
