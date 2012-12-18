package HPQC.OTA;

import java.util.Iterator;

import hpqc.otaclient.IAttachment;
import hpqc.otaclient.IAttachmentFactory;
import hpqc.otaclient.IBaseFactory;
import hpqc.otaclient.IExtendedStorage;
import hpqc.otaclient.IList;
import hpqc.otaclient.IRun;
import hpqc.otaclient.IStep;
import hpqc.otaclient.ITDFilter;
import com4j.Com4jObject;

public class Run {
    
    public class Fields {
        public static final String HOST_NAME = "RN_HOST";
    }
    
    private IRun run_;

    public Run(Com4jObject run) {
        run_ = run.queryInterface(IRun.class);
    }
    
    public Run(IRun run) {
        run_ = run;
    }

    public void field(String fieldName, String fieldVal) {
        run_.field(fieldName, fieldVal);
    }

    public void autoPost(boolean autoPost) {
        run_.autoPost(autoPost);
    }
    
    public Step[] getSteps(String filter) {
        IBaseFactory stepFactory = run_.stepFactory().queryInterface(IBaseFactory.class);
        IList stepList = stepFactory.newList(filter);
        Step[] steps = new Step[stepList.count()];
        Iterator<Com4jObject> stepIter = stepList.iterator();
        int i = 0;
        while (stepIter.hasNext()) {
            steps[i] = new Step(stepIter.next());
            i ++;
        }
        return steps;
    }
    
    public Step[] getSteps(ITDFilter filter) {
        return getSteps(filter.text());
    }
    
    public void attachAttachment(String filePath) {
        IAttachmentFactory attachmentFactory = run_.attachments().queryInterface(IAttachmentFactory.class);
        int dirSplitPos = filePath.lastIndexOf("\\") + 1;
        String fileDir = filePath.substring(0, dirSplitPos);
        String fileName = filePath.substring(dirSplitPos);
        IAttachment attachment = attachmentFactory.addItem(fileName).queryInterface(IAttachment.class);
        attachment.post();
        IExtendedStorage extendedStorage = attachment.attachmentStorage().queryInterface(IExtendedStorage.class);
        extendedStorage.clientPath(fileDir);
        extendedStorage.save(fileName, true);
    }

}
