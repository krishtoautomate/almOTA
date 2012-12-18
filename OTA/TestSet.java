package HPQC.OTA;

import java.util.Iterator;

import hpqc.otaclient.IBaseFactory;
import hpqc.otaclient.IList;
import hpqc.otaclient.ITDFilter;
import hpqc.otaclient.ITSTest;
import hpqc.otaclient.ITestSet;
import com4j.Com4jObject;

public class TestSet {
    
    private ITestSet testSet_;
    
    public TestSet(Com4jObject testSet) {
        testSet_ = testSet.queryInterface(ITestSet.class);
    }
    
    public TestSet(ITestSet testSet) {
        testSet_ = testSet;
    }
    
    public String getName() {
        return testSet_.name();
    }
    
    public TSTest[] getTestInstances(String filter) {
        IBaseFactory testInstanceFactory = testSet_.tsTestFactory().queryInterface(IBaseFactory.class);
        IList testInstanceList = testInstanceFactory.newList(filter);
        TSTest[] testInstances = new TSTest[testInstanceList.count()];
        Iterator<Com4jObject> tiIter = testInstanceList.iterator();
        int i = 0;
        while (tiIter.hasNext()) {
            testInstances[i] = new TSTest(tiIter.next());
            i ++;
        }
        return testInstances;
    }
    
    public TSTest[] getTestInstances(ITDFilter filter) {
        return getTestInstances(filter.text());
    }
    
}
