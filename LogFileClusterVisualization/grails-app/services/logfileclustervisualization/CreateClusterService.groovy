package logfileclustervisualization
import main.MajorBagOfWords

class CreateClusterService {
    def createcluster = new MajorBagOfWords()
    def clusterService() {
        if(createcluster.mainMethod()){
            return true
        }
        else {return false}
    }
}
