package logfileclustervisualization

class ModelCreationController {
def ModelCreationService;
    def index(){
        def message = "Congratulations, you have successfully initialized the application. There are remaining jobs. Please each jobs one by one."
         render(view: "index", model: [message: message])

    }
    def create(){
        def data = ModelCreationService.createModule()
          if(data){
            redirect(controller: 'CreateCluster', action: 'index')
        }
        else {
            render(view: "index", model: [message: "Model creation is not completed succesfully. Please check the server run condition."])
        }
//        def message = "Model creation is "+data
//        redirect(controller: 'Cluster', action: 'index',params:[message: message])

    }
    
}
