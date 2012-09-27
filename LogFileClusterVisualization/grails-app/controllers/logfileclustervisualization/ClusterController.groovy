package logfileclustervisualization

class ClusterController {

    def index() { 
        def message = "Model is successfully created."
        render(view: "index", model: [message: message])
    }
    def cluster(){
        def message = "Clusters are created successfully"
        def CreateClusterService;
        if(CreateClusterService.clusterService()){        
            redirect(controller: "Main", action:"index")
        }
        else{
            render(view: "index", model: [message: message])
        }
    }
}
