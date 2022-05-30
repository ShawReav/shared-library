def call() {
  if (DEPLOYMENT_TYPE == 'DELTA'){	
                  if (isUnix()) 
        {
                      rc = sh "${toolbelt}sfdx sfpowerkit:project:diff -d ${SF_DELTA_FOLDER} -r ${SF_SOURCE_COMMIT_ID} -t ${SF_TARGET_COMMIT_ID}"
                  }
        else
        {
                rc = command "${toolbelt}sfdx sfpowerkit:project:diff -d ${SF_DELTA_FOLDER} -r ${SF_SOURCE_COMMIT_ID} -t ${SF_TARGET_COMMIT_ID}"
                  }
            if (rc != 0) 
        {
          error 'Delta Package Creation failed.'
            }
              }
              else{
                    echo "Deployment is for All Components from Repository"
              }
}
