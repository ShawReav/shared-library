def call(toolbelt,SF_DELTA_FOLDER,DEPLOYDIR,String SF_USERNAME,TEST_LEVEL) {
  if (DEPLOYMENT_TYPE == 'DELTA')
            		{
            			if (isUnix()) 
				{
                			rc = sh "${toolbelt}sfdx force:source:deploy -p ${SF_DELTA_FOLDER}/${DEPLOYDIR} -u ${SF_USERNAME} -w 500 -l ${TEST_LEVEL}"
            			}
				else	
				{
	         			rc = command "${toolbelt}sfdx force:source:deploy -p ${SF_DELTA_FOLDER}/${DEPLOYDIR} -u ${SF_USERNAME} -w 500 -l ${TEST_LEVEL}"
            			}
            		}
            		else
            		{
            			if (isUnix()) 
				{
                			rc = sh "${toolbelt}sfdx force:source:deploy -p ${DEPLOYDIR} -u ${SF_USERNAME} -w 500 -l ${TEST_LEVEL}"
            			}
				else	
				{
	         			rc = command "${toolbelt}sfdx force:source:deploy -p ${DEPLOYDIR} -u ${SF_USERNAME} -w 500 -l ${TEST_LEVEL}"
            			}
            		}
		    	if (rc != 0) 
				{
				error 'Component Validation Failed.'
		    		}

}
