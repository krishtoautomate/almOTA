package HPQC.OTA;

import java.util.Iterator;

import com4j.Com4jObject;

import hpqc.otaclient.IList;
import hpqc.otaclient.ITDFilter;
import hpqc.otaclient.ITestSet;
import hpqc.otaclient.ITestSetFolder;

public class TestSetFolder {
    
    private ITestSetFolder testSetFolder_;
    
    public TestSetFolder(Com4jObject testSetFolder) {
        testSetFolder_ = testSetFolder.queryInterface(ITestSetFolder.class);
    }
    
    public TestSetFolder(ITestSetFolder testSetFolder) {
        testSetFolder_ = testSetFolder;
    }
    
    public TestSet[] getTestSets(String filter) {
        IList testSetList = testSetFolder_.findTestSets("", false, filter);
        TestSet[] testSets = new TestSet[testSetList.count()];
        Iterator<Com4jObject> tsIter = testSetList.iterator();
        int i = 0;
        while (tsIter.hasNext()) {
            testSets[i] = new TestSet(tsIter.next());
            i ++;
        }
        return testSets;
    }
    
    public TestSet[] getTestSets(ITDFilter filter) {
        return getTestSets(filter.text());
    }

}
