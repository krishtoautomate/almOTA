package HPQC.OTA;

import java.util.Iterator;

import hpqc.otaclient.IBaseFactory;
import hpqc.otaclient.IDesignStep;
import hpqc.otaclient.IList;
import hpqc.otaclient.ISubjectNode;
import hpqc.otaclient.ITDFilter;
import hpqc.otaclient.ITest;
import com4j.Com4jObject;

public class Test {
    
    public class Fields {
        public static final String SUBJECT = "TS_SUBJECT";
    }
    
    private ITest test_;

    public Test(Com4jObject test) {
        test_ = test.queryInterface(ITest.class);
    }
    
    public Test(ITest test) {
        test_ = test;
    }
    
    public String getPath() {
        String testCasePath = ((Com4jObject)test_.field(Fields.SUBJECT)).queryInterface(ISubjectNode.class).path();
        testCasePath = testCasePath + "\\" + test_.name();
        return testCasePath;
    }
    
    public DesignStep[] getDesignSteps(String filter) {
        IBaseFactory designStepFactory = test_.designStepFactory().queryInterface(IBaseFactory.class);
        IList designStepsList = designStepFactory.newList(filter);
        Iterator<Com4jObject> designStepsIterator = designStepsList.iterator();
        DesignStep[] designSteps = new DesignStep[designStepsList.count()];
        int i = 0;
        while (designStepsIterator.hasNext()) {
            designSteps[i] = new DesignStep(designStepsIterator.next());
            i++;
        }
        return designSteps;
    }
    
    public DesignStep[] getDesignSteps(ITDFilter filter) {
        return getDesignSteps(filter.text());
    }

}
