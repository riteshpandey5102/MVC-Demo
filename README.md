#### Architecture Pattern 
Architectural patterns provide a structured approach for organizing code and separating concerns, making it easier to manage complexity and promote code reusability.

__Why does your app need good architecture?__
A simple answer is that everything should be organized in a proper way. So, the project becomes easily testable, scalable, manageable, robust and modular.  
`If we don’t use a right architecture pattern to build our project, we will face many issues such as-`
- __Difficult to test -__ Since large codes are unorganized so it’s difficult to completely test any single component.
- __Difficult to maintain -__ Unorganized code make difficult to keep track of the methods inside a class which makes difficult to improve or maintain it.
- __Difficult to scale -__ Unorganized code doesn’t have proper modularity which makes difficult to understand the existing features and add new features to it.

##### There are 3 architecture pattern to organize our code
- [Model view controller](https://github.com/riteshpandey5102/MVC-Demo)
- [Model view presenter](https://github.com/riteshpandey5102/MVP-Demo)
- [Model view viewmodel](https://github.com/riteshpandey5102/MVVM-Demo)

In this project we will learn about the first pattern Model view controller 
### Model View Controller
In this architecture pattern we divide our project in 3 layers
__Model:__ The model layer is responsible for storing and retrieving data. It also notifies controller about data operation result. So, it is also depended on controller.
__View:__ The View layer is used to display the data on user interface and also handle the user inputs.
It gets data directly from model when data is ready and call controller for any data operation. So, it is depended on both model and controller. Also, it has some logical methods to transform the data into required format.
__Controller:__ It is used as bridge between model and view. 
When view need any data from database it will communicate controller and controller will ask model for that data and when the data is ready model will notify controller and controller will notify view to get the data from model. 
Also, when view need to store or modify something in database it will communicate with controller and controller will send it to model to process it further.
![Model View Controller](https://github.com/riteshpandey5102/MVC-Demo/blob/master/MVC.jpg?raw=true)

#### Problems in MVC
- It doesn’t follow unidirectional data flow which makes it complex
- In this architecture view have direct reference of both model and controller. But due to this we need also mock both model and controller to view while testing and also make changes in view while changes occur in model or controller which makes the view difficult to test and maintain.
- The controller has also reference of both view and model which makes It difficult to test and maintain.
- Model have reference of controller so it can notify the controller about success or failure of data operation. Since, Model is also not independent which it difficult to test and maintain.
- Here controller doesn’t pass the data directly to view it will inform the view that the data is ready or not then view fetch the result from model and apply formatting on it and the show it to UI. Which increases view complexity
- The main purpose of architectural pattern is separate the code in independent components so that they can be easily tested and managed but in MVC there is tight coupling between some components such as-
    - View is depended on controller and model 
    - Controller is depended on view and model
    - Model is depended on Controller
  
     Such dependency increases the code complexity and makes it difficult to test separately.

##### More Links
##### [Model view presenter](https://github.com/riteshpandey5102/MVP-Demo)
##### [Model view viewmodel](https://github.com/riteshpandey5102/MVVM-Demo)

