
function checkFormInstaller(form){

    var error = "";
    var projectName = form.projectName.value;
    var serverDataBase = form.serverDataBase.value;
    var userDataBase = form.userDataBase.value;
    var passwordDataBase = form.passwordDataBase.value;
    var dataBaseName = form.dataBaseName.value;
    var dataBasePort = form.dataBasePort.value;
    var userGlassfish = form.userGlassfish.value;
    var passwordGlassfish = form.passwordGlassfish.value;
    var glassfishHome = form.glassfishHome.value;
    var glassfishWebPort = form.glassfishWebPort.value;


    if(projectName == ""){
        error = "-project name is null\n";
    }

    if(projectName == "projectName"){
        error = "-project name must be different\n";
    }

    if(projectName.search("ssn_")){
        if(error.length == 0){
            form.projectName.value = "ssn_" + form.projectName.value;
        }        
    }

    if(form.projectName.length <= 4){
        error += "-the project name must be contain ssn_ + name of project\n "+projectName.length;
    }

    if(serverDataBase == ""){
        error += "-server database is null\n";
    }

    if(userDataBase == ""){
        error += "-user database is null\n";
    }

    if(passwordDataBase == ""){
        error += "-password database is null\n";
    }

    if(dataBaseName == "" || dataBaseName.search("ssn_")){
        if(error.length == 0){
            form.dataBaseName.value = form.projectName.value;
        }
    }

    if(dataBasePort == ""){
        error += "-port database is null\n";
    }

    if(isNaN(dataBasePort)){
        error += "-database Port should be a number\n";
    }

    if(userGlassfish == ""){
        error += "-user glassfish is null\n";
    }

    if(passwordGlassfish == ""){
        error += "-password glassfish is null\n";
    }

    if(glassfishHome == ""){
        error += "-glassfish home is null\n";
    }

    if(glassfishWebPort == ""){
        error += "-glassfish Web Port is null\n";
    }

    if(isNaN(glassfishWebPort)){
        error += "-glassfish Web Port should be a number\n";
    }    

    if(error != ""){
        alert("The following errors have occurred: \n\n" + error + "\nPlease correct the errors and continue with install");
    }else{

        var answer = confirm("are you sure of this?");
        if (answer){
            form.submit();
        }
        else{
            alert("operation cancelated")
            form.reset();
        }
    }

} // end checkFormInstaller