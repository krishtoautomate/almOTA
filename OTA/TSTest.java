package HPQC.OTA;

import java.util.Iterator;
import java.util.Properties;

import hpqc.otaclient.IList;
import hpqc.otaclient.IParam;
import hpqc.otaclient.IRun;
import hpqc.otaclient.IRunFactory;
import hpqc.otaclient.ITDFilter;
import hpqc.otaclient.ITSTest;
import com4j.Com4jObject;

public class TSTest {
    
    private ITSTest testInstance_;

    public TSTest(Com4jObject testInstance) {
        testInstance_ = testInstance.queryInterface(ITSTest.class);
    }
    
    public TSTest(ITSTest testInstance) {
        testInstance_ = testInstance;
    }
    
    public Run createNewRun(String name, boolean AutoPost) {
        Run run = new Run(testInstance_.runFactory().queryInterface(IRunFactory.class).addItem(name));
        run.autoPost(AutoPost);
        return run;
    }
    
    public Run[] getRuns(String filter) {
        IRunFactory runFactory = testInstance_.runFactory().queryInterface(IRunFactory.class);
        IList runList = runFactory.newList(filter);
        Run[] runs = new Run[runList.count()];
        Iterator<Com4jObject> runIter = runList.iterator();
        int i = 0;
        while (runIter.hasNext()) {
            runs[i] = new Run(runIter.next());
            i ++;
        }
        return runs;
    }
    
    public Run[] getRuns(ITDFilter filter) {
        return getRuns(filter.text());
    }
    
    public Test getTest() {
        return new Test(testInstance_.test());
    }
    
    public Properties getParams() {
        IParam paramObject = testInstance_.params().queryInterface(IParam.class);
        if (paramObject == null) return null;
        int numOfParams = paramObject.count();
        Properties params = new Properties();
        for (int i = 0; i < numOfParams; i++) {
            params.setProperty(paramObject.paramName(i), (String) paramObject.paramValue(i));
        }
        return params;
    }

}
