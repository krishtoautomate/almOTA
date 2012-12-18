package HPQC;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.hyades.execution.runtime.datapool.IDatapoolRecord;

import resources.HPQC.RunHPQCTestsHelper;
import HPQC.OTA.DesignStep;
import HPQC.OTA.TDConnection;
import HPQC.OTA.TSTest;
import HPQC.OTA.Test;
import HPQC.OTA.TestSet;
import HPQC.OTA.TestSetFolder;
import TestData.DataFactory;

import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
import com4j.Com4jObject;
/**
 * Description   : Functional Test Script
 * @author wangken
 */
public class RunHPQCTests extends RunHPQCTestsHelper
{
    
    private final String URL = "http://hscptonywhap002:8080/qcbin";
    private final String DOMAIN = "MCYS";
    private final String PROJECT = "DSCIS";
    private final String USERNAME = "wangken";
    private final String PASSWORD = EncryptUtil.decrypt("U29tZXNoaXQwNg==");
    
    private final String TS_FOLDER = "Root\\Release 3.2 Testing";
    private final String TS_FILTER = "";
    private final String TI_FILTER = "";
    
    /**
     * Script Name   : <b>test</b>
     * Generated     : <b>2012-06-05 3:49:23 PM</b>
     * Description   : Functional Test Script
     * Original Host : WinNT Version 5.1  Build 2600 (S)
     * 
     * @since  2012/06/05
     * @author wangken
     */
    public void testMain(Object[] args) {
        TDConnection qcConnection = new TDConnection(URL, DOMAIN, PROJECT);
        qcConnection.connect(USERNAME, PASSWORD);
        try {
            TestSetFolder testSetFolder = qcConnection.getTestSetFolder(TS_FOLDER);
            TestSet[] testSets = testSetFolder.getTestSets(TS_FILTER);
            TSTest[] testInstances;
            for (TestSet testSet : testSets) {
                logInfo("STARTING TEST SET : '" + testSet.getName() + "'");
                testInstances = testSet.getTestInstances(TI_FILTER);
                //IRun run;
                for (TSTest testInstance : testInstances) {
                    Test test = testInstance.getTest();
                    System.out.println(test.getPath());
//                    DesignStep[] designSteps = test.getDesignSteps("");
//                    for (DesignStep designStep : designSteps) {
//                        System.out.println(designStep.getName());
//                        System.out.println(designStep.getDescription());
//                        System.out.println(designStep.getExpectedResult());
//                    }
                    //HPQCConnectionUtil.getParamsFromTestInstance(testInstance);
                    //logInfo("STARTING TEST INSTANCE : '" + testInstance.testName() + "'\nWITH PARAMS : '" + scriptArgs[1] + "'");
                    //System.out.println(HPQCConnectionUtil.getTestCasePath(testInstance));
                    //callScript("", scriptArgs);
                    //run = HPQCConnectionUtil.createNewRun(testInstance, true);
                    //run.status("passed");
                    //HPQCConnectionUtil.attachAttachmentToRun(run, "C:\\Documents and Settings\\wangken\\Desktop\\with o as an object.txt");
                }
            }
        } catch (Exception e) {
            
        } finally {
            qcConnection.disconnect();
        }
    }
}

