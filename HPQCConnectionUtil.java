package HPQC;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import com4j.Com4jObject;

import hpqc.otaclient.ClassFactory;
import hpqc.otaclient.IAttachment;
import hpqc.otaclient.IAttachmentFactory;
import hpqc.otaclient.IBaseFactory;
import hpqc.otaclient.IDesignStep;
import hpqc.otaclient.IExtendedStorage;
import hpqc.otaclient.IList;
import hpqc.otaclient.IParam;
import hpqc.otaclient.IRun;
import hpqc.otaclient.IRunFactory;
import hpqc.otaclient.IStep;
import hpqc.otaclient.ISubjectNode;
import hpqc.otaclient.ITDConnection;
import hpqc.otaclient.ITDFilter;
import hpqc.otaclient.ITSTest;
import hpqc.otaclient.ITest;
import hpqc.otaclient.ITestSet;
import hpqc.otaclient.ITestSetFolder;
import hpqc.otaclient.ITestSetTreeManager;

public class HPQCConnectionUtil {
    
    public static String genRunName() {
        SimpleDateFormat format = new SimpleDateFormat("M-d_k-m-s");
        return "Rftrun_" + format.format(new Date());
    }
    
    public static String genHostName() {
        String hostName = System.getenv("COMPUTERNAME");
        if (hostName == null) hostName = "";
        return hostName;
    }

}
