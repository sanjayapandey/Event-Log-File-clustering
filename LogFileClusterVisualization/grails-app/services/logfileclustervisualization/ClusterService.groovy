/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logfileclustervisualization
import logfileclustering.ClusterChooser;
import inserttothecluster.MajorBagOfWords;
import filenames.FilesViewer;
import clustercontentdisplay.ClusterInformer;
import clusterlogcount.ClusterLogCounter;
/**
 *
 * @author lnkhanal
 */
class ClusterService { 
    ClusterChooser clusterchooser = new ClusterChooser()
    ClusterInformer clusterinformer = new ClusterInformer()
    MajorBagOfWords insert = new MajorBagOfWords();
    FilesViewer fileviewer = new FilesViewer();
    ClusterLogCounter clusterlog = new ClusterLogCounter()
    
    def makeList(){
        def files = fileviewer.showFileNames().split(":")
        def fileCount = files.length;
        def myFile,fileInfo=""
        for(int i = 0; i<fileCount; i++){
            myFile = files[i].split(",")
            fileInfo = fileInfo+String.format('<li><input type = "radio" name = "cluster" value = "'+myFile[1]+'" />'+myFile[0]+'</li>')
        }
        return fileInfo
    }
    def clusterInformation() {
        def clusterInfo = clusterchooser.showClusters()
        def clusters = clusterInfo.split(",")
        def clusterCount = clusters.length
        def first = "[{  type: 'pie',  name: 'log file counter',  data: [ ";
        def data =first
        def last = "]}]"
        def comma = ","
        for(int i = 0; i<clusterCount;i++){
            if(i == clusterCount-1){
                comma = "";
            }
            def info = clusters[i].split(":")
            data += String.format(" ['"+info[0]+"',"+info[1]+"]"+comma)          
        }
        data += last
        
        return data
    }
    def insertMessageToTheCluster(String message){
       
        insert.callMethods(message)
    
        def data = clusterInformation()
        def fileInfo = makeList()
        data = String.format(data+"CHAR"+fileInfo)
    
        return data
    }
    def listFileContents(String clusterName){
        String message = clusterinformer.showClusterInfo(clusterName);
        def fileInfo = makeList()
        return String.format(message+"CHAR"+fileInfo)
    }
    def clusterLogCount(){
        def counts = clusterlog.countClusterLog()
        //        def totalClusters = counts[0]
        //        def totalMessages = counts[1]
        return counts
    }
    
	
}

