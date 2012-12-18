package HPQC.OTA;

import hpqc.otaclient.ClassFactory;
import hpqc.otaclient.ITDConnection;
import hpqc.otaclient.ITestSetFolder;
import hpqc.otaclient.ITestSetTreeManager;

public class TDConnection {
    
    private ITDConnection tdConnection_;
    private String url_;
    private String domainName_;
    private String projectName_;
    
    public TDConnection(String url, String domainName, String projectName) {
        url_ = url;
        domainName_ = domainName;
        projectName_ = projectName;
        tdConnection_ = ClassFactory.createTDConnection();
    }
    
    public void connect(String userName, String password) {
        tdConnection_.initConnectionEx(url_);
        tdConnection_.connectProjectEx(domainName_, projectName_, userName, password);
    }
    
    public void disconnect() {
        tdConnection_.disconnectProject();
        tdConnection_.releaseConnection();
    }
    
    public TestSetFolder getTestSetFolder(String tsFolderPath) {
        ITestSetTreeManager tsTreeManager = tdConnection_.testSetTreeManager().queryInterface(ITestSetTreeManager.class);
        return new TestSetFolder(tsTreeManager.nodeByPath(tsFolderPath));
    }

}
