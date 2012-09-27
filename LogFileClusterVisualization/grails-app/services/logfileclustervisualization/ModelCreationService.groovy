package logfileclustervisualization
import generatemodule.LogModuleCreator;
import global.Global;
class ModelCreationService {

//    def dumpdir = Global.dumDir;
def dumpdir = "D:/Major/DumpLogs"
    def createModule() {
        def LogModuleCreator createLogModule = new LogModuleCreator(dumpdir);
        
        if(createLogModule.fillDatabaseFirstPass()&&createLogModule.createModuleSecondPass()){
            return true;
        }
        else return false;
    }
}
